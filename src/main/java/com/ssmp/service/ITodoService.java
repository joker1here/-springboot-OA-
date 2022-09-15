package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Todo;

import java.util.List;

public interface ITodoService extends IService<Todo> {
    /**
     * 查找属于用户的待做事项
     * @param employeeId
     * @return
     */
    List<Todo> findAll(Integer employeeId);

    /**
     * 按id查找
     * @param id
     * @return
     */
    Todo findById(Integer id);

    /**
     * 分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Todo> getPage(int currentPage, int pageSize);
}
