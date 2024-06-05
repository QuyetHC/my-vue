package com.ra.model.entity;

public class reportcredit {
    private String id,name,creditScore ;

    public reportcredit(String id, String name, String creditScore) {
        this.id = id;
        this.name = name;
        this.creditScore = creditScore;
    }

    public reportcredit() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }
}
