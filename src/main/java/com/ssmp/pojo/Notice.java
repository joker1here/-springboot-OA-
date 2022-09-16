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
public class Notice implements Serializable {
    @TableId
    private Integer noticeId;
    private String noticeName;
    private String noticeInfo;
    private Date noticeTime;
    private int employeeId;
    @TableField(exist = false)
    private Employee employee;
}
