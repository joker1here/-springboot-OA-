package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.pojo.Employee;
import com.ssmp.pojo.Work;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkDao extends BaseMapper<Work> {
}
