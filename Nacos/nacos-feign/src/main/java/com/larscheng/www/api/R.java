package com.larscheng.www.api;

import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * @author xiemin
 * @date 2019/10/9 12:12
 */
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private boolean success;
    private T data;
    private String msg;

    private R(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMessage());
    }

    private R(IResultCode resultCode, String msg) {
        this(resultCode,null,msg);
    }

    private R(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    private R(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private R(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = BizExceptionResultCode.SUCCESS.getCode().equals(code);
    }





    public static <T> R<T> data(T data) {
        return data(data, BizExceptionResultCode.SUCCESS.getCode());
    }

    public static <T> R<T> data(T data, String msg) {
        return data(BizExceptionResultCode.SUCCESS.getCode(), data, msg);
    }

    public static <T> R<T> data(String code, T data, String msg) {
        return new R(code, data, data == null ? "暂无承载数据" : msg);
    }

    public static <T> R<T> success(String msg) {
        return new R(BizExceptionResultCode.SUCCESS, msg);
    }

    public static <T> R<T> success() {
        return new R(BizExceptionResultCode.SUCCESS);
    }

    public static <T> R<T> success(IResultCode resultCode) {
        return new R(resultCode);
    }

    public static <T> R<T> success(IResultCode resultCode, String msg) {
        return new R(resultCode, msg);
    }

    public static <T> R<T> fail(String msg) {
        return new R(BizExceptionResultCode.FAILURE, msg);
    }

    public static <T> R<T> fail(String code, String msg) {
        return new R(code, (Object)null, msg);
    }

    public static <T> R<T> fail(IResultCode resultCode) {
        return new R(resultCode);
    }

    public static <T> R<T> fail(IResultCode resultCode, String msg) {
        return new R(resultCode, msg);
    }




    public static <T> R<T> fallback() {
        return new R(BizExceptionResultCode.SERVICE_FUSING);
    }

    public String getCode() {
        return this.code;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "R(code=" + this.getCode() + ", success=" + this.isSuccess() + ", data=" + this.getData() + ", msg=" + this.getMsg() + ")";
    }

    public R() {
    }
}
