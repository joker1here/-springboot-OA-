package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.AttendanceDao;
import com.ssmp.dao.FileDao;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Employee;
import com.ssmp.pojo.File;
import com.ssmp.service.IAttendanceService;
import com.ssmp.service.IEmployeeService;
import com.ssmp.service.IFileService;
import com.ssmp.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl extends ServiceImpl<FileDao, File> implements IFileService {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private FileDao fileDao;

    @Override
    public IPage<File> getPage(int currentPage, int pageSize) {
        IPage<File> iPage = new Page<>(currentPage,pageSize);
        page(iPage);
        //遍历一遍，加上外键和计算分钟
        for (File file : iPage.getRecords()) {
            addForeign(file);
        }
        return iPage;
    }

    @Override
    public File findById(Integer id) {
        File file = getById(id);
        addForeign(file);
        return file;
    }

    @Override
    public List<File> findReceived(Integer employeeId) {
//        LambdaQueryWrapper<File> lqw = new LambdaQueryWrapper<>();
//        lqw.eq(File::getFileTo, employeeId);
//        List<File> list = list(lqw);
//        for (File file : list) {
//            addForeign(file);
//        }
        List<File> list = fileDao.findReceiveWithForeign(employeeId);
        for (File file : list) {
            file.setFileTo(file.getToEmployee().getEmployeeId());
            file.setEmployeeId(file.getEmployee().getEmployeeId());
        }
        return list;
    }

    @Override
    public List<File> findSend(Integer employeeId) {
//        LambdaQueryWrapper<File> lqw = new LambdaQueryWrapper<>();
//        lqw.eq(File::getEmployeeId, employeeId);
//        List<File> list = list(lqw);
//        for (File file : list) {
//            addForeign(file);
//        }

        List<File> list = fileDao.findSendWithForeign(employeeId);
        for (File file : list) {
            file.setFileTo(file.getToEmployee().getEmployeeId());
            file.setEmployeeId(file.getEmployee().getEmployeeId());
        }
        return list;
    }

    /**
     * 已读和未读操作
     * @param file
     * @return
     */
    @Override
    public Boolean read(File file) {
        if (file.getFileRead() == 0) {
            file.setFileRead(1);
        }else {
            file.setFileRead(0);
        }
        return updateById(file);
    }

    @Override
    public IPage<File> getReceivePage(int currentPage, int pageSize) {
//        IPage ipage = new Page(currentPage, pageSize);
//        LambdaQueryWrapper<File> lqw = new LambdaQueryWrapper<>();
//        Employee employee = SessionUtil.getEmployee();
//        lqw.eq(File::getFileTo, employee.getEmployeeId());
        IPage<File> iPage = new Page<>(currentPage,pageSize);
        List<File> list = fileDao.pageReceiveWithForeign((currentPage - 1) * pageSize, pageSize, SessionUtil.getEmployee().getEmployeeId());
        for (File file : list) {
            file.setFileTo(file.getToEmployee().getEmployeeId());
            file.setEmployeeId(file.getEmployee().getEmployeeId());
        }
        iPage.setRecords(list);
        iPage.setTotal(count());
        return iPage;
    }

    @Override
    public IPage<File> getSendPage(int currentPage, int pageSize) {
//        IPage ipage = new Page(currentPage, pageSize);
//        LambdaQueryWrapper<File> lqw = new LambdaQueryWrapper<>();
//        Employee employee = SessionUtil.getEmployee();
//        lqw.eq(File::getEmployeeId, employee.getEmployeeId());
        IPage<File> iPage = new Page<>(currentPage,pageSize);
        List<File> list = fileDao.pageSendWithForeign((currentPage - 1) * pageSize, pageSize, SessionUtil.getEmployee().getEmployeeId());
        for (File file : list) {
            file.setFileTo(file.getToEmployee().getEmployeeId());
            file.setEmployeeId(file.getEmployee().getEmployeeId());
        }
        iPage.setRecords(list);
        iPage.setTotal(count());
        return iPage;
    }

    private void addForeign(File file) {
        file.setEmployee(employeeService.findById(file.getEmployeeId()));
        file.setToEmployee(employeeService.findById(file.getFileTo()));
    }
}
