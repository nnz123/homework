package com.ccbtrust.remoteclient.model;

/**
 * 返回给前端的结果
 * @author nzhang
 */
public class Result<T> {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 成功时返回的数据
     */
    private T data;
    /**
     * 失败时的错误信息
     */
    private String message;

    public Result() {
        super();
    }

    /**
     * 成功时的构造器
     * @param success 是否成功
     * @param data 成功时返回的数据
     */
    public Result(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    /**
     * 失败时的构造器
     * @param success 是否成功
     * @param message 失败信息
     */
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
