package com.ssmp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
//lombok
// @Getter
// @Setter
@Data//get,set,hashcode,toString,equals
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    @TableId
    private Integer employeeId;
    private String employeeName;
    private String pwd;
    private String address;
    private Date birthday;
    private String email;
    private String mobile;
    private String photo;
    private int sex;
    private int userLevel;

    private int deptId;
    @TableField(exist = false)
    private Dept dept;
    private int jobId;
    @TableField(exist = false)
    private Job job;

}
