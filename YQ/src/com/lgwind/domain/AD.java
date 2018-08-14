package com.lgwind.domain;

public class AD {
    
    private String username;
    private String adTime;
    private String jd;
    private String wd;
    private String jwName;
    private int scope;
    private String time;
    private String status;
    
    public AD() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AD(String username, String adTime, String jd, String wd,
            String jwName, int scope, String time, String status) {
        super();
        this.username = username;
        this.adTime = adTime;
        this.jd = jd;
        this.wd = wd;
        this.jwName = jwName;
        this.scope = scope;
        this.time = time;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdTime() {
        return adTime;
    }

    public void setAdTime(String adTime) {
        this.adTime = adTime;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "AD [username=" + username + ", adTime=" + adTime + ", jd=" + jd
                + ", wd=" + wd + ", jwName=" + jwName + ", scope=" + scope
                + ", time=" + time + ", status=" + status + "]";
    }
    
}
