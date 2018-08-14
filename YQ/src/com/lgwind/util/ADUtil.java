package com.lgwind.util;

import java.util.ArrayList;
import java.util.List;

import com.lgwind.dao.ADDao;
import com.lgwind.dao.CompanyDao;
import com.lgwind.dao.DataDao;
import com.lgwind.domain.AD;
import com.lgwind.domain.Company;
import com.lgwind.domain.Data;
import com.lgwind.view.ADone;
import com.lgwind.view.Record;
import com.lgwind.view.SignUp;

public class ADUtil {
    
    /**
     * 根据用户名获取考勤信息
     * @param username
     * @return
     */
    public static SignUp adMessage(String username){
        SignUp signUp = new SignUp();
        try {
            if (username == null) {
                username = "";
            }
            username = username.replace(" ", "");

            if (username != null && !username.equals("未登录")) {

                // 根据用户名 获取用户所在的企业名
                Data data = new DataDao().get(username);
                String companyName = data.getCompany();
                // 根据企业名获取企业信息
                Company company = new CompanyDao().get(companyName);
                // 获取考勤班次
                signUp.setStartTime(company.getStartTime());
                signUp.setLastTime(company.getLastTime());
                // 获取考勤地点
                if(data.getJwd()==1){
                    signUp.setJwName(company.getJwName());
                    signUp.setJd(company.getJd());
                    signUp.setWd(company.getWd());
                }else if(data.getJwd()==2){
                    signUp.setJwName(company.getJwName2());
                    signUp.setJd(company.getJd2());
                    signUp.setWd(company.getWd2());
                }else if(data.getJwd()==3){
                    signUp.setJwName(company.getJwName3());
                    signUp.setJd(company.getJd3());
                    signUp.setWd(company.getWd3());
                }
                signUp.setScope(company.getScope());
                // 获取考勤状态
                signUp.setStatus("未考勤");
                AD ad = new ADDao().get(username, adTime());
                signUp.setStatus(ad.getStatus());
                if (signUp.getStatus() == null) {
                    signUp.setStatus("未考勤");
                }
                signUp.setScope2(ad.getScope()+"米");
            }
        } catch (Exception e) {
            System.err.println("ADUtil类/adMessage方法，获取考勤班次/考勤地点信息有误！\n");
        }        
        return signUp;
    }
    
    /**
     * 获取考勤表主键 ad_time的值
     * @return
     */
    public static String adTime(){
        String adTime = ""+IData.year();
        if(IData.month()<10){
            adTime+="0";
        }
        adTime+=IData.month();
        if(IData.day()<10){
            adTime+="0";
        }
        adTime+=IData.day();
        if(IData.hour()<12){
            adTime+="-am-0";
        }else{
            adTime+="-pm-1";
        }
        return adTime;
    }
    
    /**
     * 根据用户名和时间获取考勤结果
     * @param username
     * @param time
     * @return
     */
    public static Record adResult(String username, String time){
        Record record = new Record();
        try {
            time = time.replace("-", "");
            AD am = new ADDao().get(username, time + "-am-0");
            AD pm = new ADDao().get(username, time + "-pm-1");
            if (am != null) {
                record.setAmTime(am.getTime());
                record.setAmJWName(am.getJwName());
                record.setAmStatus(am.getStatus());
            }
            if (pm != null) {
                record.setPmTime(pm.getTime());
                record.setPmJWName(pm.getJwName());
                record.setPmStatus(pm.getStatus());
            }
        }catch(Exception e){
            System.out.println("ADUtil类的adResult()函数获取考勤结果有误！");
        }
        return record;
    }
    
    /**
     * 获取某用户的考勤结果
     * @param username
     * @return
     */
    public static List<AD> personAD(String username){
//        System.out.print(username+"test");
        List<AD> adList = new ADDao().getAll(username);
        for(int i=0; i<adList.size(); i++){
            adList.get(i).setAdTime(personAD_01(adList.get(i).getAdTime()));
        }
        List<AD> adList2 = new ArrayList<AD>();
        for(int i=adList.size()-1; i>=0; i--){
            adList2.add(adList.get(i));
        }
        return adList2;
    }
    
    /**
     * 分析考勤数据 20180512-pm-1
     * @param adTime
     * @return
     */
    private static String personAD_01(String adTime){
        String rResult = "未获取信息";
        try{        
            String [] result = adTime.split("-");
            if(result[1].equals("am")){
                result[1]="上午";
            }else if(result[1].equals("pm")){
                result[1]="下午";
            }
            rResult = result[0]+"-"+result[1];
        }catch(Exception e){
            System.err.println("ADUtil类静态函数personAD_01的参数adTime传入有误！");
        }
        return rResult;
    }
    
    /**
     * 获得某一用户某天的考勤记录
     * @param username
     * @param date
     * @return
     */
    public static ADone oneDay(String username, String date){
        ADone one = new ADone();
        try{
            Record record = adResult(username, date);
            one.setUsername(username);
            one.setAmStatus(record.getAmStatus());
            one.setAmTime(record.getAmTime());
            one.setPmStatus(record.getPmStatus());
            one.setPmTime(record.getPmTime());
            one.setName(new DataDao().get(username).getName());
        }catch(Exception e){
            System.err.println("ADUtil类静态函数oneDay出错！");
        }
        return one;
    }
    
    /**
     * 获取企业所有员工某天的考勤记录
     * @param company
     * @param date
     * @return
     */
    public static List<ADone> companyDay(String username, String date){
        List<ADone> all = new ArrayList<ADone>();
        try{
            String company = new DataDao().get(username).getCompany();
            List<Data> dataList = new DataDao().getAllByCompany(company);
            for(int i=0; i<dataList.size(); i++){
                ADone one = oneDay(dataList.get(i).getUsername(),date);
                all.add(one);
            }            
        }catch(Exception e){
            System.err.println("ADUtil类静态函数oneDay出错！");
        }
        return all;
    }
 
}
