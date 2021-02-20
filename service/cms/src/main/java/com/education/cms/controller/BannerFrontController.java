package com.education.cms.controller;

import com.education.cms.entity.CrmBanner;
import com.education.cms.service.CrmBannerService;
import com.education.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cms/bannerFront")
@Api(description = "banner管理-用户端")
@CrossOrigin
public class BannerFrontController {
    @Autowired
    private CrmBannerService crmBannerService;

    //分页查询banner
    @ApiOperation(value = "查询banner")
    @GetMapping("getBanner")
    public Result getBanner(){
        List<CrmBanner> list = crmBannerService.seleteAllBanner();
        return Result.ok().data("list",list);
    }
}
