package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.pojo.Attendance;
import com.ssmp.pojo.Employee;
import com.ssmp.pojo.Work;
import com.ssmp.pojo.Work;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkDao extends BaseMapper<Work> {
    /**
     *
     * 多表联查，查询所有
     * @return List
     */
    List<Work> findReceiveWithForeign(Integer id);
    /**
     *
     * 多表联查，查询所有
     * @return List
     */
    List<Work> findSendWithForeign(Integer id);

    /**
     * 多表联查，自定义分页-收信箱
     * @param id
     * @return
     */
    IPage<Work> pageReceiveWithForeign(IPage<Work> iPage, Integer id);

    /**
     * 多表联查，自定义分页-发信箱
     * @param id
     * @return
     */
    IPage<Work> pageSendWithForeign(IPage<Work> iPage,Integer id);
}
