package com.lgwind.domain;

public class User {
    
    private String username;
    private String password="111";
    private String role="��ͨ�û�";
    
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String username, String password, String role) {
        super();
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "user [username=" + username + ", password=" + password + ", role="
                + role + "]";
    }
    
}
