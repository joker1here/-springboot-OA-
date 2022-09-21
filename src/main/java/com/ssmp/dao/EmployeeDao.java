package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
    /**
     * 多表联查，查询所有
     * @return List
     */
    List<Employee> findWithForeign();

    /**
     * 多表联查，自定义分页
     * @return
     */
    IPage<Employee> pageWithForeign(IPage page,Integer start,Integer pageSize);
    IPage<Employee> pageWithForeignSelect(IPage page, String employeeName, int deptId, int jobId);
}
