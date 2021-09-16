package com.beetle.onlinevideo.entity;

import java.util.Date;

public class CourseVideo {
    private Integer id;
    private String videoName;
    private Integer freeView;
    private Integer topicId;
    private Integer flag;
    private String videoUrl1;
    private String videoUrl2;
    private String videoUrl3;
    private Date createTime;

    public CourseVideo() {
    }

    @Override
    public String toString() {
        return "CourseVideo{" +
                "id=" + id +
                ", videoName='" + videoName + '\'' +
                ", freeView=" + freeView +
                ", topicId=" + topicId +
                ", flag=" + flag +
                ", videoUrl1='" + videoUrl1 + '\'' +
                ", videoUrl2='" + videoUrl2 + '\'' +
                ", videoUrl3='" + videoUrl3 + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Integer getFreeView() {
        return freeView;
    }

    public void setFreeView(Integer freeView) {
        this.freeView = freeView;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getVideoUrl1() {
        return videoUrl1;
    }

    public void setVideoUrl1(String videoUrl1) {
        this.videoUrl1 = videoUrl1;
    }

    public String getVideoUrl2() {
        return videoUrl2;
    }

    public void setVideoUrl2(String videoUrl2) {
        this.videoUrl2 = videoUrl2;
    }

    public String getVideoUrl3() {
        return videoUrl3;
    }

    public void setVideoUrl3(String videoUrl3) {
        this.videoUrl3 = videoUrl3;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public CourseVideo(Integer id, String videoName, Integer freeView, Integer topicId, Integer flag, String videoUrl1, String videoUrl2, String videoUrl3, Date createTime) {
        this.id = id;
        this.videoName = videoName;
        this.freeView = freeView;
        this.topicId = topicId;
        this.flag = flag;
        this.videoUrl1 = videoUrl1;
        this.videoUrl2 = videoUrl2;
        this.videoUrl3 = videoUrl3;
        this.createTime = createTime;
    }
}
