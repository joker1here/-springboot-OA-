package com.ssmp.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义一个类用于封装返回给前端的数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    //success成功与否
    private Boolean success;
    //错误信息
    private String errorMsg;
    //数据封装
    private Object data;

    /**
     * 方法的重载，成功但没有数据
     * @return Result
     */
    public static Result ok(){
        return new Result(true, null, null);
    }

    /**
     * 成功并存入数据Data
     * @param data 数据
     * @return Result
     */
    public static Result ok(Object data){
        return new Result(true, null, data);
    }

    /**
     * 失败，存入错误信息
     * @param errorMsg 错误信息
     * @return Result
     */
    public static Result fail(String errorMsg){
        return new Result(false, errorMsg, null);
    }
}
