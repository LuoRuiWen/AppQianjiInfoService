package com.qianjitec.informations.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianjitec.common.exception.ServiceException;
import com.qianjitec.common.security.ErrorCode;
import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.dao.BannerEntityDao;
import com.qianjitec.informations.entity.BannerEntity;
import com.qianjitec.informations.model.form.BannerQueryForm;
import com.qianjitec.informations.service.BannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    private Logger logger = LoggerFactory.getLogger(BannerServiceImpl.class);

    @Autowired
    private BannerEntityDao bannerDao;

    /**
     * 获取banner
     * @param bannerQueryForm
     * @return
     */
    @Override
    public ResultPage getBanners(BannerQueryForm bannerQueryForm) {
        try {
            ResultPage resultPage =new ResultPage();
            Page page = bannerQueryForm.page();
            page.setCurrent(1);
            page.setSize(6L);
            //设置排序字段
            page.setAsc("order_num","useful_time_e");

            //获取非默认banner
            List<BannerEntity> banners = bannerDao.selectBannerByType(bannerQueryForm.getType(),page);
            List<BannerEntity> dBanners = null;

            //判断非默认banner长度是否不足6个
            if(banners.size()<6){
                dBanners = bannerDao.selectDefaultByType(bannerQueryForm.getType());
                if(dBanners!=null) {
                    //如果默认banner足够长
                    if(dBanners.size()>6-banners.size()) {
                        for (int i = 0; i < 6 - banners.size(); i++) {
                            banners.add(dBanners.get(i));
                        }
                    }else{
                        //默认banner无法补全
                        for (int i = 0; i < dBanners.size(); i++) {
                            banners.add(dBanners.get(i));
                        }
                    }
                }
            }
            resultPage.setList(banners);
            resultPage.setTotal(page.getTotal());
            return resultPage;
        }catch (ServiceException e){
            logger.info("获取首页失败",e);
            throw e;
        }catch (Exception e){
            logger.info("获取首页失败",e);
            throw new ServiceException("获取首页失败", ErrorCode.SERVICE_ERROR,e);
        }
    }

    /**
     * 获取banner详情
     * @param id
     * @return
     */
    @Override
    public BannerEntity getBanner(String id){
        try {
            logger.info("获取横幅详情");
            BannerEntity bannerEntity = bannerDao.selectByPrimaryKey(id);
            return bannerEntity;
        }catch (ServiceException e){
            logger.info("获横幅详情失败",e);
            throw e;
        }catch (Exception e){
            logger.info("获横幅详情失败",e);
            throw new ServiceException("获横幅详情失败", ErrorCode.SERVICE_ERROR,e);
        }
    }

    @Override
    public String ImgPath(MultipartFile file) {
        try {
            String pathname= file.getName();
            File f = new File("classpath:/resource/imgs"+pathname);
            if (!f.exists()){
                f.mkdirs();
            }
            file.transferTo(f);
            FileInputStream fis = new FileInputStream(f);
            return f.getPath();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
