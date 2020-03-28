package com.korit.timer.service;

import com.korit.timer.api.responses.message.MsgSource;

public abstract class AbstractCommonService {

    public MsgSource msgSource;

    public AbstractCommonService(MsgSource msgSource){
        this.msgSource = msgSource;
    }

}
