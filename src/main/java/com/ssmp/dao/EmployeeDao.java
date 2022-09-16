package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    List<Employee> pageWithForeign(Integer start,Integer pageSize);
}
