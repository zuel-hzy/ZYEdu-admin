package com.education.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.education"})
@MapperScan("com.education.account.mapper")
public class AccountApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(AccountApplication.class, args);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
