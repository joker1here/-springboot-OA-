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

    /**
     * 使用自带方法查询分页，一般不会使用这个
     * @param currentPage
     * @param pageSize
     * @return
     */
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

    /**
     * 寻找收到的文件信息分页，一般使用这个
     * @param employeeId
     * @return
     */
    @Override
    public List<File> findReceived(Integer employeeId) {
        List<File> list = fileDao.findReceiveWithForeign(employeeId);
        for (File file : list) {//因为外键信息被顶掉，重写写回
            file.setFileTo(file.getToEmployee().getEmployeeId());
            file.setEmployeeId(file.getEmployee().getEmployeeId());
        }
        return list;
    }

    /**
     * 寻找发送的文件信息
     * @param employeeId
     * @return
     */
    @Override
    public List<File> findSend(Integer employeeId) {
        List<File> list = fileDao.findSendWithForeign(employeeId);
        for (File file : list) {
            file.setFileTo(file.getToEmployee().getEmployeeId());
            file.setEmployeeId(file.getEmployee().getEmployeeId());
        }
        return list;
    }

    /**
     * 获得收到的文件信息分页
     * @param currentPage
     * @param pageSize
     * @param file1
     * @return
     */
    @Override
    public IPage<File> getReceivePage(int currentPage, int pageSize,File file1) {
        IPage<File> iPage = new Page<>(currentPage,pageSize);
        fileDao.pageReceiveWithForeign(iPage, SessionUtil.getEmployee().getEmployeeId());
        for (File file : iPage.getRecords()) {
            file.setFileTo(file.getToEmployee().getEmployeeId());
            file.setEmployeeId(file.getEmployee().getEmployeeId());
        }
        return iPage;
    }

    /**
     * 获得发送的文件信息分页
     * @param currentPage
     * @param pageSize
     * @param file1
     * @return
     */
    @Override
    public IPage<File> getSendPage(int currentPage, int pageSize,File file1) {
        IPage<File> iPage = new Page<>(currentPage,pageSize);
        fileDao.pageSendWithForeign(iPage,SessionUtil.getEmployee().getEmployeeId());
        for (File file : iPage.getRecords()) {
            file.setFileTo(file.getToEmployee().getEmployeeId());
            file.setEmployeeId(file.getEmployee().getEmployeeId());
        }
        return iPage;
    }

    /**
     * 寻找单个
     * @param id 文件id
     * @return
     */
    @Override
    public File findById(Integer id) {
        File file = getById(id);
        addForeign(file);
        return file;
    }

    /**
     * 已读和未读操作，已读设为未读，未读设为已读
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

    private void addForeign(File file) {
        file.setEmployee(employeeService.findById(file.getEmployeeId()));
        file.setToEmployee(employeeService.findById(file.getFileTo()));
    }
}
