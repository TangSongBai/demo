package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 86187
 * @Date: 2023/3/3 14:08
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DemoException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;


    private Integer code;


    private String message;



    public DemoException() {
        super();
    }



    public DemoException(String message) {
        super(message);
        this.message=message;
    }

    public DemoException(Integer code,String message){
        super(message);

        this.message=message;

        this.code=code;
    }


    public DemoException(String message, Throwable cause) {
        super(message, cause);
        this.message=message;


    }


    public DemoException(Throwable cause) {
        super(cause);
    }


    protected DemoException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
