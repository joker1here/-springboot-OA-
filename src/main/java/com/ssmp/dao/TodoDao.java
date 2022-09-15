package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.pojo.Employee;
import com.ssmp.pojo.Todo;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoDao extends BaseMapper<Todo> {
}
