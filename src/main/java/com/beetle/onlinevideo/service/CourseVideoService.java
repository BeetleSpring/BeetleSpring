package com.beetle.onlinevideo.service;

import com.beetle.onlinevideo.entity.CourseVideo;

import java.util.List;

public interface CourseVideoService {

    //根据给定的 专题id 查询所有视频
    public List<CourseVideo> selectVideoByTopicId(Integer topicId);

    //根据给定视频id 查找视频
    public CourseVideo selectVideoById(Integer id);
}
