package com.beetle.onlinevideo.controller;

import cn.hutool.core.util.ReUtil;
import com.beetle.onlinevideo.dto.LoginToken;
import com.beetle.onlinevideo.dto.UserResponseResult;
import com.beetle.onlinevideo.entity.User;
import com.beetle.onlinevideo.exception.MyException;
import com.beetle.onlinevideo.service.UserService;
import com.beetle.onlinevideo.util.VideoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

//@SessionAttributes("login_user")
@Controller
public class UserController {



    @Autowired
    UserService service;


    //登录之前 检查登录信息是否正确
    @ResponseBody
    @RequestMapping(path = "/checkUser",method = RequestMethod.POST )
    public Integer checkUser(User user){
        if(user.getEmail()==null||user.getPassword()==null){
            throw new MyException("登录信息错误");
        }
        User dbUser = service.loginCheck(user);
        Integer result = 0;
        if(dbUser==null){//表示用户名或密码错误
            result = 1;
        }
        return result;
    }

    //注册请求
    @RequestMapping("/regist")
    public String reigst(User user, HttpSession session,String vcode){

        String sVcode=(String) session.getAttribute("vcode");
        //防止前端直接发送 /regist请求 直接注册账号 跳过验证码
        if(sVcode==null||!sVcode.equals(vcode)){
            throw new MyException("验证码错误");
        }

        //验证注册信息是否正确  防止前端直接发送 /regist请求 恶意注册账号
        Boolean emailCheck= ReUtil.isMatch("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?",user.getEmail());
        Boolean passwordCheck=ReUtil.isMatch("^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,20}$",user.getPassword());
        Boolean telephoneCheck=ReUtil.isMatch(("1[3456789]\\d{9}$"),user.getTelephone());
        System.out.println(emailCheck+"--"+passwordCheck+"--"+telephoneCheck);
        //如果有一个不符合要求 则抛出注册信息错误
        if(!(emailCheck&&passwordCheck&&telephoneCheck)){
            throw new MyException("注册信息错误");
        }

        //以上验证都通过 则开始往数据库插入信息

        Integer result = service.register(user);
        if(result!=1){//如果信息插入失败
            throw new MyException("注册失败");

        }

        //否则注册成功
        // 注册成功直接登录
        session.setAttribute("login_user", user);

        //注册成功后返回首页
        return "redirect:/";


    }


    //验证查询的邮件是否已被注册
    @ResponseBody
    @RequestMapping("/checkEmail")
    public UserResponseResult checkEmail(String email){

        User user = service.checkEmail(email);
        UserResponseResult result = new UserResponseResult(0,"OK");
        if(user!=null){
            //表示已存在再用户
            result.setRcode(1);
            result.setMessage("该邮件已被注册");

        }
        return result;
    }

    //登录请求
    @RequestMapping("/login")
    public String login(User user, HttpSession session, String autoLogin, HttpServletRequest request, HttpServletResponse response){

        if(user.getEmail()==null||user.getPassword()==null){
            throw new MyException("登录信息错误");
        }

        User dbUser = service.loginCheck(user);
        if(dbUser==null){//表示用户名或密码错误

        }
        //否则 登录成功 将正确的用户信息放入session作用域
        session.setAttribute("login_user",dbUser);
        //model.addAttribute("login_user",dbUser);

        // TODO   功能自动登录
        //逻辑流程：
        //			浏览器（cookie） 存入一个  token=xxxxx(登录凭证，访问的时候带着这个)
        //
        //			服务器（）
        //			1.登录成功  返回token给浏览器保存   自动登录凭证
        //			2.token生成
        //				token--->时间，用户，ip，浏览器信息
        //			用户打开浏览器
        //			1.token发送到服务器
        //			2.服务器根据token获取对应的值
        //			3.验证token是否有效





        if(autoLogin!=null&&"1".equals(autoLogin)){//用户点击了自动登录
            //使用LoginToken 弄一个唯一的key  然后将这个存在 application中

            String time = ""+System.currentTimeMillis();
            String userAgent = request.getHeader("User-Agent");
            String ip = VideoUtil.getIpAddress(request);

            LoginToken loginToken = new LoginToken(ip,time,userAgent,dbUser);

            String token = VideoUtil.createToken(loginToken);
            //获取服务器 缓存自动登录的容器
            ServletContext application = request.getServletContext();
            HashMap<String,LoginToken> map = (HashMap<String,LoginToken>)application.getAttribute("autoLoginMap");
            if(map==null){//表示其中暂时没有这个缓存 可能是第一个缓存的用户
                map = new HashMap<String,LoginToken>();
                application.setAttribute("autoLoginMap",map);
            }
            //将需要自动登录的对象 缓存进服务器
            map.put(token,loginToken);
            Cookie cookie = new Cookie("auto_login_token",token);
            //设置凭证消失时间为2天  60*60**48
            cookie.setMaxAge(60*60*48);
            response.addCookie(cookie);
        }

        //然后重定向去首页
        return "redirect:/";
    }

    //登出 请求
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session,HttpServletRequest request){

        session.removeAttribute("login_user");
        ServletContext application = request.getServletContext();
        HashMap<String,LoginToken> map = (HashMap<String,LoginToken>)application.getAttribute("autoLoginMap");
        String token=VideoUtil.getCookieToken(request);
        if(map!=null&&token!=null){//需要删除 服务器缓存的自动登录数据
            Cookie cookie = new Cookie("auto_login_token","");
            cookie.setMaxAge(-1);
            map.remove(token);
        }

        return "redirect:/";
    }

}
