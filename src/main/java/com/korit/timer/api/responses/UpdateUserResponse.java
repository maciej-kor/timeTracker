package com.korit.timer.api.responses;

public class UpdateUserResponse extends BasicResponse {

    private boolean updateNickname;
    private boolean updatePassword;
    private boolean updateName;
    private boolean updateMailAddress;
    private boolean updateSurname;

    public UpdateUserResponse(String responseMsg) {
        super(responseMsg);
    }

    public boolean isUpdateNickname() {
        return updateNickname;
    }

    public void setUpdateNickname(boolean updateNickname) {
        this.updateNickname = updateNickname;
    }

    public boolean isUpdatePassword() {
        return updatePassword;
    }

    public void setUpdatePassword(boolean updatePassword) {
        this.updatePassword = updatePassword;
    }

    public boolean isUpdateName() {
        return updateName;
    }

    public void setUpdateName(boolean updateName) {
        this.updateName = updateName;
    }

    public boolean isUpdateMailAddress() {
        return updateMailAddress;
    }

    public void setUpdateMailAddress(boolean updateMailAddress) {
        this.updateMailAddress = updateMailAddress;
    }

    public boolean isUpdateSurname() {
        return updateSurname;
    }

    public void setUpdateSurname(boolean updateSurname) {
        this.updateSurname = updateSurname;
    }
}
