package com.lgwind.view;

public class Record {
    
    private String amTime="未获取信息";
    private String amJWName="未获取信息";
    private String amStatus="缺勤";
    private String pmTime="未获取信息";
    private String pmJWName="未获取信息";
    private String pmStatus="缺勤";
    
    public Record() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Record(String amTime, String amJWName, String amStatus,
            String pmTime, String pmJWName, String pmStatus) {
        super();
        this.amTime = amTime;
        this.amJWName = amJWName;
        this.amStatus = amStatus;
        this.pmTime = pmTime;
        this.pmJWName = pmJWName;
        this.pmStatus = pmStatus;
    }

    public String getAmTime() {
        return amTime;
    }

    public void setAmTime(String amTime) {
        this.amTime = amTime;
    }

    public String getAmJWName() {
        return amJWName;
    }

    public void setAmJWName(String amJWName) {
        this.amJWName = amJWName;
    }

    public String getAmStatus() {
        return amStatus;
    }

    public void setAmStatus(String amStatus) {
        this.amStatus = amStatus;
    }

    public String getPmTime() {
        return pmTime;
    }

    public void setPmTime(String pmTime) {
        this.pmTime = pmTime;
    }

    public String getPmJWName() {
        return pmJWName;
    }

    public void setPmJWName(String pmJWName) {
        this.pmJWName = pmJWName;
    }

    public String getPmStatus() {
        return pmStatus;
    }

    public void setPmStatus(String pmStatus) {
        this.pmStatus = pmStatus;
    }

    @Override
    public String toString() {
        return "Record [amTime=" + amTime + ", amJWName=" + amJWName
                + ", amStatus=" + amStatus + ", pmTime=" + pmTime
                + ", pmJWName=" + pmJWName + ", pmStatus=" + pmStatus + "]";
    }

}
