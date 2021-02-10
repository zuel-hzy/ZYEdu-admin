package com.education.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface OssService {
    String uploadFileAvart(MultipartFile file) throws IOException;
}
