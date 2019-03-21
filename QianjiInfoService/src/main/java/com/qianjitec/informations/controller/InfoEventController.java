package com.qianjitec.informations.controller;

import com.qianjitec.common.annotation.RequiresGuest;
import com.qianjitec.common.security.ErrorCode;
import com.qianjitec.common.utils.ResultData;
import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.entity.InfoEventEntity;
import com.qianjitec.informations.model.form.InfoEventForm;
import com.qianjitec.informations.service.InfoEventService;
import com.qianjitec.informations.utils.ControllerRepeateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "活动信息管理")
@Validated
@RequiresGuest
@RestController
@RequestMapping("/api/infomations")
public class InfoEventController {
    Logger logger = LoggerFactory.getLogger(InfoEventController.class);

    @Autowired
    private InfoEventService infoEventService;

    @ApiOperation(value = "获取活动信息")
    @GetMapping("/getEvents")
    public ResultData<List<InfoEventEntity>> getEvents(InfoEventForm form){
        logger.info("获取活动信息");
        ResultPage events = infoEventService.getInfoEvents(form);

        //判断是否有活动
        String msg = "活动信息";
        return (ResultData<List<InfoEventEntity>>)(ControllerRepeateUtil.getResultData(msg,events));
    }
}
