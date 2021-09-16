package com.beetle.onlinevideo.service;

import com.beetle.onlinevideo.entity.PayOrder;

public interface PayOrderService {

    public PayOrder saveOrder(String tradeName, String money,Integer uid);

    public PayOrder getOrder(String orderNo);

    public boolean paySuccess(String orderNo,String payNo,String payTime);

    public boolean paySuccessChangeVip(String orderNo);

}
