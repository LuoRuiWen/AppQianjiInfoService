package com.qianjitec.informations.service;

import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.entity.InfoNewsEntity;
import com.qianjitec.informations.model.form.AddNewsForm;
import com.qianjitec.informations.model.form.AlterNewsForm;
import com.qianjitec.informations.model.form.InfoNewsForm;
import com.qianjitec.informations.model.form.UalNewsForm;

import java.util.List;

public interface InfoNewsService {

    /**
     * 前端获取资讯列表
     * @param form,type
     * @return
     */
    ResultPage<List<InfoNewsEntity>> getInfoNews(InfoNewsForm form);

    /**
     * 前端获取资讯详情
     * @param id
     * @return
     */
    InfoNewsEntity getNewsInfo(String id);

    /**
     * 后他分页显示资讯信息
     * @param type,form
     * @return
     */
    ResultPage<List<InfoNewsEntity>> backstageNews(String type,InfoNewsForm form);

    /**
     * 上下架一条资讯
     * @param id
     * @return
     */
    int ualInfoNews(String id,Boolean isEffect);

    /**
     * 删除一条资讯
     * @param id
     * @return
     */
    int deleteOneNews(String id);

    /**
     * 上下架多条讯息
     */
    //int ualInfoNews(List<String> ids);

    /**
     * 新增一条资讯
     * @param form
     * @return
     */
    int addOneNews(AddNewsForm form);


    /**
     * 修改一条资讯信息
     * @param form
     * @return
     */
    int alterOneNews(AlterNewsForm form);
}
