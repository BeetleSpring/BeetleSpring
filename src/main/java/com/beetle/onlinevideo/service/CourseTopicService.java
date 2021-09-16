package com.beetle.onlinevideo.service;

import com.beetle.onlinevideo.entity.CourseTopic;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CourseTopicService {

    //查询最新课程专题
    public PageInfo selectNewCourseTopicList(Integer pageNum,Integer pageSize);

    //根据类型id查询对应课程专题
    public PageInfo  selectCourseTopicByTypeId(Integer typeId,Integer pageNum,Integer pageSize);

    public CourseTopic selectOneById(Integer id);
}
