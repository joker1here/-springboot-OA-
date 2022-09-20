package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.pojo.Employee;
import com.ssmp.utils.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IEmployeeService extends IService<Employee> {
    /**
     * 为List<Employee>添加外键
     * @return
     */
    List<Employee> findAll();

    /**
     * 按id查找的结果添加外键
     * @param id
     * @return
     */
    Employee findById(Integer id);

    /**
     * 重写分页
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return IPage<Employee>
     */
    IPage<Employee> getPage(int currentPage, int pageSize);

    /**
     * 登陆功能，验证用户名和密码
     * @param name 用户名
     * @param pwd 密码
     * @param session
     * @return boolean
     */
    Result login(String name, String pwd, HttpSession session);

    /**
     * 登出
     * @param session
     * @return
     */
    Result logout(HttpSession session);
}
