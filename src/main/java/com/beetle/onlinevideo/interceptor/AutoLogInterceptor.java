package com.beetle.onlinevideo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.beetle.onlinevideo.dto.LoginToken;


public class AutoLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //浏览器带着登录凭证 来自动登录
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        if(cookies==null)//如果用户是第一次登录 可能存在没有cookie 这样的话会导致空指针 做个严谨的判断
            return true;
        for(Cookie cookie:cookies){
            if("auto_login_token".equals(cookie.getName())){//如果浏览器有这个名字的cookie 表示上次已经保存了自动登录
                String bToken = cookie.getValue();//浏览器中缓存的tooken值
                if(bToken!=null){
                    //获取服务器 缓存自动登录的容器
                    //考虑一个问题 当服务器停机重启 自动登录的用户数据全部丢失 此时服务器重启完 而用户拿着token来自动登录而服务器中又没有数据 应该如何处理
                    ServletContext application = request.getServletContext();
                    HashMap<String, LoginToken> map = (HashMap<String,LoginToken>)application.getAttribute("autoLoginMap");
                    if(map==null){
                        //用户手中有token 而服务器没数据  服务器数据丢失
                        //可以让用户手中的token失效 并返回首页 让其重新登录
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                        return true;
                    }else{
                        LoginToken loginToken = map.get(bToken);
                        if(loginToken==null){//服务器数据丢失
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                            return true;
                        }else{//如果loginToken不为null  验证凭证是否失效
                            String time1 = loginToken.getNow();
                            if(System.currentTimeMillis()-Long.parseLong(time1)>=172800000){//表示凭证失效
                                cookie.setMaxAge(0);
                                response.addCookie(cookie);
                                map.remove(bToken);
                            }else{//凭证好使
                                session.setAttribute("login_user",loginToken.getUser());
                            }
                            return true;

                        }
                    }

                }

            }
        }
        return true;
    }
}
