package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.AttendanceDao;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Employee;
import com.ssmp.service.IAttendanceService;
import com.ssmp.service.IEmployeeService;
import com.ssmp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceDao, Attendance> implements IAttendanceService {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private AttendanceDao attendanceDao;

    /**
     * 重写查找所有签到信息的方法，补上外键信息
     *
     * @return List<Attendance>
     */
    @Override
    public List<Attendance> findAll() {
        List<Attendance> list = attendanceDao.findAllWithForeign();
        return list;
    }

    /**
     * 重写分页方法
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return IPage<Attendance>
     */
    @Override
    public IPage<Attendance> getPage(int currentPage, int pageSize,Attendance attendance) {
        IPage<Attendance> iPage = new Page<>(currentPage,pageSize);
        attendanceDao.pageWithForeign(iPage);
        return iPage;
    }

    /**
     * 签到
     * @param id 用户id
     * @return Result
     */
    @Override
    public Result signUp(Integer id) {
        if (alreadySignUp(id)) {
            return Result.fail("已经签到过了，请签退！");
        }
        Attendance attendance = new Attendance();
        attendance.setAttendanceEmployee(id);
        attendance.setSignUpTime(getDate());
        return Result.ok(save(attendance));
    }

    /**
     * 签退
     * @param id 用户id
     * @return Result
     */
    @Override
    public Result Back(Integer id) {
        if (!alreadySignUp(id)) {
            return Result.fail("还没有签到，请先签到！");
        }
        Attendance attendance = check(id);
        attendance.setSignBackTime(getDate());
        return Result.ok(updateById(attendance));
    }

    /**
     * 为Attendance添加外键和计算工作时长，因为是地址运算，不用返回实体
     *  先不删除
     * @param attendance
     */
    private void addForeign(Attendance attendance) {
        attendance.setEmployee(employeeService.findById (attendance.getAttendanceEmployee()));
        attendance.setMinutes(minsBetween(attendance.getSignBackTime(),attendance.getSignUpTime()));
    }

    /**
     * 计算两个日期的差值
     * @param date1 签到日期
     * @param date2 签退日期
     * @return 分钟数
     */
    public static int minsBetween(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        if (date1 == null || date2 == null) {
            return 0;
        }
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        //算上当天
        return Math.abs(Integer.parseInt(String.valueOf((time2 - time1) / 60000L)) + 1);
    }

    /**
     * 判断是否已经签到过
     * @param employeeId 用户id
     * @return
     */
    public boolean alreadySignUp(int employeeId) {
        //没有记录，则没签到
        if (check(employeeId) == null) {
            return false;
        }
        return true;
    }

    /**
     * 查找签到且没签退记录
     * @param employeeId
     * @return
     */
    public Attendance check(int employeeId) {
        LambdaQueryWrapper<Attendance> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Attendance::getAttendanceEmployee, employeeId).//id相等
                and(i -> i.isNotNull(Attendance::getSignUpTime).//存在签到
                        and(p -> p.isNull(Attendance::getSignBackTime)));//不存在签退
        return getOne(lqw);
    }
    //获取当前时间
    public Date getDate(){
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return date;
    }

}
