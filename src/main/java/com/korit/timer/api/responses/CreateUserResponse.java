package com.korit.timer.api.responses;

public class CreateUserResponse extends BasicResponse {

    private Long userId;

    public CreateUserResponse(){}

    public CreateUserResponse(String responseMsg, Long userId) {
        super(responseMsg);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
