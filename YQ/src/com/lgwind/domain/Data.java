package com.lgwind.domain;

public class Data {
    
    private String username;
    private String company;
    private String position;
    private String icon;
    private String name;
    private String sex;
    private String phone;
    private String email;
    private String birthday;
    private String address;
    private int jwd=1;
    
    public Data() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Data(String username, String company, String position, String icon,
            String name, String sex, String phone, String email,
            String birthday, String address, int jwd) {
        super();
        this.username = username;
        this.company = company;
        this.position = position;
        this.icon = icon;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.jwd = jwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getJwd() {
        return jwd;
    }

    public void setJwd(int jwd) {
        this.jwd = jwd;
    }

    @Override
    public String toString() {
        return "Data [username=" + username + ", company=" + company
                + ", position=" + position + ", icon=" + icon + ", name="
                + name + ", sex=" + sex + ", phone=" + phone + ", email="
                + email + ", birthday=" + birthday + ", address=" + address
                + ", jwd=" + jwd + "]";
    }

}
