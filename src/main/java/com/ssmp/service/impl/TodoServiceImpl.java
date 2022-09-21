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
    public IPage<Todo> getPage(int currentPage, int pageSize,Todo todo) {
        IPage<Todo> iPage = new Page<>(currentPage,pageSize);
        todoDao.pageWithForeign(iPage,SessionUtil.getEmployee().getEmployeeId());
        return iPage;
    }

    private void addForeign(Todo todo) {
        todo.setEmployee(employeeService.findById(todo.getEmployeeId()));
    }
}
