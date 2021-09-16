package com.beetle.onlinevideo.service.serviceImp;

import com.beetle.onlinevideo.dao.CourseVideoDao;
import com.beetle.onlinevideo.entity.CourseVideo;

import com.beetle.onlinevideo.service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseVideoServiceImp implements CourseVideoService {



    @Autowired
    CourseVideoDao courseVideoDao;

    @Override
    public List<CourseVideo> selectVideoByTopicId(Integer topicId) {
       return courseVideoDao.selectVideoByTopicId(topicId);
    }

    @Override
    public CourseVideo selectVideoById(Integer id) {
        return courseVideoDao.selectVideoById(id);
    }
}
