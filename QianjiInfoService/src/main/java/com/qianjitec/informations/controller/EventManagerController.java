package com.qianjitec.informations.controller;

import com.qianjitec.common.annotation.RequiresGuest;
import com.qianjitec.common.security.ErrorCode;
import com.qianjitec.common.utils.ResultData;
import com.qianjitec.informations.entity.BannerEntity;
import com.qianjitec.informations.entity.InfoEventEntity;
import com.qianjitec.informations.service.InfoEventService;
import com.qianjitec.informations.utils.ControllerRepeateUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiresGuest
@RequestMapping("/api/informations")
public class EventManagerController {
    Logger logger = LoggerFactory.getLogger(EventManagerController.class);

    @Autowired
    private InfoEventService infoEventService;

    @ApiOperation("查看活动详情")
    @GetMapping("/getEventInfo/{id}")
    public ResultData<InfoEventEntity> getEventInfo(@PathVariable String id){
        logger.info("查看活动详情");
        InfoEventEntity infoEventEntity = infoEventService.getEventInfo(id);
        //判断是否存在相应活动
        String msg = "活动详情";
        return (ResultData<InfoEventEntity>)(ControllerRepeateUtil.getResultData(msg,infoEventEntity));
    }
}
