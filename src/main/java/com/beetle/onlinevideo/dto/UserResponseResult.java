package com.beetle.onlinevideo.dto;

public class UserResponseResult<T> {

    private int rcode;

    private T data;

    private String message;

    public UserResponseResult() {
    }

    public UserResponseResult(int rcode, T data, String message) {
        this.rcode = rcode;
        this.data = data;
        this.message = message;
    }

    public UserResponseResult(int rcode, String message) {
        this.rcode = rcode;
        this.message = message;
    }

    public int getRcode() {
        return rcode;
    }

    public void setRcode(int rcode) {
        this.rcode = rcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
