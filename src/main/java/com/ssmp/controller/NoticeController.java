package com.ssmp.controller;

import com.ssmp.pojo.Notice;
import com.ssmp.service.INoticeService;
import com.ssmp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Notice")
public class NoticeController {
    @Autowired
    private INoticeService iNoticeService;

    /**
     * 查询所有通知，使用Get请求不带参数
     * http://localhost/Notice
     * @return Result
     */
    @GetMapping
    public Result getAll() {
        return Result.ok(iNoticeService.list());
    }

    /**
     * 查询单个通知，需带参数id，使用Restful方式传参
     * http://localhost/Notice/1
     * @param  id 通知id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.ok(iNoticeService.getById(id));
    }

    /**
     * 添加操作，需使用Post方式传入一个对象
     * @param Notice id
     * @return Result
     */
    @PostMapping
    public Result add(@RequestBody Notice Notice){
        return Result.ok(iNoticeService.save(Notice));
    }

    /**
     * 更新操作，需使用Put方式传入一个对象
     * @param Notice id
     * @return Result
     */
    @PutMapping
    public Result update(@RequestBody Notice Notice) {
        return Result.ok(iNoticeService.updateById(Notice));
    }

    /**
     * 删除操作，需使用Delete方式传入一个id
     * @param id id
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.ok(iNoticeService.removeById(id));
    }

    /**
     * 分页列表
     * @param currentPage 当前页
     * @param pageSize 页码数据条数
     * @return Result
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public Result page(@PathVariable int currentPage,@PathVariable int pageSize){
        return Result.ok(iNoticeService.getPage(currentPage, pageSize));
    }

}
