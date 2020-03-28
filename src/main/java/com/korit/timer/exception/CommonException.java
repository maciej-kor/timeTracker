package com.korit.timer.exception;

import com.korit.timer.api.responses.message.ConstErrorMsg;

public class CommonException extends RuntimeException{

    private ConstErrorMsg constErrorMsg;

    public CommonException(ConstErrorMsg constErrorMsg){
        this.constErrorMsg = constErrorMsg;
    }

    public ConstErrorMsg getConstErrorMsg() {
        return constErrorMsg;
    }
}
