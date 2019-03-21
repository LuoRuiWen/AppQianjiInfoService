package com.qianjitec.informations.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlterNewsForm {
    private String newsTitle;

    private String pictureCoverPath;

    private String author;

    private Date usefulTimeB;

    private Date usefulTimeE;

    private Integer orderNum;

    private Boolean isEffected;

    private String content;

    private String urlLink;

    private String type;
}
