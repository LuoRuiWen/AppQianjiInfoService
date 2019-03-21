package com.qianjitec.informations.controller;

import com.qianjitec.common.annotation.RequiresGuest;
import com.qianjitec.common.security.ErrorCode;
import com.qianjitec.common.utils.ResultData;
import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.entity.InfoEventEntity;
import com.qianjitec.informations.entity.InfoNewsEntity;
import com.qianjitec.informations.model.form.InfoNewsForm;
import com.qianjitec.informations.service.InfoNewsService;
import com.qianjitec.informations.utils.ControllerRepeateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("页面信息管理")
@Validated
@RequiresGuest
@RestController
@RequestMapping("/api/informations")
public class InfoNewsController {

    Logger logger = LoggerFactory.getLogger(InfoNewsController.class);
    @Autowired
    private InfoNewsService infoNewsService;

    @GetMapping("/getExclusiveInformation")
    public ResultData<List<InfoNewsEntity>> getInfoNews(InfoNewsForm form){

        logger.info("获取独家信息");
        ResultPage news = infoNewsService.getInfoNews(form);
        String msg = "独家信息";
        return (ResultData<List<InfoNewsEntity>>)(ControllerRepeateUtil.getResultData(msg,news));
    }


}
