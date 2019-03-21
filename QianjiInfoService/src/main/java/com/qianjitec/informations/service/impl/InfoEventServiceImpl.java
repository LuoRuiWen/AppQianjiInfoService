package com.qianjitec.informations.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianjitec.common.exception.ServiceException;
import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.dao.InfoEventEntityDao;
import com.qianjitec.informations.entity.InfoEventEntity;
import com.qianjitec.informations.model.form.InfoEventForm;
import com.qianjitec.informations.service.InfoEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoEventServiceImpl implements InfoEventService {
    Logger logger = LoggerFactory.getLogger(InfoEventServiceImpl.class);
    @Autowired
    private InfoEventEntityDao infoEventEntityDao;


    /**
     * 前端获取活动列表
     * @param form
     * @return
     */
    @Override
    public ResultPage getInfoEvents(InfoEventForm form) {
        try {
            logger.info("获取活动信息");
            ResultPage resultPage = new ResultPage();
            Page page = form.page();
            page.setAsc("order_num","useful_time_e");
            List<InfoEventEntity> events = infoEventEntityDao.queryEventBySort(page);
            resultPage.setList(events);
            resultPage.setTotal(page.getTotal());
            return resultPage;
        }catch (ServiceException e){
            logger.info("获取活动信息失败！");
            throw e;
        }catch(Exception e){
            logger.info("获取活动信息失败！");
            throw new ServiceException("获取活动信息失败！",e);
        }
    }


    /**
     * 前端获取活动详情
     * @param id
     * @return
     */
    @Override
    public InfoEventEntity getEventInfo(String id) {
        try {
            logger.info("获取活动详情");
            InfoEventEntity event = infoEventEntityDao.selectByPrimaryKey(id);
            return event;
        }catch (ServiceException e){
            logger.info("获取活动详情！");
            throw e;
        }catch(Exception e){
            logger.info("获取活动详情！");
            throw new ServiceException("获取活动详情！",e);
        }
    }
}
