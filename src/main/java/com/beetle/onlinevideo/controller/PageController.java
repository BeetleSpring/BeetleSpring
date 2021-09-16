package com.beetle.onlinevideo.controller;

import com.beetle.onlinevideo.entity.CourseTopic;
import com.beetle.onlinevideo.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    CourseTopicService courseTopicService;

    @Autowired
    CourseTypeService courseTypeService;

    @Autowired
    BannerService bannerService;

    @Autowired
    ToolService toolService;

    @Autowired
    ToolTypeService toolTypeService;


    //首页
    @RequestMapping("/")
    public String indexPage(Model model){
        //首页 展示最新课程  和 常用框架

        //获取第pageNum页，pageSize条内容，默认查询总数count
        //最新课程数据
        PageInfo newCourseTopicsInfo = courseTopicService.selectNewCourseTopicList(1, 4);
        //常用框架数据
        PageInfo courseTopicsInfo = courseTopicService.selectCourseTopicByTypeId(3,1, 4);
        //轮播图数据
        PageInfo bannerInfo = bannerService.selectBannerById(1,2,3);

        //头部导航栏焦点标记
        Integer focusFlag=0;
        //将前端所需要的的数据返回
        model.addAttribute("newCourseTopicsInfo",newCourseTopicsInfo);
        model.addAttribute("courseTopicsInfo",courseTopicsInfo);
        model.addAttribute("bannerInfo",bannerInfo);
        model.addAttribute("focusFlag",focusFlag);
        return "index";
    }


    //导航栏 课程选项 点进去后 显示全部课程 按照最新课程时间排序
    // 并在课程的选项卡动态产生课程类型
//    @RequestMapping("/courseList")
//    public String courseList(Model model){
//        //获取第pageNum页，pageSize条内容，默认查询总数count
//
//        PageInfo topicsInfo = courseTopicService.selectNewCourseTopicList(1,16);
//        model.addAttribute("topicsInfo",topicsInfo);
//
//        PageInfo topicTypeInfo = courseTypeService.selectCourseType();
//        model.addAttribute("topicTypeInfo",topicTypeInfo);
//        return "course_list";
//    }

    @RequestMapping("/courseList/{typeId}")
    public String courseList(@PathVariable Integer typeId,Model model,Integer pageNum){
        if(pageNum==null||pageNum<=1){//默认查找数据是 第一个页码
            pageNum=1;
        }
        //头部导航栏 焦点标记
        Integer focusFlag=1;
        PageInfo topicsInfo = null;
        if(typeId<=0){//表示要全部显示 默认按照最新的排

            topicsInfo = courseTopicService.selectNewCourseTopicList(pageNum,16);

        }else{//用户 点击的专题类型
            topicsInfo = courseTopicService.selectCourseTopicByTypeId(typeId, pageNum, 16);
        }
        model.addAttribute("topicsInfo",topicsInfo);


        //前端需要的 专题类型数据
        PageInfo topicTypeInfo = courseTypeService.selectCourseType();
        model.addAttribute("topicTypeInfo",topicTypeInfo);
        model.addAttribute("typeId",typeId);
        model.addAttribute("focusFlag",focusFlag);
        return "course_list";
    }

    @RequestMapping("/vip")
    public String vip(Model model){
        //头部导航栏 焦点标记
        Integer focusFlag=2;

        model.addAttribute("focusFlag",focusFlag);
        return "vip";
    }

    @RequestMapping("/live")
    public String live(Model model){
        //头部导航栏 焦点标记
        Integer focusFlag=3;
        model.addAttribute("focusFlag",focusFlag);
        return "redirect:https://www.douyu.com/";
    }

    @RequestMapping("/tools/{toolTypeId}")
    public String tools(Model model,Integer pageNum,@PathVariable Integer toolTypeId){
        //头部导航栏 焦点标记
        Integer focusFlag=4;
        model.addAttribute("focusFlag",focusFlag);
        //当点击导航栏的 工具选项的时候  服务器查询出所以工具数据 并返回给前端页面
        PageInfo toolInfo = null;
        if(pageNum==null||pageNum<1){
            pageNum=1;
        }

        if(toolTypeId<1){//如果没有穿tooltypeId 那就默认所有数据都要
            toolInfo = toolService.selectAll(pageNum,16);
        }else{
            toolInfo = toolService.selectToolByTypeId(toolTypeId,pageNum,16);
        }

        PageInfo toolTypeInfo = toolTypeService.selectAll();

        model.addAttribute("toolInfo",toolInfo);
        model.addAttribute("toolTypeInfo",toolTypeInfo);
        model.addAttribute("toolTypeId",toolTypeId);
        return "tool_list";
    }



}
