package com.movie.response;

public class UserResponse {

    private String userId;
    private String userName;

    private String userMobileNumber;

    private String emailId;

    private String password;

    public UserResponse(String userId, String userName, String userMobileNumber, String emailId, String password) {
        this.userId = userId;
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
        this.emailId = emailId;
        this.password = password;
    }

    public UserResponse() {
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNumber() {
        return this.userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "UserResponse(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", userMobileNumber=" + this.getUserMobileNumber() + ", emailId=" + this.getEmailId() + ", password=" + this.getPassword() + ")";
    }
}
