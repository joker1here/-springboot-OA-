package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.JobDao;
import com.ssmp.pojo.Job;
import com.ssmp.service.IJobService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl extends ServiceImpl<JobDao, Job> implements IJobService {
    @Override
    public IPage<Job> getPage(int currentPage, int pageSize,Job job) {
        IPage<Job> ipage = new Page(currentPage, pageSize);
        LambdaQueryWrapper<Job> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(job.getJobName()), Job::getJobName, job.getJobName());
        return page(ipage,lqw);
    }
}
