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
public class File implements Serializable {
    @TableId
    private Integer fileId;
    private String fileTitle;
    private String fileName;
    private String fileForm;
    private Date fileTime;
    private String fileText;
    //接收方
    private int FileTo;
    @TableField(exist = false)
    private Employee ToEmployee;
    //发送方
    private int employeeId;
    @TableField(exist = false)
    private Employee employee;

    private int fileRead;
}
