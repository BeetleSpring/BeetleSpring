package service;

import com.beetle.onlinevideo.entity.Banner;
import com.beetle.onlinevideo.entity.CourseTopic;
import com.beetle.onlinevideo.service.BannerService;
import com.beetle.onlinevideo.service.CourseTopicService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class TestService {

    @Autowired
    CourseTopicService courseTopicService;

    @Autowired
    BannerService bannerService;

    @Test
    public void t1(){
//        List<CourseTopic> list = courseTopicService.selectCourseTopicList(3);
//        List<CourseTopic> list1 = courseTopicService.selectNewCourseTopicList();
//        System.out.println(list.size()+"--"+list1.get(0).getId());
    }

    @Test
    public void t2(){
        PageInfo bannerInfo = bannerService.selectBannerById(1,2,3);
        System.out.println(bannerInfo.getList());
    }

    public void t3(){

    }
}
