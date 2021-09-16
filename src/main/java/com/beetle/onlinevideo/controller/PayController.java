package com.beetle.onlinevideo.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.beetle.onlinevideo.config.PayConfig;
import com.beetle.onlinevideo.entity.PayOrder;
import com.beetle.onlinevideo.entity.User;
import com.beetle.onlinevideo.exception.MyException;
import com.beetle.onlinevideo.service.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Controller
public class PayController {

    @Autowired
    PayOrderService payOrderService;


    @RequestMapping("/vipPay")
    public void pay(String tradeName,String money,HttpServletRequest httpReq,HttpServletResponse httpResponse){
//在数据库中生成未支付订单记录
        //生成订单记录需要此时登录的用户的 id
        HttpSession session = httpReq.getSession();
        User user = (User)session.getAttribute("login_user");
        if(user==null){
            throw new MyException("请先登录账户");
        }
        //获取用户id
        Integer uid = user.getId();
        //生成订单 并保存订单记录
        PayOrder order = payOrderService.saveOrder(tradeName,money,uid);
        if(order==null){
            throw new MyException("订单生成失败");
        }



        //实例化客户端
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2021000118616175", "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCOqyvtblj3YhzVe7woYUTsM0zLzO7aosAlzmRFlsLBA7UY2zDT8cyz0YYYQXbLoGpHjchMLeK1sO+JBFfMEh9L9DwsJ7gTueMJPm7EKYV6Y6yXfEBSyb5RbxOfNnA1qlmfrnaeyVPFaaf9M2q5/1cKHr4sfP/ruHb+OPmm/7LDhh3GnHR8SuABlotQtB74IL5ZXI0xaAu7tTBItbGTSE6kzXEOW3Q6T6Z+KwC7zuadEGIEEAl5cDsQiHp8TMK8IxIJxrkVPengXjG4cE17cJ6GGmpuztailH+7aQuB20FVAtdKSCWuoOQN+oT0oybp2SXJthOBwF9shG3kKxmGpYhjAgMBAAECggEAYcfVeox3s01uP67nfbF04IIkb0XMqtKC6SZ0uPEkF8+nrhqEc660wsWmpzcu6U7PqKz3C6cjS62x7nGojvgYtSD2oLi0Q+jSP0Kn/hALKJ/p6YVCPLuCkiOUCjnwXAeeF4AmUpvfq1zHwxUbX9EuYYRCiRE/AdrSy1hXWurDJZfc6AQGHGm6JD/oVt1mSZGclglfqMmUgiNDYDJTsHuZ5On+iIFv5eUBus/I0J+TuQn8GJ61j1R4xEYes8sSIvuy+2v9t5aYHteGsqiuBfST85xa86/p6H50dfHWfGhS/AIfP0Gm4Pci04Grm7XNLR9lJoHQgGryr95uIdsyfzpZGQKBgQDZb0VPLtbOCo8ZjRL1gbSiASao1JTE3dREffP9pHxCOlSP2Z+6x8QtSGozYJIfo42YfitFxHvhUyN8q+uSAcUl2acVMaUsc//iymhIC11XrAwSw6WKun+24QBrVQpaFqE1PDWGL/BFffJh/0EZmrK316VdDGvEW5AA9gCDtJ7jFQKBgQCn+RzUJujGDgUqvsfk6/kYjnUoOXWK9A/dNdgqM8ChZTNsnEkv2zcBOirQK2lYNvUyOp31tR0oX4DSX6cJconL+t/OXQa7/YLoI9q1BXV45yDyopQrFNYl/waQpgPO4HjD8+4fkAcEjjGZWxBOXkddYMJeY81hklvo1uHmFSj7lwKBgADIcctzM7rSNum0pFjV+ryKnIUHHvIGinkkqvhC21+xrhRGiFi313ECTb+ZnW0Xva7K5YT+zCNnlT0hsVt5PiiAvCVLZHjggg9jAzUfNVrXd8OpiLMTMNqLvOCmEb95TWNPsDGngon9hh3sOWPKNtKKqEHJhanTWpVmTWIsCFZxAoGBAJFryBubu/aLeMmy9Zgo+zTZUHCMnki4V2uqDAUtXN3doZGsFGiMHqi/VQV4L/GhUtIzkUGBlUa4t+xpx1EUilvATDZ6rzPdnJGhSN1jZnpPj2TAgAp0NZobmfFs6OsXxzXOXx+QL6Mv/5zHC+ztDle3R080lECe11dTgasSMrLtAoGAYDkzLlojoAZAJ16Puntf1c0Vw6RUcjER3WXp+yffNi129nM8skhUZVWG2g0oyc37JJD/WJN+LLJ6lGyWtfyn07rbyATH2ftcY/42n9TkESR8+l+DsO010TwG8zHr/XYWqK3Ba2srukRiBxR03PNuv3FtkokyPWNr/ObD9iqfWBk=",
//                "json", "UTF-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmIafPJ5MIa5Cdz1/yClxgsrDuOaqhZQbwFV5O7RO9/sb20wYJUqBRGAppt+to65HwDNJMs4xAlJ4LxYjf4psACuejX3NhpUtdB3WaCsHEQEp6zIvrDCp1+l/AB+2lGdVZwTTMcVw/BxHQIipH4V1ReGtsDoHtNC+rl2t+h1IxBW/0l7z1jI1rWxg7dADUVQcmOLw/dKWaSxZSLkkkBwyTt1xihiRaamoWWppK/Tf5186pnCt35mQF5G9bLMy7nskThRo8lz26Ydh1E15BMaVGIpC7zmaHLmMP6oRS92U2NuG/rpP1+CXvJA8PCenkAFxipbBaKqevge3A7GUU0/AOQIDAQAB",
//                "RSA2");
        AlipayClient alipayClient = new DefaultAlipayClient(PayConfig.gatewayUrl,PayConfig.app_id,PayConfig.merchant_private_key,PayConfig.format,PayConfig.charset,PayConfig.alipay_public_key,PayConfig.sign_type);
        AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest(); //创建API对应的request
        //http://beetle.frpgz1.idcfengye.com/   前台支付成功后的回调地址
        alipayRequest.setReturnUrl(PayConfig.return_url);
        alipayRequest.setNotifyUrl(PayConfig.notify_url);
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", order.getOrderNo());
        bizContent.put("total_amount", Float.parseFloat(order.getMoney()));
        bizContent.put("subject", order.getTradeName());
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
        alipayRequest.setBizContent(bizContent.toString());

        String form= "" ;
        try  {
            form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
            httpResponse.setContentType( "text/html;charset="  + "UTF-8");
            httpResponse.getWriter().write(form); //直接将完整的表单html输出到页面
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        }  catch  (Exception e) {
            e.printStackTrace();
        }



    }



    @RequestMapping("notifyPay")
    public void notifyPay(HttpServletRequest request,HttpServletResponse response){
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        Iterator it = requestParams.keySet().iterator();
        while(it.hasNext()){
            String key=(String) it.next();
            String []values = requestParams.get(key);
            String varStr ="";
            for(int i =0;i< values.length;i++){
                varStr = (i== values.length-1)?varStr+values[i]:
                        varStr+values[i]+",";
            }
//            try {
                    //如何支付宝服务器发送的报文有乱码情况 则设置这个即可
//                varStr = new String(varStr.getBytes("ISO-8859-1"), "utf-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
            params.put(key, varStr);
        }
        System.out.println(params);

        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(params, PayConfig.alipay_public_key, PayConfig.charset, PayConfig.sign_type); //调用SDK验证签名
            if(signVerified){//验证签名 验证成功
                //trade_no  支付宝交易号。支付宝交易凭证号。
                // out_trade_no 商户订单号。原支付请求的商户订单号
                //gmt_payment 交易付款时间。
                //将订单状态变更成已支付 并且将该用户变为会员


                String tradeStatus=params.get("trade_status");

                if(tradeStatus.equals("TRADE_FINISHED")){
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //如果有做过处理，不执行商户的业务程序

                    //注意：
                    //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                }else if (tradeStatus.equals("TRADE_SUCCESS")){
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //如果有做过处理，不执行商户的业务程序

                    //支付成功 将订单状态变更为 已支付 并记录一些信息
                    payOrderService.paySuccess(params.get("out_trade_no"),params.get("trade_no"),params.get("gmt_payment"));
                    //修改用户会员状态
                    payOrderService.paySuccessChangeVip(params.get("out_trade_no"));
                    //注意：
                    //付款完成后，支付宝系统发送该交易状态通知

                    response.getWriter().write("success");
                }

            }else{//验签失败 可能不是支付宝服务器发送的

            }



        } catch (Exception e) {
            e.printStackTrace();
        }




    }








}



