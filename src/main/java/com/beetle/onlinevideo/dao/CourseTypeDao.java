package com.beetle.onlinevideo.dao;

import com.beetle.onlinevideo.entity.CourseType;

import java.util.HashMap;
import java.util.List;

public interface CourseTypeDao {

    public List<CourseType> selectAll();

    //根据给定条件 查询TopicType
    public List<CourseType> selectTopicTypeBy(HashMap map);
}
