package com.education.edu_teacher.client;

import com.education.utils.result.Result;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VodFeignClient implements VodClient {

    //出错时执行
    @Override
    public Result removeVideo(String id) {
        return Result.error().message("删除视频错误");
    }

    @Override
    public Result removeVideoList(List<String> videoIdList) {
        return Result.error().message("删除多个视频错误");
    }
}
