package com.ra.model.entity;

public class balance {
    private String custid,acct,value,CLNO,DEBTNIC,Delinq;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCLNO() {
        return CLNO;
    }

    public void setCLNO(String CLNO) {
        this.CLNO = CLNO;
    }

    public String getDEBTNIC() {
        return DEBTNIC;
    }

    public void setDEBTNIC(String DEBTNIC) {
        this.DEBTNIC = DEBTNIC;
    }

    public String getDelinq() {
        return Delinq;
    }

    public void setDelinq(String delinq) {
        Delinq = delinq;
    }

    public balance(String custid, String acct, String value, String CLNO, String DEBTNIC, String delinq) {
        this.custid = custid;
        this.acct = acct;
        this.value = value;
        this.CLNO = CLNO;
        this.DEBTNIC = DEBTNIC;
        Delinq = delinq;
    }

    public balance() {
    }
}
