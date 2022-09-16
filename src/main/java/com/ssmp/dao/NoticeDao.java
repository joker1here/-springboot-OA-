package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Employee;
import com.ssmp.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDao extends BaseMapper<Notice> {
    /**
     * 多表联查，查询所有
     * @return List
     */
    List<Notice> findAllWithForeign();

    /**
     * 多表联查，自定义分页
     * @return
     */
    List<Notice> pageWithForeign(Integer start,Integer pageSize);
}
