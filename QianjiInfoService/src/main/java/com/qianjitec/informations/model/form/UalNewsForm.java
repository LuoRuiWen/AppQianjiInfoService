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
public class UalNewsForm {
    /**
     * 资讯id
     */
    private String id;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 资讯是否有效
     */
    private Boolean isEffected;
}
