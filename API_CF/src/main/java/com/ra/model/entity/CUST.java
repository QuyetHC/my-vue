package com.ra.model.entity;

public class CUST {
    private String custid;
    private String custodycd;
    private String fullName;
    private String addr;
    private String idCode;
    private String custtype;
    private String Score ;

    public CUST(String custid, String custodycd, String fullName, String addr, String idCode, String custtype, String score) {
        this.custid = custid;
        this.custodycd = custodycd;
        this.fullName = fullName;
        this.addr = addr;
        this.idCode = idCode;
        this.custtype = custtype;
        this.Score = score;
    }

    public CUST() {
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustodycd() {
        return custodycd;
    }

    public void setCustodycd(String custodycd) {
        this.custodycd = custodycd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }
}
