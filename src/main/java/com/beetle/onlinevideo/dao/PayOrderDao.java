package com.beetle.onlinevideo.dao;

import com.beetle.onlinevideo.entity.PayOrder;

public interface PayOrderDao {


    //根据给定条件查询
    public PayOrder selectOne(PayOrder order);

    //根据给定数订单编号 修改status
    public Integer update(PayOrder order);

    //根据给定数据保存
    public Integer insert(PayOrder order);

}
