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

    private ServerResponse(int status, Object data) {
        this.status = status;
        this.data = data;
    }

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
     * @param msg 自定义msg
     * @return
     */
    public static ServerResponse createByFailMessage(String msg){
        return new ServerResponse(ResponseCode.ERROR.getCode(),msg);
    }

    /**
     * 注册成功
     * @param msg 自定义msg
     * @return
     */
    public static ServerResponse registerBySuccess(String msg){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),msg);
    }
}
