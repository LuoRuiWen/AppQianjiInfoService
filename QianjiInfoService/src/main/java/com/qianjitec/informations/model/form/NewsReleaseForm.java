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
public class NewsReleaseForm {

    /**
     * 要发布的资讯id集合
     */
    private List<String> ids;
}
