package com.beetle.onlinevideo.dao;

import com.beetle.onlinevideo.entity.CourseVideo;

import java.util.List;

public interface CourseVideoDao {

    //根据专题id 查询课程视频

    public List<CourseVideo> selectVideoByTopicId(Integer topicId);

    public Integer insert(CourseVideo video);

    //根据给定视频id 查找视频
    public CourseVideo selectVideoById(Integer id);
}
