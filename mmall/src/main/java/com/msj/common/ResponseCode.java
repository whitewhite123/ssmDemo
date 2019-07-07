package com.msj.common;

public enum  ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(1,"密码错误"),
    REGISTER_SUCCESS(0,"校验成功"),
    REGISTER_ERROR(1,"用户已存在"),
    LOGIN_SUCCESS(0,"SUCCESS"),
    LOGIN_ERROR(1,"用户未登录,无法获取当前用户信息");


    private final int code;
    private final String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
