package com.education.sms.controller;


import com.education.sms.service.SmsService;
import com.education.sms.utils.RandomUtil;
import com.education.utils.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@Api(description = "阿里云短信服务")
@RequestMapping("/sms")
public class SmsController {
    @Autowired
    private SmsService smsService;

    //短信发送
    @GetMapping("send/{phone}")
    public Result send(@PathVariable String phone){

        String code = RandomUtil.getFourBitRandom();
        Map<String,Object> param = new HashMap<>();
        param.put("code",code);

        boolean isSend = smsService.send(param,phone);
        if(isSend){
            return Result.ok();
        }else {
            return Result.error().message("短信发送失败");
        }
    }

}
