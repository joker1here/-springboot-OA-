package com.ssmp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo implements Serializable {
    @TableId
    private Integer TodoId;
    private String TodoText;
    private int TodoFinish;
    private int EmployeeId;
    @TableField(exist = false)
    private Employee employee;
}
