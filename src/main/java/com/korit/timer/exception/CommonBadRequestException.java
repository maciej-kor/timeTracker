package com.korit.timer.exception;

import com.korit.timer.api.responses.message.ConstErrorMsg;

public class CommonBadRequestException extends CommonException {

    public CommonBadRequestException(ConstErrorMsg constErrorMsg) {
        super(constErrorMsg);
    }
}

