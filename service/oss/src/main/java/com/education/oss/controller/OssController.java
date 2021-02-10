package com.education.oss.controller;

import com.education.oss.service.OssService;
import com.education.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/fileoss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;

    //上传头像
    @PostMapping("/upload")
    public Result uploadOssFile(MultipartFile file) throws IOException {

        String url = ossService.uploadFileAvart(file);
        return Result.ok().data("url",url);
    }
}
