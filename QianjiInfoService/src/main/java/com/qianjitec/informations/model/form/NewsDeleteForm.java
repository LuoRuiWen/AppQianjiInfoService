package com.qianjitec.informations.model.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsDeleteForm {
    /**
     * 要删除的资讯的id集合
     */
    List<String> ids;
    public List<String> getIds(){
        return this.ids;
    }
}
