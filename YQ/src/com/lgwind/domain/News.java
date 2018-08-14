package com.lgwind.domain;

public class News {
    
    private int id;//消息id, 自增
    private String itype;//消息类型
    private String company; 
    private String username;
    private String reason;
    private String time;
    private int finish;
    
    public News() {
        super();
        // TODO Auto-generated constructor stub
    }

    public News(int id, String itype, String company, String username,
            String reason, String time, int finish) {
        super();
        this.id = id;
        this.itype = itype;
        this.company = company;
        this.username = username;
        this.reason = reason;
        this.time = time;
        this.finish = finish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItype() {
        return itype;
    }

    public void setItype(String itype) {
        this.itype = itype;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "News [id=" + id + ", itype=" + itype + ", company=" + company
                + ", username=" + username + ", reason=" + reason + ", time="
                + time + ", finish=" + finish + "]";
    }
    
}
