package com.qianjitec.informations.entity;

import com.mysql.jdbc.Blob;
import lombok.Data;

import java.util.Date;

@Data
public class InfoNewsEntity {
    private String id;

    private String newsTitle;

    private String pictureCoverPath;

    private String author;

    private Date usefulTimeB;

    private Date usefulTimeE;

    private Integer orderNum;

    private Boolean isEffected;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    private String content;

    private String urlLinks;

    private String type;
}