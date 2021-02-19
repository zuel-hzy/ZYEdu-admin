package com.education.edu_teacher.client;

import com.education.utils.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "service-vod")
public interface VodClient {
    //定义要调用方法的路径
    //根据id删除视频
    @DeleteMapping(value = "/vod/video/removeVideo/{id}")
    public Result removeVideo(@PathVariable("id") String id);

    //根据id批量删除视频
    @DeleteMapping(value = "/vod/video/removeVideoList")
    public Result removeVideoList(@RequestParam("videoIdList") List<String> videoIdList);
}
