package com.ssmp.controller;

import com.ssmp.pojo.Dept;
import com.ssmp.service.IDeptService;
import com.ssmp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private IDeptService iDeptService;

    /**
     * 查询所有部门，使用Get请求不带参数
     * http://localhost/Dept
     * @return Result
     */
    @GetMapping
    public Result getAll() {
        return Result.ok(iDeptService.list());
    }

    /**
     * 查询单个部门，需带参数id，使用Restful方式传参
     * http://localhost/Dept/1
     * @param  id 部门id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.ok(iDeptService.getById(id));
    }

    /**
     * 添加操作，需使用Post方式传入一个对象
     * @param Dept id
     * @return Result
     */
    @PostMapping
    public Result add(@RequestBody Dept Dept){
        return Result.ok(iDeptService.save(Dept));
    }

    /**
     * 更新操作，需使用Put方式传入一个对象
     * @param Dept id
     * @return Result
     */
    @PutMapping
    public Result update(@RequestBody Dept Dept) {
        return Result.ok(iDeptService.updateById(Dept));
    }

    /**
     * 删除操作，需使用Delete方式传入一个id
     * @param id id
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.ok(iDeptService.removeById(id));
    }

    /**
     * 分页列表
     * @param currentPage 当前页
     * @param pageSize 页码数据条数
     * @return Result
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public Result page(@PathVariable int currentPage,@PathVariable int pageSize,Dept dept){
        return Result.ok(iDeptService.getPage(currentPage, pageSize,dept));
    }

}
