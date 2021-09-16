package com.beetle.onlinevideo.dao;

import com.beetle.onlinevideo.entity.CourseTopic;

import java.util.HashMap;
import java.util.List;

public interface CourseTopicsDao {

    public Integer insertCourseTopic(CourseTopic courseTopics);

    public List<CourseTopic> selectNewCourseTopicList();

    public List<CourseTopic> selectCourseTopicListbyId(HashMap map);
    //根据专题id查询指定专题

    public CourseTopic selectById(Integer id);

}
