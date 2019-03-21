package com.qianjitec.informations.model.form;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.Date;


/**
 *
 * "新增资讯表单"
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddNewsForm {
    private String newsTitle;

    private String pictureCoverPath;

    private String author;

    private Date usefulTimeB;

    private Date usefulTimeE;

    private Integer orderNum;

    private String content;

    private String urlLinks;

    private String type;
}
