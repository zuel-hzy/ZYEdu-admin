package com.education.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.education"})
@MapperScan("com.education.cms.mapper")
//内容管理系统
public class CmsApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(CmsApplication.class, args);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
