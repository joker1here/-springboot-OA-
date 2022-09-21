package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Dept;

import java.util.List;

public interface IDeptService extends IService<Dept> {
    IPage<Dept> getPage(int currentPage, int pageSize,Dept dept);
}
