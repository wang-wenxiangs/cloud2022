package com.atguigu.springcloud.controoler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderControoler {

    private final static String SERVER_PORT = "http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(SERVER_PORT+"/payment/zk",String.class);
        System.out.println("消费者调用支付服务(zookeeper)--->result:" + result);
        return result;

    }
}
