package com.ssmp.controller;

import com.ssmp.pojo.Employee;
import com.ssmp.pojo.File;
import com.ssmp.service.IFileService;
import com.ssmp.utils.Result;
import com.ssmp.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/receiveFile")
public class ReceiveFileController {
    @Autowired
    private IFileService iFileService;

    /**
     * 查询所有接收到的文件，使用Get请求参数为0查询收信箱，参数为1查询发信箱
     * http://localhost/file?1
     * @return List<file>
     */
    @GetMapping
    public Result findAll() {

        Employee employee = SessionUtil.getEmployee();
        if (employee==null){
            return Result.fail("没有登陆");
        }
        return Result.ok(iFileService.findReceived(employee.getEmployeeId()));
    }


    /**
     * 查询单个文件，需带参数id，使用Restful方式传参
     * http://localhost/file/1
     * @param  id 文件id
     * @return file
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.ok(iFileService.findById(id));
    }

    /**
     * 添加操作，需使用Post方式传入一个对象
     * @param file 文件id
     * @return boolean
     */
    @PostMapping
    public Result add(@RequestBody File file){
        return Result.ok(iFileService.save(file));
    }

    /**
     * 已读操作，需使用Put方式传入一个对象
     * @param file 文件id
     * @return boolean
     */
    @PutMapping
    public Result update(@RequestBody File file) {
        return Result.ok(iFileService.read(file));
    }

    /**
     * 删除操作，需使用Delete方式传入一个id
     * @param id 文件id
     * @return boolean
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.ok(iFileService.removeById(id));
    }

    /**
     * 分页列表
     * @param currentPage 当前页
     * @param pageSize 页码数据条数
     * @return IPage<file>
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public Result page(@PathVariable int currentPage,@PathVariable int pageSize){
        return Result.ok(iFileService.getReceivePage(currentPage, pageSize));
    }

}
