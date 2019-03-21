package com.qianjitec.informations.model.form;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianjitec.common.form.PageForm;
import lombok.*;


/**
 * 资讯查询表单
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoNewsForm extends PageForm{
    @NonNull
    private String type;
}
