package com.ssmp.controller;

import com.ssmp.pojo.Employee;
import com.ssmp.pojo.Todo;
import com.ssmp.service.ITodoService;
import com.ssmp.utils.Result;
import com.ssmp.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private ITodoService iTodoService;

    /**
     * 查询所有待做事项，使用Get请求不带参数
     * http://localhost/
     * @return List
     */
    @GetMapping
    public Result getAll() {
        
        Employee employee = SessionUtil.getEmployee();
        if (employee==null){
            return Result.fail("没有登陆");
        }
        return Result.ok(iTodoService.findAll(employee.getEmployeeId()));
    }

    /**
     * 查询单个待做事项，需带参数id，使用Restful方式传参
     * 
     * @param  id 待做事项id
     * @return 
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.ok(iTodoService.findById(id));
    }

    /**
     * 添加操作，需使用Post方式传入一个对象
     * @param 
     * @return boolean
     */
    @PostMapping
    public Result add(@RequestBody Todo Todo){
        return Result.ok(iTodoService.save(Todo));
    }

    /**
     * 更新操作，需使用Put方式传入一个对象
     * @param 
     * @return boolean
     */
    @PutMapping
    public Result update(@RequestBody Todo Todo) {
        return Result.ok(iTodoService.updateById(Todo));
    }

    /**
     * 删除操作，需使用Delete方式传入一个id
     * @param id 待做事项id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.ok(iTodoService.removeById(id));
    }

    /**
     * 分页列表
     * @param currentPage 当前页
     * @param pageSize 页码数据条数
     * @return IPage
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public Result page(@PathVariable int currentPage,@PathVariable int pageSize){
        return Result.ok(iTodoService.getPage(currentPage, pageSize));
    }

}
