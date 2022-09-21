package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.File;

import java.util.List;

public interface IFileService extends IService<File> {
    IPage<File> getPage(int currentPage, int pageSize);

    /**
     * 按文件id查找
     * @param id 文件id
     * @return File
     */
    File findById(Integer id);

    /**
     * 收信箱
     * @param employeeId
     * @return
     */
    List<File> findReceived(Integer employeeId);

    /**
     * 发信箱
     * @param employeeId
     * @return
     */
    List<File> findSend(Integer employeeId);

    /**
     * 已读和未读操作
     * @param file
     * @return
     */
    Boolean read(File file);

    /**
     * 收信箱分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<File> getReceivePage(int currentPage, int pageSize,File file);

    /**
     * 发信箱分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<File> getSendPage(int currentPage, int pageSize,File file);
}
