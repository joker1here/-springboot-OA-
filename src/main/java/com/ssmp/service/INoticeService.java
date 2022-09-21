package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Notice;
import com.ssmp.pojo.Work;

public interface INoticeService extends IService<Notice> {
    IPage<Notice> getPage(int currentPage, int pageSize, Work work);
}
