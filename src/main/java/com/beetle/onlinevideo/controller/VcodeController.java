package com.beetle.onlinevideo.controller;

import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@SessionAttributes("vcode")
@Controller
public class VcodeController {

    @ResponseBody
    @RequestMapping("/checkVcode")
    public Integer checkVcode(String vcode, HttpSession session){

        String svcode = (String)session.getAttribute("vcode");

        //UserResponseResult result = new UserResponseResult(0,"验证码正确");
        if(!svcode.equals(vcode)){//如验证码错误 则返回1
//            result.setRcode(1);
//            result.setMessage("验证码错误");
            return 1;
        }
        return 0;
    }



    char[] vcodeSequence = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    @RequestMapping("/vcode")
    public void vcode(HttpServletResponse response, Model model){
        //页面需要一个验证码图片
        //设置生成图片的属性
        BufferedImage bufferedImage = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
        Graphics2D gd = bufferedImage.createGraphics();
        gd.setColor(Color.WHITE);
        gd.drawRect(0,0,80,30);

        Font font = new Font("正楷",Font.BOLD,25);

        gd.setFont(font);

        //生成随机验证码
        StringBuffer vcode = new StringBuffer();
        for(int i =0;i<4;i++){
            String rdStr=String.valueOf(vcodeSequence[RandomUtil.randomInt(0,10)]);
            vcode.append(rdStr);
            //一共四位数验证码 每个数字颜色随机
            Color color = new Color(RandomUtil.randomInt(0,255),RandomUtil.randomInt(0,255),RandomUtil.randomInt(0,255));
            gd.setColor(color);
            gd.drawString(rdStr,(i+1)*15,25);
        }
        //设置响应资源是 image
        //https://tool.oschina.net/commons http协议规定数据类型
        response.setContentType("image/jpeg");
        //设置响应回去的资源 不缓存
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma", "No-Cache");
        response.setDateHeader("Expires", 0);

        try {

           ServletOutputStream os =response.getOutputStream();
           ImageIO.write(bufferedImage,"jpeg",os);
           os.flush();
           os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //将验证码存入session作用域  注册的时候便于验证
        model.addAttribute("vcode",vcode.toString());
    }

}
