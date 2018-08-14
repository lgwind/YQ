package com.lgwind.view;

public class SignUp {
    
    private String startTime="未获取信息";
    private String lastTime="未获取信息";
    private String jwName="未获取信息";
    private String status="未获取信息";
    private String jd="未获取信息";
    private String wd="未获取信息";
    private double scope=0;
    private String scope2;
    
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SignUp(String startTime, String lastTime, String jwName,
            String status, String jd, String wd, double scope, String scope2) {
        super();
        this.startTime = startTime;
        this.lastTime = lastTime;
        this.jwName = jwName;
        this.status = status;
        this.jd = jd;
        this.wd = wd;
        this.scope = scope;
        this.scope2 = scope2;
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

    public String getJwName() {
        return jwName;
    }

    public void setJwName(String jwName) {
        this.jwName = jwName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public double getScope() {
        return scope;
    }

    public void setScope(double scope) {
        this.scope = scope;
    }

    public String getScope2() {
        return scope2;
    }

    public void setScope2(String scope2) {
        this.scope2 = scope2;
    }

    @Override
    public String toString() {
        return "SignUp [startTime=" + startTime + ", lastTime=" + lastTime
                + ", jwName=" + jwName + ", status=" + status + ", jd=" + jd
                + ", wd=" + wd + ", scope=" + scope + ", scope2=" + scope2
                + "]";
    }
    
}
