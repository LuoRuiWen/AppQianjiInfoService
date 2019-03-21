package com.qianjitec.informations.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianjitec.informations.entity.BannerEntity;
import com.qianjitec.informations.model.form.BannerQueryForm;

import java.util.List;

public interface BannerEntityDao {
    int deleteByPrimaryKey(String id);

    int insert(BannerEntity record);

    int insertSelective(BannerEntity record);

    BannerEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BannerEntity record);

    int updateByPrimaryKey(BannerEntity record);

    //根据类型查询非默认Banner
    List<BannerEntity> selectBannerByType(String type,Page page);

    //根据类型查询默认Banner
    List<BannerEntity> selectDefaultByType(String type);
}