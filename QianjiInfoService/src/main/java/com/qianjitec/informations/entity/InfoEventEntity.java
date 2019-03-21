package com.qianjitec.informations.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.Date;

@Data
public class InfoEventEntity {
    private String id;

    private String eventTitle;

    private String pictureCoverPath;

    private String author;

    private Date usefulTimeB;

    private Date usefulTimeE;

    private Date effectTimeB;

    private Date effectTimeE;

    private Integer orderNum;

    private Boolean isEffected;

    private String signUpConditions;

    private String replenishConditions;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    private String content;

    private Date releaseTime;
}