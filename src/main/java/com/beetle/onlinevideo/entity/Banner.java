package com.beetle.onlinevideo.entity;

public class Banner {
    private Integer id;
    private String imgUrl;
    private Integer flag;
    private Integer type;
    private String targetUrl;

    public Banner(Integer id, String imgUrl, Integer flag, Integer type, String targetUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.flag = flag;
        this.type = type;
        this.targetUrl = targetUrl;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", flag=" + flag +
                ", type=" + type +
                ", targetUrl='" + targetUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
}
