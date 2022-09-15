package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.pojo.Attendance;
import com.ssmp.utils.Result;

import java.util.List;

public interface IAttendanceService extends IService<Attendance> {
    /**
     * 重写查找所有签到信息的方法，补上外键信息
     * @return List<Attendance>
     */
    List<Attendance> findAll();

    /**
     * 重写分页方法
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Attendance> getPage(int currentPage, int pageSize);

    /**
     * 签到
     * @param id
     * @return
     */
    Result signUp(Integer id);

    /**
     * 签退
     * @param id
     * @return
     */
    Result Back(Integer id);
}
