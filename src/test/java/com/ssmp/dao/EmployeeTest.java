package com.ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssmp.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;

@SpringBootTest
public class EmployeeTest {
    @Autowired
    private EmployeeDao employeeDao;
    @Test
    void testGetByid(){
        Employee employee = employeeDao.selectById(1);
        System.out.println(employee);
    }
    @Test
    void save(){
        Employee employee = new Employee();
        employee.setEmployeeName("123");
        employee.setDeptId(1);
        employee.setJobId(1);
        employeeDao.insert(employee);
    }
    @Test
    void delete(){
        employeeDao.deleteById(43);
    }
    @Test
    void page(){
        IPage iPage = new Page(1, 3);
        employeeDao.selectPage(iPage, null);
        System.out.println(iPage.getRecords());
    }

    //条件查询
    @Test
    void getBy() {
        QueryWrapper<Employee> qw = new QueryWrapper<>();
        qw.like("employee_name", "ker");
        employeeDao.selectList(qw);
    }
    @Test//推荐
    void getBy2(){
        String name = null;
        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<Employee>();
        lqw.like(name!=null,Employee::getEmployeeName, name);
        employeeDao.selectList(lqw);
    }
}
