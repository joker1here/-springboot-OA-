package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.WorkDao;
import com.ssmp.pojo.Employee;
import com.ssmp.pojo.Work;
import com.ssmp.service.IEmployeeService;
import com.ssmp.service.IWorkService;
import com.ssmp.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl extends ServiceImpl<WorkDao, Work> implements IWorkService {
    @Autowired
    private IEmployeeService employeeService;

    @Override
    public IPage<Work> getPage(int currentPage, int pageSize) {
        IPage<Work> iPage = new Page<>(currentPage,pageSize);
        page(iPage);
        //遍历一遍，加上外键和计算分钟
        for (Work Work : iPage.getRecords()) {
            addForeign(Work);
        }
        return iPage;
    }

    @Override
    public Work findById(Integer id) {
        Work Work = getById(id);
        addForeign(Work);
        return Work;
    }

    @Override
    public List<Work> findReceived(Integer employeeId) {
        LambdaQueryWrapper<Work> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Work::getWorkTo, employeeId);
        List<Work> list = list(lqw);
        for (Work Work : list) {
            addForeign(Work);
        }
        return list;
    }

    @Override
    public List<Work> findSend(Integer employeeId) {
        LambdaQueryWrapper<Work> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Work::getEmployeeId, employeeId);
        List<Work> list = list(lqw);
        for (Work Work : list) {
            addForeign(Work);
        }
        return list;
    }

    /**
     * 已读和未读操作
     * @param Work
     * @param percentage
     * @return
     */
    @Override
    public Boolean read(Work Work, Integer percentage) {
        Work.setWorkFinish(percentage);
        return updateById(Work);
    }

    @Override
    public IPage<Work> getReceivePage(int currentPage, int pageSize) {
        IPage ipage = new Page(currentPage, pageSize);
        LambdaQueryWrapper<Work> lqw = new LambdaQueryWrapper<>();
        Employee employee = SessionUtil.getEmployee();
        lqw.eq(Work::getWorkTo, employee.getEmployeeId());
        return page(ipage, lqw);
    }

    @Override
    public IPage<Work> getSendPage(int currentPage, int pageSize) {
        IPage ipage = new Page(currentPage, pageSize);
        LambdaQueryWrapper<Work> lqw = new LambdaQueryWrapper<>();
        Employee employee = SessionUtil.getEmployee();
        lqw.eq(Work::getEmployeeId, employee.getEmployeeId());
        return page(ipage, lqw);
    }

    private void addForeign(Work Work) {
        Work.setEmployee(employeeService.findById(Work.getEmployeeId()));
        Work.setWorkToEmployee(employeeService.findById(Work.getWorkTo()));
    }
}
