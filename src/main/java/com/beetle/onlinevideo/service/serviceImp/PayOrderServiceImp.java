package com.beetle.onlinevideo.service.serviceImp;

import cn.hutool.core.date.DateUtil;
import com.beetle.onlinevideo.dao.PayOrderDao;
import com.beetle.onlinevideo.dao.UserDao;
import com.beetle.onlinevideo.entity.PayOrder;
import com.beetle.onlinevideo.service.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PayOrderServiceImp implements PayOrderService {

    @Autowired
    PayOrderDao payOrderDao;
    @Autowired
    UserDao userDao;

    @Override
    public PayOrder saveOrder(String tradeName, String money,Integer uid) {//创建订单并保存进数据库

        PayOrder order =null;
        try{
            order = new PayOrder();
            order.setOrderNo(System.currentTimeMillis()+"");
            order.setCreateTime(DateUtil.now());
            order.setTradeName(tradeName);
            order.setPayMethod(0);
            order.setMoney(money);
            order.setStatus(0);
            order.setUid(uid);
            Integer flag = payOrderDao.insert(order);
            if(flag==null||flag<=0){
                throw new Exception("订单保存失败");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public PayOrder getOrder(String orderNo) { //给定订单编号查询订单
        PayOrder order = null;
        try{
            PayOrder orderWhere = new PayOrder();
            orderWhere.setOrderNo(orderNo);
            order = payOrderDao.selectOne(orderWhere);

        }catch (Exception e){//查询单条订单出错 可能查出多条 或者没有查到
            e.printStackTrace();
            return  null;
        }

        return order;
    }

    @Override
    public boolean paySuccess(String orderNo, String payNo, String payTime) {
        //订单支付成功 修改预存订单信息
        //修改之前先查询订单 看看是否存在
        try {
            PayOrder order = getOrder(orderNo);
            if (order == null) {
                throw new Exception("订单不存在");
            }
            PayOrder updateOrder = new PayOrder();
            updateOrder.setOrderNo(orderNo);
            updateOrder.setPayNo(payNo);
            updateOrder.setPayTime(payTime);
            updateOrder.setStatus(1);
            payOrderDao.update(updateOrder);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //根据订单号查询用户id  用于于支付成功后将用户信息记录为会员
    public boolean paySuccessChangeVip(String orderNo){
        PayOrder order = new PayOrder();
        order.setOrderNo(orderNo);
        Integer uid = payOrderDao.selectOne(order).getUid();
        userDao.updateVip(uid);
        return true;
    }
}
