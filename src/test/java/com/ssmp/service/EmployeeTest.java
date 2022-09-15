package com.ssmp.service;

import com.ssmp.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class EmployeeTest {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Test
    void find(){
        System.out.println(iEmployeeService);
        List<Employee> list = iEmployeeService.list();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    @Test
    void find1(){
        System.out.println(iEmployeeService.getById(1));
    }
    @Test
    void add(){
        Employee employee = new Employee();
        employee.setEmployeeName("123");
        iEmployeeService.save(employee);
    }
}
