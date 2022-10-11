package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.pojo.Todo;
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
    IPage<Todo> pageWithForeign(IPage<Todo> page, Integer id);
}
