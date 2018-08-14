package com.lgwind.view;

public class ADone {
    
    private String username;
    private String name;
    private String amStatus;
    private String amTime;
    private String pmStatus;
    private String pmTime;
    
    public ADone() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ADone(String username, String name, String amStatus, String amTime,
            String pmStatus, String pmTime) {
        super();
        this.username = username;
        this.name = name;
        this.amStatus = amStatus;
        this.amTime = amTime;
        this.pmStatus = pmStatus;
        this.pmTime = pmTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmStatus() {
        return amStatus;
    }

    public void setAmStatus(String amStatus) {
        this.amStatus = amStatus;
    }

    public String getAmTime() {
        return amTime;
    }

    public void setAmTime(String amTime) {
        this.amTime = amTime;
    }

    public String getPmStatus() {
        return pmStatus;
    }

    public void setPmStatus(String pmStatus) {
        this.pmStatus = pmStatus;
    }

    public String getPmTime() {
        return pmTime;
    }

    public void setPmTime(String pmTime) {
        this.pmTime = pmTime;
    }

    @Override
    public String toString() {
        return "ADone [username=" + username + ", name=" + name + ", amStatus="
                + amStatus + ", amTime=" + amTime + ", pmStatus=" + pmStatus
                + ", pmTime=" + pmTime + "]";
    }

}
