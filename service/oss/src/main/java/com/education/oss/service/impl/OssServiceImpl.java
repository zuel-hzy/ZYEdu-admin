package com.education.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.education.oss.service.OssService;
import com.education.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvart(MultipartFile file) throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ConstantPropertiesUtils.END_PONIT;
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SECREET;
        String buketName = ConstantPropertiesUtils.BUCKET_NAME;

        System.out.println(endpoint);
        System.out.println(accessKeyId);
        System.out.println(accessKeySecret);
        System.out.println(buketName);


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        InputStream inputStream = file.getInputStream();
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String datePath = new DateTime().toString("yyyy/MM/dd");
        String fileName = datePath+"/"+uuid+file.getOriginalFilename();

        ossClient.putObject(buketName, fileName, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        String url = "https://"+buketName+"."+endpoint+"/"+fileName;
        return url;

    }
}
