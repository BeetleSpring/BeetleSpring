package dao;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import com.beetle.onlinevideo.dao.CourseTopicsDao;
import com.beetle.onlinevideo.dao.CourseVideoDao;
import com.beetle.onlinevideo.dao.ToolDao;
import com.beetle.onlinevideo.dao.UserDao;
import com.beetle.onlinevideo.entity.CourseTopic;
import com.beetle.onlinevideo.entity.CourseVideo;
import com.beetle.onlinevideo.entity.Tool;
import com.beetle.onlinevideo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class TestDao {
    @Autowired
    UserDao userDao;

    @Autowired
    CourseTopicsDao courseTopicsDao;

    @Autowired
    ToolDao toolDao;

    @Autowired
    CourseVideoDao courseVideoDao;

    @Test
    public void t1() {
        User user = new User();
        user.setId(2);
        user.setTelephone("123456");
        user.setUserName("laozei");
        user.setPassword("123");
        user.setEmail("123@.com");
        user.setVipFlag(0);
        user.setCreateTime(new DateTime(System.currentTimeMillis()));
        userDao.insertUser(user);
    }

    @Test
    public void courseTopicsDao(){

        for(int i=0;i<100;i++) {

            CourseTopic topics = new CourseTopic();
            topics.setId(i+1);
            topics.setTitle("SpringCloud+Alibaba 从入门到进阶"+i);
            topics.setIconUrl("/static/imgs/555.png");
            topics.setCourseIntro("深度剖析SpringCloud主流组件的使用和高级特性。");
            topics.setCourseViews(1000+ RandomUtil.randomInt(1,1000));
            topics.setFlag(1);
            topics.setVipFlag(RandomUtil.randomInt(0,2));
            topics.setTypeId(RandomUtil.randomInt(1,6));
            topics.setCourseWareUrl("none");
            topics.setCreateTime(new Date());
            courseTopicsDao.insertCourseTopic(topics);
        }
    }


    @Test
    public void toolDao(){
        for(int i=0;i<100;i++) {
            Tool tool = new Tool();
            tool.setName("日期时间工具"+i);
            tool.setIconUrl("/static/imgs/tool_icon.png");
            tool.setToolUrl("https://www.hutool.cn/docs/#/");
            tool.setTypeId(RandomUtil.randomInt(1,4));

            toolDao.insert(tool);
        }
    }

    @Test
    public void CourseVideoDao(){
        for(int i=0;i<1000;i++) {
            CourseVideo video = new CourseVideo();
            video.setVideoName("IDEA-IntelliJ IDEA的介绍和优势"+i);
            //video.setFreeView();
            video.setTopicId(RandomUtil.randomInt(1,101));
            CourseTopic topic =  courseTopicsDao.selectById(video.getTopicId());
            video.setFreeView(topic.getVipFlag());
            video.setFlag(1);
            video.setVideoUrl1("//player.bilibili.com/player.html?aid=590059873&bvid=BV1eq4y1D7zQ&cid=397300569&page=1");
            video.setVideoUrl2("//player.bilibili.com/player.html?aid=890357863&bvid=BV1XP4y1a7EP&cid=403875703&page=1");
            video.setVideoUrl3("//player.bilibili.com/player.html?aid=590059873&bvid=BV1eq4y1D7zQ&cid=397300569&page=1");
            video.setCreateTime(new Date());
            courseVideoDao.insert(video);
        }
    }

    @Test
    public void testUserDao(){
        for(int i=0;i<100;i++){
            User user = new User();
            user.setTelephone("15711111111");
            user.setUserName("甲壳虫"+i);
            user.setPassword("111111");
            user.setEmail("163"+i+"@qq.com");
            user.setVipFlag(0);
            userDao.insertUser(user);
        }
    }


}
