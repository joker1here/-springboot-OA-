package com.ssmp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work implements Serializable {
    @TableId
    private Integer workId;
    private Date workTime;
    private int employeeId;
    private int workTo;
    private String workText;
    private float workFinish;

    //发布者
    @TableField(exist = false)
    private Employee employee;
    //接收者
    @TableField(exist = false)
    private Employee workToEmployee;
}
