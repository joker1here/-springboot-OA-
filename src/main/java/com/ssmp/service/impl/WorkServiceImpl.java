package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.WorkDao;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Employee;
import com.ssmp.pojo.File;
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

    @Autowired
    private WorkDao workDao;

    /**
     * 按条件查询收到任务的分页，经常使用
     * @param currentPage
     * @param pageSize
     * @param work1
     * @return
     */
    @Override
    public IPage<Work> getReceivePage(int currentPage, int pageSize,Work work1) {
        IPage<Work> iPage = new Page<>(currentPage,pageSize);
        workDao.pageReceiveWithForeign(iPage, SessionUtil.getEmployee().getEmployeeId());
        for (Work work : iPage.getRecords()) {
            work.setWorkTo(work.getWorkToEmployee().getEmployeeId());
            work.setEmployeeId(work.getEmployee().getEmployeeId());
        }
        return iPage;
    }

    /**
     * 按条件查询发送的文件，经常使用
     * @param currentPage
     * @param pageSize
     * @param work1
     * @return
     */
    @Override
    public IPage<Work> getSendPage(int currentPage, int pageSize,Work work1) {
        IPage<Work> iPage = new Page<>(currentPage,pageSize);
        workDao.pageSendWithForeign(iPage, SessionUtil.getEmployee().getEmployeeId());
        for (Work work : iPage.getRecords()) {
            work.setWorkTo(work.getWorkToEmployee().getEmployeeId());
            work.setEmployeeId(work.getEmployee().getEmployeeId());
        }
        return iPage;
    }

    /**
     * 自带的分页，一般不用
     * @param currentPage
     * @param pageSize
     * @return
     */
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

    /**
     * 查找收到的任务，一般不用
     * @param employeeId
     * @return
     */
    @Override
    public List<Work> findReceived(Integer employeeId) {
        List<Work> list = workDao.findReceiveWithForeign(employeeId);
        for (Work work : list) {
            work.setWorkTo(work.getWorkToEmployee().getEmployeeId());
            work.setEmployeeId(work.getEmployee().getEmployeeId());
        }
        return list;
    }

    /**
     * 查找发送的任务，一般不用
     * @param employeeId
     * @return
     */
    @Override
    public List<Work> findSend(Integer employeeId) {
        List<Work> list = workDao.findSendWithForeign(employeeId);
        for (Work work : list) {
            work.setWorkTo(work.getWorkToEmployee().getEmployeeId());
            work.setEmployeeId(work.getEmployee().getEmployeeId());
        }
        return list;
    }

    private void addForeign(Work Work) {
        Work.setEmployee(employeeService.findById(Work.getEmployeeId()));
        Work.setWorkToEmployee(employeeService.findById(Work.getWorkTo()));
    }
}
