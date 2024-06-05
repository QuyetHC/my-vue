package com.ra.model.entity;

public class login {
    private String username;
    private String passwd;
    private String role;
    private String custid;


    public login(String username, String passwd, String role, String custid) {
        this.username = username;
        this.passwd = passwd;
        this.role = role;
        this.custid = custid;
    }

    public login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }
}
