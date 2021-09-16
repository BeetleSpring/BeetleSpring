package com.beetle.onlinevideo.service.serviceImp;

import com.beetle.onlinevideo.dao.CourseTopicsDao;
import com.beetle.onlinevideo.entity.CourseTopic;
import com.beetle.onlinevideo.service.CourseTopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CourseTopicServiceImp implements CourseTopicService {

    @Autowired
    CourseTopicsDao courseTopicsDao;
    @Override
    public PageInfo selectNewCourseTopicList(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(courseTopicsDao.selectNewCourseTopicList(),4);
    }


    @Override
    public PageInfo selectCourseTopicByTypeId(Integer typeId,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        HashMap map = new HashMap();
        map.put("typeId",typeId);
        return new PageInfo(courseTopicsDao.selectCourseTopicListbyId(map),4);
    }

    @Override
    public CourseTopic selectOneById(Integer id) {
      return courseTopicsDao.selectById(id);
    }
}
