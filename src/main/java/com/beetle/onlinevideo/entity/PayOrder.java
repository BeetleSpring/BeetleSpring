package com.beetle.onlinevideo.entity;

import java.util.Date;

public class PayOrder {

    private Integer id;
    //订单编号
    private String orderNo;
    //商品名称
    private String tradeName;
    //商品的价格
    private String money;
    //订单状态   0 为未支付  1 为已支付
    private Integer status;
    //支付方式  0表示支付宝 1表示微信
    private Integer payMethod;
    //支付宝或者微信端产生的 订单编号
    private String payNo;
    //支付该订单的 用户id
    private Integer uid;
    //支付时间
    private String payTime;
    //订单创建时间
    private String createTime;


    public PayOrder() {
    }

    public PayOrder(Integer id, String orderNo, String tradeName, String money, Integer status, Integer payMethod, String payNo, Integer uid, String payTime, String createTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.tradeName = tradeName;
        this.money = money;
        this.status = status;
        this.payMethod = payMethod;
        this.payNo = payNo;
        this.uid = uid;
        this.payTime = payTime;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
