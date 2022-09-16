package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.NoticeDao;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Notice;
import com.ssmp.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements INoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public IPage<Notice> getPage(int currentPage, int pageSize) {
//        LambdaQueryWrapper<Notice> lqw = new LambdaQueryWrapper<Notice>();
//        lqw.orderByDesc(Notice::getNoticeTime);
//        IPage<Notice> ipage = new Page(currentPage, pageSize);
        List<Notice> list = noticeDao.pageWithForeign((currentPage - 1) * pageSize, pageSize);
        IPage<Notice> iPage = new Page<>();
        iPage.setRecords(list);
        iPage.setTotal(count());
        return iPage;
    }
}
