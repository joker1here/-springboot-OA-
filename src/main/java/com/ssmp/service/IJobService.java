package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Job;

public interface IJobService extends IService<Job> {
    IPage<Job> getPage(int currentPage, int pageSize);
}
