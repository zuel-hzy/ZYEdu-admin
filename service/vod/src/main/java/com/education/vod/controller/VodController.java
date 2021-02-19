package com.education.vod.controller;

import com.education.utils.result.Result;
import com.education.vod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/vod/video")
@CrossOrigin
@Api(description = "阿里云视频点播服务")
public class VodController {

    @Autowired
    private VodService vodService;

    //上传视频
    @PostMapping("uploadVideo")
    public Result uploadVideo(MultipartFile file){
        String videoId = vodService.uploadVideo(file);
        return Result.ok().data("videoId",videoId);
    }

    //根据id删除视频
    @DeleteMapping("removeVideo/{id}")
    public Result removeVideo(@PathVariable String id){
        vodService.removeVideo(id);
        return  Result.ok();
    }

    /**
     * 批量删除阿里云上的多个
     */
    @DeleteMapping("removeVideoList")
    public Result removeVideoList(
            @ApiParam(name = "videoIdList", value = "云端视频多个id", required = true)
            @RequestParam("videoIdList") List<String> videoIdList){

        vodService.removeVideoList(videoIdList);
        return Result.ok().message("视频删除成功");
    }
}
