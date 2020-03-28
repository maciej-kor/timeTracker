package com.korit.timer.exception;

import com.korit.timer.api.responses.message.ConstErrorMsg;

public class CommonConflictException extends CommonException{

    public CommonConflictException(ConstErrorMsg constErrorMsg) {
        super(constErrorMsg);
    }

}
