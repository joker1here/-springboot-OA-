package com.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ssmp.pojo.Notice;
import com.ssmp.pojo.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoTest {
    @Autowired
    private ITodoService attendanceService;
    @Test
    void page() {
        IPage<Todo> page = attendanceService.getPage(1, 5,null);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());

    }
}
