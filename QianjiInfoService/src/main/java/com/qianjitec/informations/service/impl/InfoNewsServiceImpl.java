package com.qianjitec.informations.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianjitec.common.exception.ServiceException;
import com.qianjitec.common.utils.IdUtils;
import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.dao.InfoNewsEntityDao;
import com.qianjitec.informations.entity.InfoNewsEntity;
import com.qianjitec.informations.model.form.*;
import com.qianjitec.informations.service.InfoNewsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

@Service
public class InfoNewsServiceImpl implements InfoNewsService{
    Logger logger = LoggerFactory.getLogger(InfoNewsServiceImpl.class);
    @Autowired
    private InfoNewsEntityDao infoNewsEntityDao;

    /**
     * 前端获取独家信息列表
     * @param form
     * @return
     */
    @Override
    public ResultPage<List<InfoNewsEntity>> getInfoNews(InfoNewsForm form) {
        logger.info("获取独家信息");
        try {
            ResultPage<List<InfoNewsEntity>> resultPage = new ResultPage<>();
            Page page = form.page();
            page.setAsc("order_num","useful_time_e");
            System.out.println(form.getType()+"\t"+form.getType().getClass());
            List<InfoNewsEntity> news = infoNewsEntityDao.getInfoNewsBySort(form.getType(),form.page());
            resultPage.setList(news);
            resultPage.setTotal(page.getTotal());
            return resultPage;
        }catch(ServiceException e){
            logger.info("获取独家信息失败");
            throw e;
        }catch(Exception e){
            logger.info("获取独家信息失败");
            throw new ServiceException("获取独家信息失败",e);
        }
    }

    /**
     *  前端获取独家信息详情
     */
    @Override
    public InfoNewsEntity getNewsInfo(String id){
        logger.info("查看独家信息详情");
        try {
            InfoNewsEntity infoNewsEntity =infoNewsEntityDao.selectByPrimaryKey(id);
            return null;
        }catch(ServiceException e){
            logger.info("获取独家信息失败");
            throw e;
        }catch(Exception e){
            logger.info("获取独家信息失败");
            throw new ServiceException("获取独家信息失败",e);
        }
    }

    /**
     * 后台获取资讯列表
     * @param type,form
     * @return
     */
    @Override
    public ResultPage<List<InfoNewsEntity>> backstageNews(String type,InfoNewsForm form) {
        logger.info("获取资讯列表");
        try {
            ResultPage<List<InfoNewsEntity>> resultPage = new ResultPage<>();
            Page page = form.page();

            //获取资讯
            List<InfoNewsEntity> news = infoNewsEntityDao.backstageNews(type,form.page());

            //设置分页数据
            resultPage.setList(news);
            resultPage.setTotal(page.getTotal());
            return resultPage;
        }catch(ServiceException e){
            logger.info("获取资讯列表失败");
            throw e;
        }catch(Exception e){
            logger.info("获取资讯列表失败");
            throw new ServiceException("获取资讯列表失败",e);
        }
    }

    /**
     * 上下架资讯
     * @param id
     * @return
     */
    @Override
    public int ualInfoNews(String id,Boolean isEffect) {
        logger.info("上下架资讯");
        try {
            UalNewsForm ualNewsForm = new UalNewsForm();
            ualNewsForm.setId(id);
            ualNewsForm.setIsEffected(isEffect);
            if(isEffect==true){
                ualNewsForm.setReleaseTime(null);
            }else{
                ualNewsForm.setReleaseTime(new Date());
            }
            int count = infoNewsEntityDao.ualNews(ualNewsForm);
            return count;
        }catch(ServiceException e){
            logger.info("资讯操作失败");
            throw e;
        }catch (Exception e){
            logger.info("资讯操作失败！");
            throw new ServiceException("Error:资讯操作失败！",e);
        }
    }

    /**
     * 后端删除单条资讯
     * @param id
     * @return
     */
    @ApiOperation("删除一条资讯")
    @Override
    public int deleteOneNews(String id) {
        logger.info("删除一条资讯");
        try{
            NewsDeleteForm form = new NewsDeleteForm();
            List ids = new Vector();
            ids.add(id);
            form.setIds(ids);
            int count = infoNewsEntityDao.deleteOneOrMore(form);
            return count;
        }catch (ServiceException e){
            logger.info("删除资讯失败！");
            throw e;
        }catch (Exception e){
            logger.info("删除资讯失败！");
            throw new ServiceException("Error:删除资讯失败",e);
        }
    }

    /**
     * 新增一条资讯
     * @param form
     * @return
     */
    @ApiOperation("新增单条资讯")
    @Override
    public int addOneNews(AddNewsForm form) {
        try {
            logger.info("新增资讯");

            InfoNewsEntity infoNewsEntity = new InfoNewsEntity();
            BeanUtils.copyProperties(form,infoNewsEntity);
            //生成id
            String id = IdUtils.nextId();
            //生成日期
            Date newDate = new Date();
            infoNewsEntity.setId(id);
            infoNewsEntity.setCreateTime(newDate);
            infoNewsEntity.setUpdateTime(newDate);
            int count = infoNewsEntityDao.addOneNews(infoNewsEntity);
            return count;
        }catch (ServiceException e){
            logger.info("新增资讯失败！");
            throw e;
        }catch (Exception e){
            logger.info("删除资讯失败！");
            throw new ServiceException("Error:新增资讯失败",e);
        }
    }

    @Override
    public int alterOneNews(AlterNewsForm form) {
        return 0;
    }
}
