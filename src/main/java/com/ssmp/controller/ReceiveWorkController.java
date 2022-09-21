package com.ssmp.controller;

import com.ssmp.pojo.Employee;
import com.ssmp.pojo.Work;
import com.ssmp.service.IWorkService;
import com.ssmp.utils.Result;
import com.ssmp.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receiveWork")
public class ReceiveWorkController {
    @Autowired
    private IWorkService iWorkService;

    /**
     * 查询所有接收到的文件，使用Get请求参数为0查询收信箱，参数为1查询发信箱
     * http://localhost/Work?1
     * @return List<Work>
     */
    @GetMapping
    public Result findAll() {
        
        Employee employee = SessionUtil.getEmployee();
        if (employee==null){
            return Result.fail("没有登陆");
        }
        return Result.ok(iWorkService.findReceived(employee.getEmployeeId()));
    }


    /**
     * 查询单个文件，需带参数id，使用Restful方式传参
     * http://localhost/Work/1
     * @param  id 文件id
     * @return Work
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.ok(iWorkService.findById(id));
    }

    /**
     * 添加操作，需使用Post方式传入一个对象
     * @param Work 文件id
     * @return boolean
     */
    @PostMapping
    public Result add(@RequestBody Work Work){
        return Result.ok(iWorkService.save(Work));
    }

    /**
     * 需使用Put方式传入一个对象
     * @return boolean
     */
    @PutMapping
    public Result update(@RequestBody Work work) {
        System.out.println("===>"+work);
        return Result.ok(iWorkService.updateById(work));
    }

    /**
     * 删除操作，需使用Delete方式传入一个id
     * @param id 文件id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.ok(iWorkService.removeById(id));
    }

    /**
     * 分页列表
     * @param currentPage 当前页
     * @param pageSize 页码数据条数
     * @return IPage<Work>
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public Result page(@PathVariable int currentPage,@PathVariable int pageSize,Work work){
        return Result.ok(iWorkService.getReceivePage(currentPage, pageSize,work));
    }

}
