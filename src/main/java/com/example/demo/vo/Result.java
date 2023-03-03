package com.example.demo.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 86187
 * @Date: 2023/3/3 09:53
 * @Description:
 */
@Data
@Builder
public class Result<T> implements Serializable {

    private int code;

    private String message;

    private  T  data;

    public Result(){};

    public Result(int code,String message,T data){
        this.code=code;
        this.message=message;
        this.data = data ;
    };

    public Result (int code,String message){
        this.code=code;
        this.message=message;
    }

    public static Result success(){
        return new Result(200,"操作成功");
    }



    public static Result success(String message){
        return new Result(200,message);
    }

    public static <T> Result success(String message,T data){
        return new Result(200,message,data);
    }

    public  static Result fail (){
        return new Result(500,"操作失败");
    }

    public static Result fail(String message){
        return new Result(500,message);
    }

    public static <T> Result fail(String message,T data){
        return new Result(500,message,data);
    }

    public static  Result fail(Integer code,String message){
        return new Result(code,message);
    }



}
