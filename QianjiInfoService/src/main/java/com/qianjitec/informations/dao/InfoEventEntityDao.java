package com.qianjitec.informations.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianjitec.informations.entity.InfoEventEntity;

import java.util.List;

public interface InfoEventEntityDao {
    int deleteByPrimaryKey(String id);

    int insert(InfoEventEntity record);

    int insertSelective(InfoEventEntity record);

    InfoEventEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InfoEventEntity record);

    int updateByPrimaryKeyWithBLOBs(InfoEventEntity record);

    int updateByPrimaryKey(InfoEventEntity record);
    
    public List<InfoEventEntity> queryEventBySort(Page page);
}