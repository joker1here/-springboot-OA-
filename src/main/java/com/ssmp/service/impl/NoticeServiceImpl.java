package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.NoticeDao;
import com.ssmp.pojo.Notice;
import com.ssmp.service.INoticeService;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements INoticeService {
    @Override
    public IPage<Notice> getPage(int currentPage, int pageSize) {
        IPage<Notice> ipage = new Page(currentPage, pageSize);
        return page(ipage,null);
    }
}
