package com.ssmp.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {
    @TableId
    private Integer jobId;
    private String jobIntroduce;
    private String jobName;
}
