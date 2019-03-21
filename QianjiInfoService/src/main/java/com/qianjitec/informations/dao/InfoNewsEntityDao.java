package com.qianjitec.informations.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianjitec.informations.entity.InfoNewsEntity;
import com.qianjitec.informations.model.form.AlterNewsForm;
import com.qianjitec.informations.model.form.NewsDeleteForm;
import com.qianjitec.informations.model.form.NewsReleaseForm;
import com.qianjitec.informations.model.form.UalNewsForm;
import feign.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface InfoNewsEntityDao {
    int insert(InfoNewsEntity record);

    int insertSelective(InfoNewsEntity record);


    InfoNewsEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InfoNewsEntity record);

    int updateByPrimaryKeyWithBLOBs(InfoNewsEntity record);

    int updateByPrimaryKey(InfoNewsEntity record);

    /**
     * 前端查询资讯列表
     * @param type,page
     * @return
     */
    List<InfoNewsEntity> getInfoNewsBySort(String type,Page page);

    /**
     * 后台查看所有资讯
     * @param type,page
     * @return
     */
    List<InfoNewsEntity> backstageNews(String type,Page page);


    /**
     * 上下架资讯
     * @param ualNewsForm
     * @return
     */
    int ualNews(UalNewsForm ualNewsForm);

    /**
     * 修改一条或多条资讯
     * @param ids
     * @return
     */
    //int alterNews(Map<String,String> ids);

    /**
     * s删除一条或多条资讯
     * @param newsDeleteForm
     * @return
     */
    int deleteOneOrMore(NewsDeleteForm newsDeleteForm);

    /**
     * 新增单条资讯
     * @param infoNewsEntity
     * @return
     */
    int addOneNews(InfoNewsEntity infoNewsEntity);
    //int releaseOneOrMore(NewsReleaseForm newsReleaseForm);

    /**
     * 修改一条资讯信息
     */
    int alterOneNews(AlterNewsForm form);
}