package com.lgwind.view;

import com.lgwind.dao.CompanyDao;
import com.lgwind.dao.DataDao;
import com.lgwind.domain.Company;
import com.lgwind.domain.Data;

/**
 * 获取用户考勤信息
 * @author Lgwind
 *
 */
public class ADSet {
    
    private String jd;
    private String wd;
    private String jwName;
    
    private String jd1;
    private String wd1;
    private String jwName1;
    
    private String jd2;
    private String wd2;
    private String jwName2;
    
    private String jd3;
    private String wd3;
    private String jwName3;
    
    /**
     * 获取用户考勤信息
     * @param username 用户名
     */
    public ADSet(String username){
        getAttribute(username);
        
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

    public String getJd1() {
        return jd1;
    }

    public void setJd1(String jd1) {
        this.jd1 = jd1;
    }

    public String getWd1() {
        return wd1;
    }

    public void setWd1(String wd1) {
        this.wd1 = wd1;
    }

    public String getJwName1() {
        return jwName1;
    }

    public void setJwName1(String jwName1) {
        this.jwName1 = jwName1;
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
        return "ADSet [jd=" + jd + ", wd=" + wd + ", jwName=" + jwName + "]";
    }

    /**
     * 获取考勤地址信息
     * @param username 用户名
     */
    private void getAttribute(String username) {
        try {
            // 获取默认考勤地址
            int jwd = new DataDao().get(username).getJwd();
            // 获取考勤企业
            String companyName = new DataDao().get(username).getCompany();
            Company company = new CompanyDao().get(companyName);
            
            jd1 = company.getJd();
            wd1 = company.getWd();
            jwName1 = company.getJwName();
            
            jd2 = company.getJd2();
            wd2 = company.getWd2();
            jwName2 = company.getJwName2();
            
            jd3 = company.getJd3();
            wd3 = company.getWd3();
            jwName3 = company.getJwName3();
            
            if(jwd==1){
                jd = company.getJd();
                wd = company.getWd();
                jwName = company.getJwName();
            }else if(jwd==2){
                jd = company.getJd2();
                wd = company.getWd2();
                jwName = company.getJwName2();
            }else if(jwd==3){
                jd = company.getJd3();
                wd = company.getWd3();
                jwName = company.getJwName3();
            }else{
                System.out.println("获取考勤地址信息错误！");
            }
            
        }catch(Exception e){
            System.out.println("获取考勤地址信息有误！");
        }
    }
    
    /**
     * 设置考勤地址
     * @param username 用户名
     * @param num 默认考勤地址
     */
    public static void address(String username, int num){
        try{
//            System.out.println(num+"-"+new DataDao().get(username).getJwd());
            Data data = new DataDao().get(username);
            data.setJwd(num);
            new DataDao().update(data);
        }catch(Exception e){
            System.out.println("设置用户考勤信息失败");
        }
    }
    
    
    
    

}
