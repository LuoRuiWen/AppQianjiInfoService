package com.qianjitec.informations.model.form;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianjitec.common.form.PageForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerQueryForm extends PageForm {
    private String type;

   /* @Override
    public Page page(){
        Page page = super.page();
        page.setAsc("order_num","useful_time_e");
        return page;
    }*/
}
