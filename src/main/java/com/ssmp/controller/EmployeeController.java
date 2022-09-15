package com.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.pojo.Employee;
import com.ssmp.service.IEmployeeService;
import com.ssmp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * 查询所有员工，使用Get请求不带参数
     * http://localhost/employee
     * @return List<Employee>
     */
    @GetMapping
    public Result getAll() {
        return Result.ok(iEmployeeService.findAll());
    }

    /**
     * 查询单个员工，需带参数id，使用Restful方式传参
     * http://localhost/employee/1
     * @param  id 员工id
     * @return Employee
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.ok(iEmployeeService.findById(id));
    }

    /**
     * 添加操作，需使用Post方式传入一个对象
     * @param employee 员工id
     * @return boolean
     */
    @PostMapping
    public Result add(@RequestBody Employee employee){
        return Result.ok(iEmployeeService.save(employee));
    }

    /**
     * 更新操作，需使用Put方式传入一个对象
     * @param employee 员工id
     * @return boolean
     */
    @PutMapping
    public Result update(@RequestBody Employee employee) {
        return Result.ok(iEmployeeService.updateById(employee));
    }

    /**
     * 删除操作，需使用Delete方式传入一个id
     * @param id 员工id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.ok(iEmployeeService.removeById(id));
    }

    /**
     * 分页列表
     * @param currentPage 当前页
     * @param pageSize 页码数据条数
     * @return IPage<Employee>
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public Result page(@PathVariable int currentPage,@PathVariable int pageSize){
        return Result.ok(iEmployeeService.getPage(currentPage, pageSize));
    }

}
