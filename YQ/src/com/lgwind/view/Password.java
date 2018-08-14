package com.lgwind.view;

public class Password {
    
    private String username;  //用户名
    private String password0; //原密码
    private String password;  //新密码
    private String password2; //确认秘密
    
    public Password() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Password(String username, String password0, String password,
            String password2) {
        super();
        this.username = username;
        this.password0 = password0;
        this.password = password;
        this.password2 = password2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword0() {
        return password0;
    }

    public void setPassword0(String password0) {
        this.password0 = password0;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "Password [username=" + username + ", password0=" + password0
                + ", password=" + password + ", password2=" + password2 + "]";
    }

}
