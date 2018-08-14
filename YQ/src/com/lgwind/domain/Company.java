package com.lgwind.domain;

public class Company {
    
    private String companyName;
    private String startTime="00:00:00";
    private String lastTime="00:00:00";
    private String addTime;
    private int scope=0; 
    private String jd;
    private String wd;
    private String jwName;
    private String jd2;
    private String wd2;
    private String jwName2;
    private String jd3;
    private String wd3;
    private String jwName3;
    
    
    public Company() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Company(String companyName, String startTime, String lastTime,
            String addTime, int scope, String jd, String wd, String jwName,
            String jd2, String wd2, String jwName2, String jd3, String wd3,
            String jwName3) {
        super();
        this.companyName = companyName;
        this.startTime = startTime;
        this.lastTime = lastTime;
        this.addTime = addTime;
        this.scope = scope;
        this.jd = jd;
        this.wd = wd;
        this.jwName = jwName;
        this.jd2 = jd2;
        this.wd2 = wd2;
        this.jwName2 = jwName2;
        this.jd3 = jd3;
        this.wd3 = wd3;
        this.jwName3 = jwName3;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getJwName() {
        return jwName;
    }

    public void setJwName(String jwName) {
        this.jwName = jwName;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public String getJd2() {
        return jd2;
    }

    public void setJd2(String jd2) {
        this.jd2 = jd2;
    }

    public String getWd2() {
        return wd2;
    }

    public void setWd2(String wd2) {
        this.wd2 = wd2;
    }

    public String getJwName2() {
        return jwName2;
    }

    public void setJwName2(String jwName2) {
        this.jwName2 = jwName2;
    }

    public String getJd3() {
        return jd3;
    }

    public void setJd3(String jd3) {
        this.jd3 = jd3;
    }

    public String getWd3() {
        return wd3;
    }

    public void setWd3(String wd3) {
        this.wd3 = wd3;
    }

    public String getJwName3() {
        return jwName3;
    }

    public void setJwName3(String jwName3) {
        this.jwName3 = jwName3;
    }

    @Override
    public String toString() {
        return "Company [companyName=" + companyName + ", startTime="
                + startTime + ", lastTime=" + lastTime + ", addTime=" + addTime
                + ", scope=" + scope + ", jd=" + jd + ", wd=" + wd
                + ", jwName=" + jwName + ", jd2=" + jd2 + ", wd2=" + wd2
                + ", jwName2=" + jwName2 + ", jd3=" + jd3 + ", wd3=" + wd3
                + ", jwName3=" + jwName3 + "]";
    }

}
