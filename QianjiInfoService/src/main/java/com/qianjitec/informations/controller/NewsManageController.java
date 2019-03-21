package com.qianjitec.informations.controller;

import com.qianjitec.common.annotation.RequiresGuest;
import com.qianjitec.common.utils.ResultData;
import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.entity.InfoNewsEntity;
import com.qianjitec.informations.model.form.AddNewsForm;
import com.qianjitec.informations.model.form.InfoNewsForm;
import com.qianjitec.informations.model.form.UalNewsForm;
import com.qianjitec.informations.service.InfoNewsService;
import com.qianjitec.informations.utils.ControllerRepeateUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiresGuest
@RequestMapping("/api/informations")
public class NewsManageController {
    Logger logger = LoggerFactory.getLogger(NewsManageController.class);

    @Autowired
    private InfoNewsService infoNewsService;

    @ApiOperation("查看活动信息详情")
    @RequestMapping("/getNewsInfo/{id}")
    public ResultData<InfoNewsEntity> getNewsInfo(@PathVariable String id){
        logger.info("查看独家信息详情");
        InfoNewsEntity infoNewsEntity = infoNewsService.getNewsInfo(id);
        String msg = "独家信息";
        return (ResultData<InfoNewsEntity>)(ControllerRepeateUtil.getResultData(msg,infoNewsEntity));
    }

    /**
     *
     * @param form
     * @return
     */
    @ApiOperation("查看独家信息信息详情")
    @RequestMapping("/getBackstageNews")
    public ResultData<List<InfoNewsEntity>> getBackstageNews(InfoNewsForm form){
        logger.info("查看独家信息详情");

        String type = "1";
        ResultPage backstageNewses = infoNewsService.backstageNews(type,form);
        String msg = "独家信息";

        return (ResultData<List<InfoNewsEntity>>)(ControllerRepeateUtil.getResultData(msg,backstageNewses));
    }

    @ApiOperation("后台查看所有广告")
    @GetMapping("/getBackstageAdv")
    public ResultData<List<InfoNewsEntity>> backstageNews(InfoNewsForm form){
        String type = "2";
        ResultPage backstageNews = infoNewsService.backstageNews(type,form);
        String msg = "查看广告列表";
        return (ResultData<List<InfoNewsEntity>>)(ControllerRepeateUtil.getResultData(msg,backstageNews));
    }

    @ApiOperation("后台下架资讯")
    @PutMapping("/lowwerOneNews/{id}")
    public ResultData ualInfoNews(@PathVariable String id){
        logger.info("下架资讯！");
        int count = infoNewsService.ualInfoNews(id,true);
        String msg = "下架资讯";
        return ControllerRepeateUtil.getResultData(msg,count);
    }

    @ApiOperation("上架一条资讯")
    @PutMapping("/upperOneNews/{id}")
    public ResultData lowwerOneNews(@PathVariable String id){
        logger.info("上架资讯！");
        int count = infoNewsService.ualInfoNews(id,false);
        String msg = "上架资讯";
        return ControllerRepeateUtil.getResultData(msg,count);
    }

    @ApiOperation("后台删除一条资讯")
    @DeleteMapping("/deleteOneNews/{id}")
    public ResultData deleteOneNews(@PathVariable String id){
        logger.info("删除一条资讯");
        int count = infoNewsService.deleteOneNews(id);
        String msg = "删除一条资讯";
        return ControllerRepeateUtil.getResultData(msg,count);
    }

    @ApiOperation("后台新增一条资讯")
    @PostMapping("/addOneNews")
    public ResultData addOneNews(@RequestBody AddNewsForm addNewsEntity){
        logger.info("新增一条资讯");
        String msg = "新增资讯";
        int count = infoNewsService.addOneNews(addNewsEntity);
        return ControllerRepeateUtil.getResultData(msg,count);
    }


    /**
     * 前端格式["","",""]
     */
    /*@PutMapping("/releaseOneNews")
    public void releaseOneNews(@RequestBody ArrayList<String> ids){
        System.out.println(ids);
    }*/

    /**
     *   前端格式{"":"","":"","":""}
     */
    /*@PutMapping("/batchReleaseNews")
    public void batchUpdateNews(@RequestBody Map<String,String> upda){
        System.out.println(upda);
        for (Map.Entry e:upda.entrySet()) {
            System.out.println(e.getKey()+"\t"+e.getValue());
        }
    }*/
}
