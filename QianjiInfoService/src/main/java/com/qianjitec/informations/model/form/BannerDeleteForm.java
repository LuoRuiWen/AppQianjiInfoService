package com.qianjitec.informations.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * banner删除表单
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerDeleteForm {
    /**
     * 要删除的banner的id集合
     */
    List<String> ids;
}
