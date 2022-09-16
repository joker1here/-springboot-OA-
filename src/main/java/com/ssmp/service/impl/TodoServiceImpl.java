package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.TodoDao;
import com.ssmp.pojo.Employee;
import com.ssmp.pojo.File;
import com.ssmp.pojo.Notice;
import com.ssmp.pojo.Todo;
import com.ssmp.service.IEmployeeService;
import com.ssmp.service.ITodoService;
import com.ssmp.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl extends ServiceImpl<TodoDao, Todo> implements ITodoService {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private TodoDao todoDao;
    /**
     * 查找属于用户的待做事项
     *
     * @param employeeId
     * @return
     */
    @Override
    public List<Todo> findAll(Integer employeeId) {
//        LambdaQueryWrapper<Todo> lqw = new LambdaQueryWrapper<>();
//        lqw.eq(Todo::getEmployeeId, employeeId);
//        List<Todo> list = list(lqw);
//        for (Todo todo : list) {
//            addForeign(todo);
//        }
        List<Todo> list = todoDao.findAllWithForeign(employeeId);
        return list;
    }

    @Override
    public Todo findById(Integer id) {
        Todo todo = getById(id);
        addForeign(todo);
        return todo;
    }

    @Override
    public IPage<Todo> getPage(int currentPage, int pageSize) {
//        IPage<Todo> iPage = new Page<>(currentPage,pageSize);
//        page(iPage);
//        //遍历一遍，加上外键
//        for (Todo todo : iPage.getRecords()) {
//            addForeign(todo);
//        }
        List<Todo> list = todoDao.pageWithForeign((currentPage - 1) * pageSize, pageSize, SessionUtil.getEmployee().getEmployeeId());
        IPage<Todo> iPage = new Page<>();
        iPage.setRecords(list);
        iPage.setTotal(count());
        return iPage;
    }

    private void addForeign(Todo todo) {
        todo.setEmployee(employeeService.findById(todo.getEmployeeId()));
    }
}
