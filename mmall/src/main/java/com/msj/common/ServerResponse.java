package com.msj.common;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)//保证序列化Json的时候，如果值为null，会不显示这个key
public class ServerResponse {

    private int status;
    private String msg;
    private Object data;

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    /**
     * 构造函数
     * @param status 状态码
     * @param data 对象
     */
    private ServerResponse(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    /**
     * 构造函数
     * @param status 状态码
     * @param msg
     */
    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 登录成功
     * @param data 自定义data
     * @return
     */
    public static ServerResponse createBySuccess(Object data){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),data);
    }

    /**
     * 登录失败
     * @param
     * @return
     */
    public static ServerResponse createByFailMessage(){
        return new ServerResponse(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    /**
     * 注册成功
     * @param
     * @return
     */
    public static ServerResponse registerBySuccess(){
        return new ServerResponse(ResponseCode.REGISTER_SUCCESS.getCode(),
                ResponseCode.REGISTER_SUCCESS.getDesc());
    }
    /**
     * 注册成功
     * @param
     * @return
     */
    public static ServerResponse registerByFail(){
        return new ServerResponse(ResponseCode.REGISTER_ERROR.getCode(),
                ResponseCode.REGISTER_ERROR.getDesc());
    }

    public static ServerResponse loginBySuccess(Object data){
        return new ServerResponse(ResponseCode.LOGIN_SUCCESS.getCode(),data);
    }


    public static ServerResponse loginByFail(){
        return new ServerResponse(ResponseCode.LOGIN_ERROR.getCode(),
                ResponseCode.LOGIN_ERROR.getDesc());
    }

}
