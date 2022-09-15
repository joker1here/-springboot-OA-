package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.pojo.Attendance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttendanceDao extends BaseMapper<Attendance> {
}
