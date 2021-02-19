package com.education.edu_teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages ={"com.education"})
public class EduApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(EduApplication.class, args);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
