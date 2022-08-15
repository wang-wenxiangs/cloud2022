package com.atguigu.springcloud.cfgbeans;

import feign.Logger;
import jdk.internal.net.http.hpack.HPACK;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level FeignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
