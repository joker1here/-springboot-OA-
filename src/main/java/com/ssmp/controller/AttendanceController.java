package com.ssmp.controller;

import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Employee;
import com.ssmp.service.IAttendanceService;
import com.ssmp.utils.Result;
import com.ssmp.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private IAttendanceService iAttendanceService;

    /**
     * 查询所有签到信息，使用Get请求不带参数,
     * 太多了,频繁请求服务器，容易炸——已解决（大概
     * http://localhost/Attendance
     * @return List<Attendance>
     */
    @GetMapping
    public Result getAll() {
        return Result.ok(iAttendanceService.findAll());
    }

    /**
     * 分页列表
     * @param currentPage 当前页
     * @param pageSize 页码数据条数
     * @param attendance 查询条件
     * @return IPage<Attendance>
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public Result page(@PathVariable int currentPage, @PathVariable int pageSize, Attendance attendance){
        return Result.ok(iAttendanceService.getPage(currentPage, pageSize,attendance));
    }


    /**
     * 签到操作
     * @return Result
     */
    @PostMapping
    public Result signUp(){
        Employee employee = SessionUtil.getEmployee();
        if (employee==null){
            return Result.fail("没有登陆");
        }
        return iAttendanceService.signUp(employee.getEmployeeId());
    }

    /**
     * 签退操作，传入用户id
     * @return Result
     */
    @PutMapping
    public Result signBack(){
        Employee employee = SessionUtil.getEmployee();
        if (employee==null){
            return Result.fail("没有登陆");
        }
        return iAttendanceService.Back(employee.getEmployeeId());
    }

}
