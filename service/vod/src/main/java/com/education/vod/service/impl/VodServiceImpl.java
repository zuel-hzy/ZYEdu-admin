package com.education.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.education.config.exception.EduException;
import com.education.vod.service.VodService;
import com.education.vod.utils.InitVodClient;
import com.education.vod.utils.ConstantPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class VodServiceImpl implements VodService {
    @Override
    public String uploadVideo(MultipartFile file) {

        try{
            String fileName = file.getOriginalFilename();
            String title = fileName.substring(0, fileName.lastIndexOf("." ));
            InputStream inputStream = file.getInputStream();

            UploadStreamRequest request = new UploadStreamRequest(ConstantPropertiesUtil.KEY_ID, ConstantPropertiesUtil.KEY_SECRET, title, fileName, inputStream);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);

            String videoId = null;
            if (response.isSuccess()) {
                videoId = response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                videoId = response.getVideoId();
            }
            return videoId;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void removeVideo(String id) {
        try{
            // 初始化对象
            DefaultAcsClient client = InitVodClient.initVodClient(
                    ConstantPropertiesUtil.KEY_ID,
                    ConstantPropertiesUtil.KEY_SECRET);

            // 创建删除视频request对象
            DeleteVideoRequest request = new DeleteVideoRequest();

            // 向request设置视频id
            request.setVideoIds(id);

            client.getAcsResponse(request);

        }catch (ClientException e){
            throw new EduException(20001, "视频删除失败");
        }
    }
}
