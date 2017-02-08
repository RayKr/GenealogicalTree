package com.swroom.genealogy.model.vo;

/**
 * JSON
 * Created by jingz on 2017/2/8.
 */
public class VJson {

    private boolean success; // 是否成功
    private String msg; // 异常信息
    private Object result; // 封装对象

    public VJson() {
    }

    public VJson(boolean success, String msg, Object result) {
        this.success = success;
        this.msg = msg;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "VJson{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

}
