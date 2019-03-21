package com.qianjitec.informations.service;

import com.qianjitec.common.utils.ResultPage;
import com.qianjitec.informations.entity.InfoEventEntity;
import com.qianjitec.informations.model.form.InfoEventForm;

import java.util.List;

public interface InfoEventService {
    ResultPage getInfoEvents(InfoEventForm form);

    InfoEventEntity getEventInfo(String id);
}
