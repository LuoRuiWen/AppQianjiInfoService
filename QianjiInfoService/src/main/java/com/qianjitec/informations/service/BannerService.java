package com.qianjitec.informations.service;

import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.entity.BannerEntity;
import com.qianjitec.informations.model.form.BannerQueryForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {
    String ImgPath(MultipartFile file);

    /**
     * 前端获取banner列表
     * @param bannerQueryForm
     * @return
     */
    ResultPage getBanners(BannerQueryForm bannerQueryForm);

    /**
     * 前端获取banner详情
     * @param id
     * @return
     */
    BannerEntity getBanner(String id);
}
