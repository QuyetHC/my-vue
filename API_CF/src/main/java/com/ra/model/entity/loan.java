package com.ra.model.entity;

public class loan {
    private String custid,acct,loan,value,bad,job;

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    public String getLoan() {
        return loan;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBad() {
        return bad;
    }

    public void setBad(String bad) {
        this.bad = bad;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public loan(String custid, String acct, String loan, String value, String bad, String job) {
        this.custid = custid;
        this.acct = acct;
        this.loan = loan;
        this.value = value;
        this.bad = bad;
        this.job = job;
    }

    public loan() {
    }
}
