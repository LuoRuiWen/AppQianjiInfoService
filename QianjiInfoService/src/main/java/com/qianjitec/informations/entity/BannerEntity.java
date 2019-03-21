package com.qianjitec.informations.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BannerEntity {
    private String id;

    private String title;

    private String picturePath;

    private String type;

    private Date userfulTimeB;

    private Date userfulTimeE;

    private String isDefault;

    private Integer orderNum;

    private String hyperlink;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;
}