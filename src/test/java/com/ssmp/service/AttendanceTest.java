package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.dao.AttendanceDao;
import com.ssmp.pojo.Attendance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AttendanceTest {
    @Autowired
    private IAttendanceService attendanceService;
    @Test
    void page() {
        IPage<Attendance> page = attendanceService.getPage(1, 5);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());

    }
}
