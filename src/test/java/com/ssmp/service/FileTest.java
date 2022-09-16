package com.ssmp.service;

import com.ssmp.pojo.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FileTest {
    @Autowired
    private IFileService fileService;
    @Test
    void test1(){
        List<File> list = fileService.findReceived(10);
        for (File file : list) {
            System.out.println("发送方ID："+file.getFileTo());
            System.out.println("发送方："+file.getToEmployee());
            System.out.println("接收方ID："+file.getEmployeeId());
            System.out.println("接收方："+file.getEmployee());
        }
    }
}
