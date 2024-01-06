package cn.itcast.order.service;


import cn.itcast.feign.client.UserClient;
import cn.itcast.feign.pojo.Order;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {

        Order order = orderMapper.findById(orderId);
        User userById = userClient.findUserById(order.getUserId());
        order.setUser(userById);
        return order;
    }

    @SentinelResource("goods")
    public void queryGoods(){
        System.out.println("service layer query good");
    }
}
