package com.beetle.onlinevideo.dto;

import com.beetle.onlinevideo.entity.User;

public class LoginToken {
    private String id; //发送请求的id
    private String now;//请求的时间
    private String userAgent;//浏览器信息

    private User user;

    @Override
    public String toString() {
        return "LoginToken{" +
                "id='" + id + '\'' +
                ", now='" + now + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", user=" + user +
                '}';
    }

    public LoginToken() {
    }

    public LoginToken(String id, String now, String userAgent, User user) {
        this.id = id;
        this.now = now;
        this.userAgent = userAgent;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
