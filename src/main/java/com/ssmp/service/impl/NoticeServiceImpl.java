package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.NoticeDao;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Notice;
import com.ssmp.pojo.Work;
import com.ssmp.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements INoticeService {
    @Autowired
    private NoticeDao noticeDao;

    /**
     * 按条件查询分页
     * todo 没有实现
     * @param currentPage
     * @param pageSize
     * @param work
     * @return
     */
    @Override
    public IPage<Notice> getPage(int currentPage, int pageSize, Work work) {
        IPage<Notice> iPage = new Page<>(currentPage,pageSize);
        noticeDao.pageWithForeign(iPage);
        return iPage;
    }
}
