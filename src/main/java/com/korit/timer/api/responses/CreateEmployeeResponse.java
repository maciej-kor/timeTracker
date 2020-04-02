package com.korit.timer.api.responses;

public class CreateEmployeeResponse extends BasicResponse {
    private Long id;

    public CreateEmployeeResponse(String responseMsg, Long id) {
        super(responseMsg);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
