package com.beetle.onlinevideo.controller.adminController;

import com.beetle.onlinevideo.entity.User;
import com.beetle.onlinevideo.exception.MyException;
import com.beetle.onlinevideo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserAdminController {

    @Autowired
    UserService userService;

    @RequestMapping("/userAdmin")
    public String userAdmin(Model model, Integer pageNum){
        if(pageNum==null||pageNum<=1){
            pageNum=1;
        }
        //查询所有用户 并将信息显示在页面里面
        PageInfo userInfo = userService.selectAll(pageNum,12);
        model.addAttribute("userInfo",userInfo);
        return "admin_main";
    }

    @RequestMapping("/userAdmin/delUser")
    public String delUser(Integer uid,Integer pageNum){
        if(uid==null||uid<1) {//表示参数非法
            throw new MyException("删除用户参数非法");
        }
        userService.deleteUser(uid);
        return "redirect:/userAdmin?pageNum="+pageNum;
    }

    @RequestMapping("/userAdmin/updatePage")
    public String updateUserPage(Integer uid,Integer pageNum,Model model){
        if(uid==null||uid<1){
            throw new MyException("修改用户信息参数异常");
        }
        User user = userService.getUserById(uid);
        model.addAttribute("user",user);
        model.addAttribute("pageNum",pageNum);
        return "adminUser_update";
    }

    @RequestMapping("/userAdmin/updateUser")
    public String updateUser(User user,Integer pageNum){

        userService.updateUser(user);
        return "redirect:/userAdmin?pageNum="+pageNum;
    }

}
