package com.beetle.onlinevideo.entity;

import java.util.Date;

public class CourseTopic {
    //id ，标题，课程图片，课程简介，课程浏览次数，课程状态，课程分类，创建时间，VIP会员，课件下载
//    id int(11) AI PK
//    title varchar(255)
//    icon_url varchar(255)
//    course_intro varchar(255)
//    course_views int(11)
//    flag tinyint(1)
//    type_id int(11)
//    vip_flag int(11)
//    courseware_url varchar(255)
//    create_time datetim
    private Integer id;
    private String title;
    private String iconUrl;
    private String courseIntro;
    private Integer courseViews;
    private Integer flag;
    private Integer typeId;
    private Integer vipFlag;
    private String courseWareUrl;
    private Date createTime;


    public CourseTopic(Integer id, String title, String iconUrl, String courseIntro, Integer courseViews, Integer flag, Integer typeId, Integer vipFlag, String courseWareUrl, Date createTime) {
        this.id = id;
        this.title = title;
        this.iconUrl = iconUrl;
        this.courseIntro = courseIntro;
        this.courseViews = courseViews;
        this.flag = flag;
        this.typeId = typeId;
        this.vipFlag = vipFlag;
        this.courseWareUrl = courseWareUrl;
        this.createTime = createTime;

    }

    public CourseTopic() {
    }

    @Override
    public String toString() {
        return "CourseTopics{" +
                "id=" + id +
                ", tetle='" + title + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", courseIntro='" + courseIntro + '\'' +
                ", courseViews=" + courseViews +
                ", flag=" + flag +
                ", typeId=" + typeId +
                ", vipFlag=" + vipFlag +
                ", courseWareUrl='" + courseWareUrl + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tetle) {
        this.title = tetle;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro;
    }

    public Integer getCourseViews() {
        return courseViews;
    }

    public void setCourseViews(Integer courseViews) {
        this.courseViews = courseViews;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(Integer vipFlag) {
        this.vipFlag = vipFlag;
    }

    public String getCourseWareUrl() {
        return courseWareUrl;
    }

    public void setCourseWareUrl(String courseWareUrl) {
        this.courseWareUrl = courseWareUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
