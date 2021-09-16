package com.beetle.onlinevideo.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

import java.io.FileWriter;
import java.io.IOException;

public class PayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000118616175";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCOqyvtblj3YhzVe7woYUTsM0zLzO7aosAlzmRFlsLBA7UY2zDT8cyz0YYYQXbLoGpHjchMLeK1sO+JBFfMEh9L9DwsJ7gTueMJPm7EKYV6Y6yXfEBSyb5RbxOfNnA1qlmfrnaeyVPFaaf9M2q5/1cKHr4sfP/ruHb+OPmm/7LDhh3GnHR8SuABlotQtB74IL5ZXI0xaAu7tTBItbGTSE6kzXEOW3Q6T6Z+KwC7zuadEGIEEAl5cDsQiHp8TMK8IxIJxrkVPengXjG4cE17cJ6GGmpuztailH+7aQuB20FVAtdKSCWuoOQN+oT0oybp2SXJthOBwF9shG3kKxmGpYhjAgMBAAECggEAYcfVeox3s01uP67nfbF04IIkb0XMqtKC6SZ0uPEkF8+nrhqEc660wsWmpzcu6U7PqKz3C6cjS62x7nGojvgYtSD2oLi0Q+jSP0Kn/hALKJ/p6YVCPLuCkiOUCjnwXAeeF4AmUpvfq1zHwxUbX9EuYYRCiRE/AdrSy1hXWurDJZfc6AQGHGm6JD/oVt1mSZGclglfqMmUgiNDYDJTsHuZ5On+iIFv5eUBus/I0J+TuQn8GJ61j1R4xEYes8sSIvuy+2v9t5aYHteGsqiuBfST85xa86/p6H50dfHWfGhS/AIfP0Gm4Pci04Grm7XNLR9lJoHQgGryr95uIdsyfzpZGQKBgQDZb0VPLtbOCo8ZjRL1gbSiASao1JTE3dREffP9pHxCOlSP2Z+6x8QtSGozYJIfo42YfitFxHvhUyN8q+uSAcUl2acVMaUsc//iymhIC11XrAwSw6WKun+24QBrVQpaFqE1PDWGL/BFffJh/0EZmrK316VdDGvEW5AA9gCDtJ7jFQKBgQCn+RzUJujGDgUqvsfk6/kYjnUoOXWK9A/dNdgqM8ChZTNsnEkv2zcBOirQK2lYNvUyOp31tR0oX4DSX6cJconL+t/OXQa7/YLoI9q1BXV45yDyopQrFNYl/waQpgPO4HjD8+4fkAcEjjGZWxBOXkddYMJeY81hklvo1uHmFSj7lwKBgADIcctzM7rSNum0pFjV+ryKnIUHHvIGinkkqvhC21+xrhRGiFi313ECTb+ZnW0Xva7K5YT+zCNnlT0hsVt5PiiAvCVLZHjggg9jAzUfNVrXd8OpiLMTMNqLvOCmEb95TWNPsDGngon9hh3sOWPKNtKKqEHJhanTWpVmTWIsCFZxAoGBAJFryBubu/aLeMmy9Zgo+zTZUHCMnki4V2uqDAUtXN3doZGsFGiMHqi/VQV4L/GhUtIzkUGBlUa4t+xpx1EUilvATDZ6rzPdnJGhSN1jZnpPj2TAgAp0NZobmfFs6OsXxzXOXx+QL6Mv/5zHC+ztDle3R080lECe11dTgasSMrLtAoGAYDkzLlojoAZAJ16Puntf1c0Vw6RUcjER3WXp+yffNi129nM8skhUZVWG2g0oyc37JJD/WJN+LLJ6lGyWtfyn07rbyATH2ftcY/42n9TkESR8+l+DsO010TwG8zHr/XYWqK3Ba2srukRiBxR03PNuv3FtkokyPWNr/ObD9iqfWBk=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmIafPJ5MIa5Cdz1/yClxgsrDuOaqhZQbwFV5O7RO9/sb20wYJUqBRGAppt+to65HwDNJMs4xAlJ4LxYjf4psACuejX3NhpUtdB3WaCsHEQEp6zIvrDCp1+l/AB+2lGdVZwTTMcVw/BxHQIipH4V1ReGtsDoHtNC+rl2t+h1IxBW/0l7z1jI1rWxg7dADUVQcmOLw/dKWaSxZSLkkkBwyTt1xihiRaamoWWppK/Tf5186pnCt35mQF5G9bLMy7nskThRo8lz26Ydh1E15BMaVGIpC7zmaHLmMP6oRS92U2NuG/rpP1+CXvJA8PCenkAFxipbBaKqevge3A7GUU0/AOQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://beetle.frpgz1.idcfengye.com/notifyPay";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://beetle.frpgz1.idcfengye.com/";

    // 参数返回格式，只支持 JSON 格式。
    public static String sign_type = "RSA2";

    // 签名方式
    public static String format = "json";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    //日志记录地址
    public static String log_path = "D:\\test\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

