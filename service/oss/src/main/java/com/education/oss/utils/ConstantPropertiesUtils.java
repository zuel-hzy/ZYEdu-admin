package com.education.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils implements InitializingBean {
    //读取配置文件
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyId;
    @Value("${aliyun.oss.file.keysecret}")
    private String keySecreet;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketName;

    public static String END_PONIT;
    public static String KEY_ID;
    public static String KEY_SECREET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_PONIT = endpoint;
        KEY_ID = keyId;
        KEY_SECREET = keySecreet;
        BUCKET_NAME = bucketName;
    }

}
