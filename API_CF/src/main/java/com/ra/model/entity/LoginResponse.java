package com.ra.model.entity;

import java.util.List;

public class LoginResponse
{
    private String status;
    private String message;
    private List<login> loginList;

    public LoginResponse(String status, String message, List<login> loginList) {
        this.status = status;
        this.message = message;
        this.loginList = loginList;
    }

    public LoginResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<login> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<login> loginList) {
        this.loginList = loginList;
    }
}
