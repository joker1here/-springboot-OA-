package com.ssmp.service;

import com.ssmp.pojo.File;
import com.ssmp.pojo.Work;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WorkTest {
    @Autowired
    private IWorkService fileService;
    @Test
    void test1(){
        List<Work> list = fileService.findSend(10);
        for (Work file : list) {
            System.out.println("发送方ID："+file.getWorkTo());
            System.out.println("发送方："+file.getWorkToEmployee());
            System.out.println("接收方ID："+file.getEmployeeId());
            System.out.println("接收方："+file.getEmployee());
        }
    }
}
