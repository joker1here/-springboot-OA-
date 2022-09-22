package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.pojo.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarDao extends BaseMapper<Car> {
}
