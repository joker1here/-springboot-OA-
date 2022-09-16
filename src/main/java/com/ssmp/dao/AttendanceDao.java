package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.pojo.Attendance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceDao extends BaseMapper<Attendance> {

    /**
     * 多表联查，查询所有
     * @return List
     */
    List<Attendance> findAllWithForeign();

    /**
     * 多表联查，自定义分页
     * @return
     */
    List<Attendance> pageWithForeign(Integer start,Integer pageSize);
}
