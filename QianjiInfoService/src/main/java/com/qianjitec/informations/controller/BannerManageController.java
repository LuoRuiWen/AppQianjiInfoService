package com.qianjitec.informations.controller;


import com.qianjitec.common.annotation.RequiresGuest;
import com.qianjitec.common.security.ErrorCode;
import com.qianjitec.common.utils.ResultData;
import com.qianjitec.informations.entity.BannerEntity;
import com.qianjitec.informations.entity.InfoNewsEntity;
import com.qianjitec.informations.service.BannerService;
import com.qianjitec.informations.utils.ControllerRepeateUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiresGuest
@RequestMapping("/api/informations")
public class BannerManageController {
    Logger logger = LoggerFactory.getLogger(BannerManageController.class);
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/getBannerInfo/{id}")
    public ResultData<BannerEntity> getBannerEntity(@PathVariable String id){
        logger.info("查询横幅详情");
        String msg = "横幅详情";
        BannerEntity banner=bannerService.getBanner(id);
        return (ResultData<BannerEntity>)(ControllerRepeateUtil.getResultData(msg,banner));
    }


}
