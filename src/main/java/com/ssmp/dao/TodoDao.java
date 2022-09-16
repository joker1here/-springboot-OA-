package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Employee;
import com.ssmp.pojo.Todo;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoDao extends BaseMapper<Todo> {
    /**
     * 多表联查，查询所有
     * @return List
     */
    List<Todo> findAllWithForeign(Integer id);

    /**
     * 多表联查，自定义分页
     * @return
     */
    List<Todo> pageWithForeign(Integer start,Integer pageSize,Integer id);
}
