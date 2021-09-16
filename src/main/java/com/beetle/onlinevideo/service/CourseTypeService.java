package com.beetle.onlinevideo.service;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;


public interface CourseTypeService {

    //查询所有课程类型
    public PageInfo selectCourseType();

    //根据给定CourseTyp id查询数据
    public PageInfo selectCourseTypeBy(Integer id);
}
