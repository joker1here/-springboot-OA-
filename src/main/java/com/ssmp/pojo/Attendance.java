package com.ssmp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName
public class Attendance implements Serializable {
    @TableId
    private Integer AttendanceId;
    private int AttendanceEmployee;
    @TableField(exist = false)
    private Employee employee;
    private Date SignUpTime;
    private Date SignBackTime;
    @TableField(exist = false)
    private int minutes;
}
