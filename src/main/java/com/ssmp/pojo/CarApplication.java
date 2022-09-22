package com.ssmp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName
public class CarApplication {
    @TableId
    private Integer applicationId;
    private Integer deptId;
    @TableField(exist = false)
    private Dept dept;
    private Integer employeeId;
    @TableField(exist = false)
    private Employee employee;

    private String address;

    private String reason;
}
