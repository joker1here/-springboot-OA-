package com.ssmp.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssmp.pojo.Attendance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AttendanceTest {
    @Autowired
    private AttendanceDao attendanceDao;

    @Test
    void AllWithForeign() {
        List<Attendance> list = attendanceDao.findAllWithForeign();
        for (Attendance attendance : list) {
            System.out.println(attendance);
        }
    }
    @Test
    void pageWithForeign() {
        IPage<Attendance> iPage = new Page<>(1, 3);
        attendanceDao.pageWithForeign(iPage);
        for (Attendance attendance : iPage.getRecords()) {
            System.out.println(attendance);
        }
    }
}
