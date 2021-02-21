package com.education.sms.controller;


import com.education.sms.service.SmsService;
import com.education.sms.utils.RandomUtil;
import com.education.utils.result.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@CrossOrigin
@RestController
@Api(description = "阿里云短信服务")
@RequestMapping("/sms")
public class SmsController {
    @Autowired
    private SmsService smsService;
    @Autowired
    private RedisTemplate<String ,String > redisTemplate;

    //短信发送
    @GetMapping("send/{phone}")
    public Result send(@PathVariable String phone){
        //从redis中取验证码值
        String  code = redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)) {
            return Result.ok();
        }

        //若redis中无验证码，生成随机值，阿里云发送
        code = RandomUtil.getFourBitRandom();
        Map<String,Object> param = new HashMap<>();
        param.put("code",code);

        System.out.println(code);
        boolean isSend = smsService.send(param,phone);
        if(isSend){
            //将验证码放入redis
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            return Result.ok();
        }else {
            return Result.error().message("短信发送失败");
        }
    }

}
