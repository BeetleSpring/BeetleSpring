package com.beetle.onlinevideo.service.serviceImp;

import com.beetle.onlinevideo.dao.CourseTypeDao;
import com.beetle.onlinevideo.service.CourseTypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class CourseTypeServiceImp implements CourseTypeService {

    @Autowired
    CourseTypeDao courseTypeDao;


    @Override
    public PageInfo selectCourseType() {

        return new PageInfo(courseTypeDao.selectAll());
    }

    @Override
    public PageInfo selectCourseTypeBy(Integer id) {
        HashMap map = new HashMap();
        map.put("id",id);
        return new PageInfo(courseTypeDao.selectTopicTypeBy(map));
    }
}
