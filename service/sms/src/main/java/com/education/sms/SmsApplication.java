package com.education.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages ={"com.education"})
public class SmsApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SmsApplication.class, args);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
