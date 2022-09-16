package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.EmployeeDao;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Employee;
import com.ssmp.service.IDeptService;
import com.ssmp.service.IEmployeeService;
import com.ssmp.service.IJobService;
import com.ssmp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements IEmployeeService {
    @Autowired
    private IJobService jobService;
    @Autowired
    private IDeptService deptService;

    @Autowired
    private EmployeeDao employeeDao;
    /**
     * 为List<Employee>添加外键
     *
     * @return
     */
    @Override
    public List<Employee> findAll() {
//        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<Employee>();
//        lqw.orderByDesc(Employee::getUserLevel);
//        List<Employee> list = list(lqw);
        List<Employee> list = employeeDao.findWithForeign();
        for (Employee employee : list) {
            addForeign(employee);
        }
        return list;
    }

    /**
     * 按id查找的结果添加外键
     *
     * @param id
     * @return
     */
    @Override
    public Employee findById(Integer id) {
        Employee employee = getById(id);
        addForeign(employee);
        return employee;
    }

    /**
     * 重写分页
     *
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return IPage
     */
    @Override
    public IPage<Employee> getPage(int currentPage, int pageSize) {
//        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<Employee>();
//        lqw.orderByDesc(Employee::getUserLevel);
//        IPage<Employee> iPage = new Page<>(currentPage,pageSize);
//        page(iPage,lqw);
//        //遍历一遍，加上外键和计算分钟
//        for (Employee employee : iPage.getRecords()) {
//            addForeign(employee);
//        }
        IPage<Employee> iPage = new Page<>(currentPage,pageSize);
        List<Employee> list = employeeDao.pageWithForeign((currentPage - 1) * pageSize, pageSize);
        iPage.setRecords(list);
        iPage.setTotal(count());
        return iPage;
    }

    /**
     * 登陆功能，验证用户名和密码
     *
     * @param name 用户名
     * @param pwd  密码
     * @param session
     * @return boolean
     */
    @Override
    public Result login(String name, String pwd, HttpSession session) {
        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<>();
        lqw.eq(name != null, Employee::getEmployeeName, name).and(i->i.eq(pwd != null, Employee::getPwd, pwd));
        Employee employee = getOne(lqw);
        if (employee == null) {
            return Result.fail("用户名或者密码错误！");
        }
        addForeign(employee);
        session.setAttribute("employee",employee);
        return Result.ok(employee);
    }

    /**
     * 为Employee添加Job和Dept外键，因为是地址运算，不用返回实体
     * @param employee
     */
    private void addForeign(Employee employee) {
        employee.setJob(jobService.getById(employee.getJobId()));
        employee.setDept(deptService.getById(employee.getDeptId()));
    }
}
