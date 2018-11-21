package com.seven.common.utils;

import java.io.Serializable;

public class ApiResponse implements Serializable {
    @Override
    public String toString() {
        return "ApiResponse{" +
                "status='" + status + '\'' +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    private String status;
    private int code;
    private String message;
    private Object data;

    public ApiResponse(String status, int code, String msg, Object data) {
        this.status = status;
        this.code =  code;
        this.message = msg;
        this.data =  data;
    }

    public static ApiResponse success() {
        return new ApiResponse("success", 0, "", "");
    }

    public static ApiResponse success(String msg, Object data) {
        return new ApiResponse("success", 0, msg, data);
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse("success", 0, "", data);
    }

    public static ApiResponse error() {
        return new ApiResponse("error", 1, "", "");
    }

    public static ApiResponse error(String msg) {
        return new ApiResponse("error", 1, msg, "");
    }

    public static ApiResponse error(String msg, Object data) {
        return new ApiResponse("error", 1, msg, data);
    }

    public static ApiResponse error(int code, String msg) {
        return new ApiResponse("error", code, msg, "");
    }

    public static ApiResponse exception() {
        return new ApiResponse("exception", 2, "系统异常", "");
    }

    public static ApiResponse exception(String eMessage) {
        return new ApiResponse("exception", 2, eMessage, "");
    }

    public String getStatus() {
        return this.status;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getData() {
        return this.data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
