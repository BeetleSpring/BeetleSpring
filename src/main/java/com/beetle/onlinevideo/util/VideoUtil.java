package com.beetle.onlinevideo.util;





import cn.hutool.crypto.digest.DigestUtil;
import com.beetle.onlinevideo.dto.LoginToken;
import com.beetle.onlinevideo.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class VideoUtil {

    //获取请求的ip
    public static String getIpAddress(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(XFor !=null && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(XFor !=null && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (XFor ==null || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (XFor ==null || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (XFor ==null || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (XFor ==null || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (XFor ==null || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }

    //将loginToken计算一个 token值  md5
    public static String createToken(LoginToken loginToken){

        String str = loginToken.toString();
        return DigestUtil.md5Hex(str);
    }
    //获取cookie中的 auto_login_token
    public static String getCookieToken(HttpServletRequest request){
        String bToken=null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if("auto_login_token".equals(cookie.getName())) {//如果浏览器有这个名字的cookie 表示上次已经保存了自动登录
                bToken = cookie.getValue();//浏览器中缓存的tooken值
            }
        }
        return bToken;
    }
}
