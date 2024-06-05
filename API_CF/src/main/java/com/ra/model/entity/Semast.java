package com.ra.model.entity;

public class Semast {
    private String LOAN;
    private String MORTDUE;
    private String VALUE;
    private String REASON;
    private String JOB;
    private String YOJ;
    private String DEROG;
    private String DELINQ;
    private String CLAGE;
    private String NINQ;
    private String CLNO;
    private String DEBTINC;
    private String CUSTID;

    public Semast(String LOAN, String MORTDUE, String VALUE, String REASON, String JOB, String YOJ, String DEROG, String DELINQ, String CLAGE, String NINQ, String CLNO, String DEBTINC, String CUSTID) {
        this.LOAN = LOAN;
        this.MORTDUE = MORTDUE;
        this.VALUE = VALUE;
        this.REASON = REASON;
        this.JOB = JOB;
        this.YOJ = YOJ;
        this.DEROG = DEROG;
        this.DELINQ = DELINQ;
        this.CLAGE = CLAGE;
        this.NINQ = NINQ;
        this.CLNO = CLNO;
        this.DEBTINC = DEBTINC;
        this.CUSTID = CUSTID;
    }

    public Semast() {
    }

    public String getLOAN() {
        return LOAN;
    }

    public void setLOAN(String LOAN) {
        this.LOAN = LOAN;
    }

    public String getMORTDUE() {
        return MORTDUE;
    }

    public void setMORTDUE(String MORTDUE) {
        this.MORTDUE = MORTDUE;
    }

    public String getVALUE() {
        return VALUE;
    }

    public void setVALUE(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getREASON() {
        return REASON;
    }

    public void setREASON(String REASON) {
        this.REASON = REASON;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public String getYOJ() {
        return YOJ;
    }

    public void setYOJ(String YOJ) {
        this.YOJ = YOJ;
    }

    public String getDEROG() {
        return DEROG;
    }

    public void setDEROG(String DEROG) {
        this.DEROG = DEROG;
    }

    public String getDELINQ() {
        return DELINQ;
    }

    public void setDELINQ(String DELINQ) {
        this.DELINQ = DELINQ;
    }

    public String getCLAGE() {
        return CLAGE;
    }

    public void setCLAGE(String CLAGE) {
        this.CLAGE = CLAGE;
    }

    public String getNINQ() {
        return NINQ;
    }

    public void setNINQ(String NINQ) {
        this.NINQ = NINQ;
    }

    public String getCLNO() {
        return CLNO;
    }

    public void setCLNO(String CLNO) {
        this.CLNO = CLNO;
    }

    public String getDEBTINC() {
        return DEBTINC;
    }

    public void setDEBTINC(String DEBTINC) {
        this.DEBTINC = DEBTINC;
    }

    public String getCUSTID() {
        return CUSTID;
    }

    public void setCUSTID(String CUSTID) {
        this.CUSTID = CUSTID;
    }
}
