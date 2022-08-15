package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.Impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        System.out.println("王文祥");
        log.info("*****插入操作返回结果:" + result);
        if (result >0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(500,"插入数据失败serverPort:"+serverPort,result);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public  CommonResult<Payment> GetPaymentById(@PathVariable("id") long id){
       Payment payment =  paymentService.GetPaymentById(id);
        log.info("*****插入查询返回结果:" + payment);
        System.out.println(payment);
        if (payment != null){
            return new CommonResult(200,"查询到数据serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(500,"没有查到数据serverPort:"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut()
    {
        System.out.println("*****paymentFeignTimeOut from port: "+serverPort);
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/lb")
    public String paymentId(){
        return serverPort;
    }

}
