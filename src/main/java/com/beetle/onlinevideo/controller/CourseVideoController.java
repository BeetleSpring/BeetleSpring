package com.beetle.onlinevideo.controller;

import com.beetle.onlinevideo.entity.CourseTopic;
import com.beetle.onlinevideo.entity.CourseVideo;
import com.beetle.onlinevideo.service.CourseTopicService;
import com.beetle.onlinevideo.service.CourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CourseVideoController {

    @Autowired
    CourseTopicService courseTopicService;
    @Autowired
    CourseVideoService courseVideoService;

    @RequestMapping("/courseVideo/{topicId}")
    public String courseVideo(Model model,@PathVariable Integer topicId,Integer videoId){
        CourseTopic topic = courseTopicService.selectOneById(topicId);
        List<CourseVideo> videos = courseVideoService.selectVideoByTopicId(topicId);
        String currentVideoUrl = null;
        if(videoId==null||videoId<1){//表示前面没有传videoId  可能是从导航栏进入的视频页面
            //那我们默认播放 课程目录里面第一个视频
            currentVideoUrl=videos.get(0).getVideoUrl1();
            videoId = videos.get(0).getId();
        }else {
            currentVideoUrl = courseVideoService.selectVideoById(videoId).getVideoUrl1();
        }

        //fast_instant_trade_pay
        model.addAttribute("topic",topic);
        model.addAttribute("videos",videos);
        model.addAttribute("currentVideoUrl",currentVideoUrl);
        model.addAttribute("videoId",videoId);
        return "course_video";
    }
}
