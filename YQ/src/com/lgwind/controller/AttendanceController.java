package com.lgwind.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.dao.ADDao;
import com.lgwind.dao.CompanyDao;
import com.lgwind.domain.AD;
import com.lgwind.domain.Company;
import com.lgwind.util.ADUtil;
import com.lgwind.util.IData;
import com.lgwind.util.MapUtil;
import com.lgwind.util.UserUtil;
import com.lgwind.view.ADSet;
import com.lgwind.view.ADone;
import com.lgwind.view.SignUp;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
       
    /**
     * 打卡考勤
     * @return
     */
    @RequestMapping("signUp")
    public String signUp(@RequestParam(value="username",required=true) String username,
            @RequestParam(value="jd",required=true) String jd,
            @RequestParam(value="wd",required=true) String wd,
            @RequestParam(value="jwName",required=true) String jwName,
            @RequestParam(value="time",required=true) String time,
            Model model){
        System.out.print("\n点击签到\n");
        
        //用户名去掉多余的空格
        username = username.replace(" ", "");
        
        AD ad = new AD(); 
        ad.setUsername(username);
        ad.setAdTime(ADUtil.adTime());
        ad.setJd(jd);
        ad.setWd(wd);
        ad.setJwName(jwName);
        ad.setTime(time);
        
        //获取用户签到数据
        SignUp signUp = ADUtil.adMessage(username);
        
        //判断考勤状态
        String status = "正常考勤";
        int nowTime = IData.timeNum(IData.getTime());//当前时间
        int startTime = IData.timeNum(signUp.getStartTime());
        int lastTime = IData.timeNum(signUp.getLastTime());
        //早上签到
        if(IData.hour()<12){
            if(startTime<nowTime){
                status="迟到";
            }
        }else{
//            System.out.print(lastTime+"-"+nowTime);
            if(lastTime>nowTime){
                status="早退";
            }
        }
        
        double scope = 100000000;
        try{
            // 判断考勤范围 jd wd signUp.getJd() signUp.getWd()
            scope = MapUtil.getDistance(Double.parseDouble(jd),
                    Double.parseDouble(wd), Double.parseDouble(signUp.getJd()),
                    Double.parseDouble(signUp.getWd()));
            System.out.println("考勤距离" + scope + "米");
            model.addAttribute("scopeResult",scope+"米");
            ad.setScope((int)scope);
        }catch(Exception e){
            System.err.println("计算考勤距离有误，有可能是定位失败！");
        }
        if(scope>signUp.getScope()){
            status="不在考勤范围内";
        }
        
        ad.setStatus(status);
        
        
        
        if(new ADDao().update(ad)==0){
            new ADDao().add(ad);
        }
         
        return "main";
    }
    
    /**
     * 根据日期查看 考勤记录
     * @return
     */
    @RequestMapping("record")
    public String attendanceRecord(@RequestParam(value="username",required=true) String username,@RequestParam(value="date",required=true) String date,Model model){
        System.out.println();
        //返回定位当前页面位置
        username=username.replace(" ", "");
        System.out.println("获取考勤信息：用户("+username+") 时间("+date+")");
        model.addAttribute("record_date",date);
        model.addAttribute("record",ADUtil.adResult(username, date));
        return "main";
    }
    
    /**
     * 根据日期查看 考勤记录
     * @return
     */
    @RequestMapping("recordCompany")
    public String attendanceRecordCompany(@RequestParam(value="username",required=true) String username,@RequestParam(value="date",required=true) String date,Model model){
        System.out.println();
        //返回定位当前页面位置
        username=username.replace(" ", "");
        System.out.println("获取考勤信息：用户("+username+") 时间("+date+")");
        List<ADone> companyDate = ADUtil.companyDay(username, date);
        model.addAttribute("nowDate",date);        
        model.addAttribute("companyDate",companyDate);
        return "main";
    }
    
    /**
     * 添加企业信息
     * @return
     */
    @RequestMapping("company/add")
    public String companyAdd(Company company,Model model){
        try{
//        System.out.println(company);
//        System.out.println(company.getJwName());
            System.out.println();
            if(!company.getCompanyName().equals("")){
                new CompanyDao().add(company);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("企业信息添加操作有误！");
        }
        model.addAttribute("company",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * 更新企业信息
     * @return
     */
    @RequestMapping("company/update")
    public String companyUpdate(Company company,Model model){
        try{
//            System.out.println(company.getJwName());
//            System.out.println(company);
            System.out.println();
            new CompanyDao().update(company);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("企业信息修改操作有误！");
        }
        model.addAttribute("company",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * 删除企业信息
     * @return
     */
    @RequestMapping("company/delete")
    public String companyDelete(@RequestParam(value="companyName",required=true) String companyName,Model model){
        try{
//        System.out.println(company);
            System.out.println();
        new CompanyDao().delete(companyName);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("企业信息修改操作有误！");
        }
        model.addAttribute("company",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * 添加企业信息
     * @return
     */
    @RequestMapping("company/search")
    public String companySearch(Company company,Model model){
        System.out.println();
        model.addAttribute("messageInput",company.getCompanyName());
        model.addAttribute("company",new CompanyDao().getAll(company.getCompanyName()));
        return "main";
    }
    
    /**
     * 设置考勤地址
     * @return
     */
    @RequestMapping("set")
    public String set(@RequestParam(value="username",required=true) String username, @RequestParam(value="num",required=true) int num,Model model){
        try{
            System.out.println("设置考勤地址！");
            ADSet.address(username, num);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("设置考勤地址操作有误！");
        }
        return "main";
    }
    
    

}
