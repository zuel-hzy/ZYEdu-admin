package com.education.msm.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Api(description = "阿里云短信服务")
@RequestMapping("/msm")
public class MsmController {
}
