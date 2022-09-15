package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.pojo.Work;

import java.util.List;

public interface IWorkService extends IService<Work> {
    IPage<Work> getPage(int currentPage, int pageSize);

    /**
     * 按任务id查找
     * @param id 任务id
     * @return Work
     */
    Work findById(Integer id);

    /**
     * 收任务
     * @param employeeId
     * @return
     */
    List<Work> findReceived(Integer employeeId);

    /**
     * 发任务
     * @param employeeId
     * @return
     */
    List<Work> findSend(Integer employeeId);

    /**
     * 已读和未读操作
     * @param Work
     * @param percentage
     * @return
     */
    Boolean read(Work Work, Integer percentage);

    /**
     * 收任务分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Work> getReceivePage(int currentPage, int pageSize);

    /**
     * 发任务分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Work> getSendPage(int currentPage, int pageSize);
}
