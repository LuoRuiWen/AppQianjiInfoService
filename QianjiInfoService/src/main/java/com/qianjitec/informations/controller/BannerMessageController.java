package com.qianjitec.informations.controller;

import com.qianjitec.common.annotation.RequiresGuest;
import com.qianjitec.common.security.ErrorCode;
import com.qianjitec.common.utils.ResultData;
import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.entity.BannerEntity;
import com.qianjitec.informations.model.form.BannerQueryForm;
import com.qianjitec.informations.service.BannerService;
import com.qianjitec.informations.utils.ControllerRepeateUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * banner接口
 *
 * @Auther:lrw
 */
@RestController
@RequiresGuest
@RequestMapping("/api/informations")
public class BannerMessageController {
    Logger logger = LoggerFactory.getLogger(BannerMessageController.class);

    @Autowired
    private BannerService bannerService;


    @ApiOperation(value = "获取banner信息")
    @GetMapping("/getBanners")
    public ResultData<List<BannerEntity>> getBannerInfo(BannerQueryForm form){
        logger.info("获取banner");
        String msg = "横幅";
        ResultPage banners=bannerService.getBanners(form);
        return (ResultData<List<BannerEntity>>)(ControllerRepeateUtil.getResultData(msg,banners));
    }

    @PostMapping("/uploadImg")
    public String uploadImg(@RequestParam("file") MultipartFile file){
        bannerService.ImgPath(file);
        return "SCCESS";
    }
}
