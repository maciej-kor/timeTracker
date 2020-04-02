package com.korit.timer.api.responses;

public class UpdateEmployeeResponse extends BasicResponse {

    private boolean updateName;
    private boolean updateSurname;
    private boolean updatePhoneNumber;

    public UpdateEmployeeResponse(String responseMsg) {
        super(responseMsg);
    }

    public boolean isUpdateName() {
        return updateName;
    }

    public void setUpdateName(boolean updateName) {
        this.updateName = updateName;
    }

    public boolean isUpdateSurname() {
        return updateSurname;
    }

    public void setUpdateSurname(boolean updateSurname) {
        this.updateSurname = updateSurname;
    }

    public boolean isUpdatePhoneNumber() {
        return updatePhoneNumber;
    }

    public void setUpdatePhoneNumber(boolean updatePhoneNumber) {
        this.updatePhoneNumber = updatePhoneNumber;
    }
}
