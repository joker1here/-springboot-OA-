package com.ssmp.dao;

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
        List<Attendance> list = attendanceDao.pageWithForeign(1,5);
        for (Attendance attendance : list) {
            System.out.println(attendance);
        }
    }
}
