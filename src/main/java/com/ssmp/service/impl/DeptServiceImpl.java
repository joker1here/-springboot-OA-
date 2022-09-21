package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.DeptDao;
import com.ssmp.pojo.Dept;
import com.ssmp.service.IDeptService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements IDeptService {
    @Override
    public IPage<Dept> getPage(int currentPage, int pageSize,Dept dept) {
        IPage<Dept> ipage = new Page(currentPage, pageSize);
        LambdaQueryWrapper<Dept> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(dept.getDeptName()), Dept::getDeptName, dept.getDeptName());
        return page(ipage,lqw);
    }
}
