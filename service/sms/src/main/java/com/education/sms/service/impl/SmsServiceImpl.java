package com.education.sms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.education.sms.service.SmsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public boolean send(Map<String, Object> param, String phone) {
        if(StringUtils.isEmpty(phone)) return false;

        DefaultProfile profile =DefaultProfile.getProfile("default", "LTAI4FrCLM4fkG1TDWGguGrv", "BMl579LpWu7JeQLLl1JAaQC0jfwCrP");
        IAcsClient client = new DefaultAcsClient(profile);

        //TODO:写法有更新
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "HZYEdu");
        request.putQueryParameter("TemplateCode", "SMS_211489480");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));

        try{
            CommonResponse response = client.getCommonResponse(request);
            return response.getHttpResponse().isSuccess();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
