package com.korit.timer.exception;


import com.korit.timer.api.responses.BasicResponse;
import com.korit.timer.exception.CommonBadRequestException;
import com.korit.timer.exception.CommonConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    BasicResponse handleBadRequestException(CommonBadRequestException exception) {
        return BasicResponse.ofError(exception.getConstErrorMsg().getErrorCode(), exception.getConstErrorMsg().getErrorMsg());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    BasicResponse handleBadRequestException(CommonConflictException exception){
        return BasicResponse.ofError(exception.getConstErrorMsg().getErrorCode(), exception.getConstErrorMsg().getErrorMsg());
    }


}
