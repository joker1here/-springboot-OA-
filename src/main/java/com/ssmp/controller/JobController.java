package com.ssmp.controller;

import com.ssmp.pojo.Job;
import com.ssmp.service.IJobService;
import com.ssmp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private IJobService iJobService;

    /**
     * 查询所有职位，使用Get请求不带参数
     * http://localhost/Job
     * @return List<Job>
     */
    @GetMapping
    public Result getAll() {
        return Result.ok(iJobService.list());
    }

    /**
     * 查询单个职位，需带参数id，使用Restful方式传参
     * http://localhost/Job/1
     * @param  id 职位id
     * @return Job
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.ok(iJobService.getById(id));
    }

    /**
     * 添加操作，需使用Post方式传入一个对象
     * @param Job id
     * @return boolean
     */
    @PostMapping
    public Result add(@RequestBody Job Job){
        return Result.ok(iJobService.save(Job));
    }

    /**
     * 更新操作，需使用Put方式传入一个对象
     * @param Job id
     * @return Result
     */
    @PutMapping
    public Result update(@RequestBody Job Job) {
        return Result.ok(iJobService.updateById(Job));
    }

    /**
     * 删除操作，需使用Delete方式传入一个id
     * @param id id
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.ok(iJobService.removeById(id));
    }

    /**
     * 分页列表
     * @param currentPage 当前页
     * @param pageSize 页码数据条数
     * @return IPage<Job>
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public Result page(@PathVariable int currentPage,@PathVariable int pageSize){
        return Result.ok(iJobService.getPage(currentPage, pageSize));
    }

}
