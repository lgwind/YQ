package com.lgwind.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.dao.ADDao;
import com.lgwind.dao.CompanyDao;
import com.lgwind.dao.DataDao;
import com.lgwind.dao.NewsDao;
import com.lgwind.dao.UserDao;
import com.lgwind.util.ADUtil;
import com.lgwind.util.IData;
import com.lgwind.util.UserUtil;
import com.lgwind.view.ADone;

@Controller
@RequestMapping("/page")
public class PageController {
       
    /**
     * 进入首页
     * @return
     */
    @RequestMapping("home")
    public String home(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="首页";
        UserUtil.subpage="";
        return "main";
    }
    
    /**
     * 进入考勤
     * @return
     */
    @RequestMapping("attendance")
    public String attendance(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="打卡";
        return "main";
    }
    
    /**
     * 进入考勤子页面 签到页面
     * @return
     */
    @RequestMapping("attendance/signUp")
    public String attendanceSignUP(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="打卡";
        return "main";
    }
    
    /**
     * 进入考勤子页面 考勤记录页面
     * @return
     */
    @RequestMapping("attendance/record")
    public String attendanceRecord(@RequestParam(value="username",required=true) String username,Model model){
        try{
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="考勤记录";
//        System.out.print(IData.getDate());
        model.addAttribute("record_date",IData.getDate());        
        model.addAttribute("record",ADUtil.adResult(username, IData.getDate()));
        }catch(Exception e){
            System.out.println("打开考勤子页面/考勤记录出现异常");
        }
        return "main";
    }
    
    /**
     * 进入考勤子页面 员工考勤记录页面
     * @param model
     * @return
     */
    @RequestMapping("attendance/recordCompany")
    public String attendanceRecordCompany(@RequestParam(value="username",required=true) String username,Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="员工考勤记录";
        List<ADone> companyDate = ADUtil.companyDay(username, IData.getDate());
        model.addAttribute("nowDate",IData.getDate());        
        model.addAttribute("companyDate",companyDate);
        return "main";
    }
    
    /**
     * 进入考勤子页面 企业信息完善页面
     * @return
     */
    @RequestMapping("attendance/companyPerson")
    public String attendanceCompanyPerson(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="企业信息完善";
        return "main";
    }
    
    /**
     * 进入考勤子页面 企业信息管理页面
     * @return
     */
    @RequestMapping("attendance/company")
    public String attendanceCompany(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="企业信息管理";
        model.addAttribute("company",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * 进入考勤子页面 个人信息完善页面
     * @return
     */
    @RequestMapping("attendance/messagePerson")
    public String attendanceMessagePerson(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="个人信息完善";
        return "main";
    }
    
    /**
     * 进入考勤子页面 用户信息管理页面
     * @return
     */
    @RequestMapping("attendance/message")
    public String attendanceMessage(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="用户信息管理";
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * 进入考勤子页面 设置考勤地址页面
     * @return
     */
    @RequestMapping("attendance/set")
    public String attendanceSet(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="设置考勤地点";
        return "main";
    }
    
    /**
     * 进入考勤子页面 企业员工申请页面
     * @return
     */
    @RequestMapping("attendance/apply")
    public String attendanceApply(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="考勤";
        UserUtil.subpage="企业相关申请";
        return "main";
    }
    
    /**
     * 进入论坛
     * @return
     */
    @RequestMapping("forum")
    public String forum(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="论坛";
        UserUtil.subpage="";
        return "main";
    }
    
    /**
     * 进入好友
     * @return
     */
    @RequestMapping("friend")
    public String friend(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="好友";
        UserUtil.subpage="";
        return "main";
    }
    
    /**
     * 进入消息
     * @return
     */
    @RequestMapping("news")
    public String news(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="消息";
        UserUtil.subpage="";
        return "main";
    }
    
    /**
     * 进入消息子页面 我的申请
     * @return
     */
    @RequestMapping("news/myApply")
    public String newsMyApply(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="消息";
        UserUtil.subpage="我的申请";
        return "main";
    }
    
    /**
     * 进入消息子页面 添加企业申请
     * @return
     */
    @RequestMapping("news/companyAdd")
    public String newsCompnayAdd(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="消息";
        UserUtil.subpage="添加企业申请";
        return "main";
    }
    
    /**
     * 进入消息子页面 企业管理员申请
     * @return
     */
    @RequestMapping("news/companyUserAdd")
    public String newsCompnayUserAdd(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="消息";
        UserUtil.subpage="企业管理员申请";
        return "main";
    }
    
    /**
     * 进入设置
     * @return
     */
    @RequestMapping("set")
    public String set(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="设置";
        UserUtil.subpage="";
        model.addAttribute("userList",new UserDao().getAll());
        return "main";
    }
    
    /**
     * 进入设置子页面 用户登录表管理
     * @return
     */
    @RequestMapping("set/user")
    public String setUser(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="设置";
        UserUtil.subpage="用户登录表管理";
        model.addAttribute("userList",new UserDao().getAll());
        return "main";
    }
    
    /**
     * 进入设置子页面 用户信息表管理
     * @return
     */
    @RequestMapping("set/data")
    public String setData(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="设置";
        UserUtil.subpage="用户信息表管理";
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }

    /**
     * 进入设置子页面 消息表管理
     * @return
     */
    @RequestMapping("set/news")
    public String setNews(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="设置";
        UserUtil.subpage="消息表管理";
        model.addAttribute("newsList",new NewsDao().getAll());
        return "main";
    }
    
    /**
     * 进入设置子页面 企业信息表管理
     * @return
     */
    @RequestMapping("set/company")
    public String setCompany(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="设置";
        UserUtil.subpage="企业信息表管理";
        model.addAttribute("companyList",new CompanyDao().getAll());
        return "main";
    }

    /**
     * 进入设置子页面 考勤记录表管理
     * @return
     */
    @RequestMapping("set/ad")
    public String setAD(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="设置";
        UserUtil.subpage="考勤记录表管理";
        model.addAttribute("adList",new ADDao().getAll());
        return "main";
    }
    
    /**
     * 进入我的页面
     * @return
     */
    @RequestMapping("me")
    public String me(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="我";
        UserUtil.subpage="登录";
        return "main";
    }
    
    /**
     * 进入我的子页面 登录页面
     * @return
     */
    @RequestMapping("me/login")
    public String meLogin(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="我";
        UserUtil.subpage="登录";
        return "main";
    }
    
    /**
     * 进入我的子页面 登录注册页面
     * @return
     */
    @RequestMapping("me/register")
    public String meRegister(){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="我";
        UserUtil.subpage="注册";
        return "main";
    }
	
    /**
     * 进入我的子页面 个人信息页面
     * @return
     */
    @RequestMapping("me/messagePerson")
    public String meMessagePerson(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="我";
        UserUtil.subpage="个人信息完善";
        return "main";
    }
    
    /**
     * 进入我的子页面 密码修改页面
     * @return
     */
    @RequestMapping("me/passwordUpdate")
    public String mePasswordUpdate(Model model){
        System.out.println();
        //返回定位当前页面位置
        UserUtil.page="我";
        UserUtil.subpage="密码修改";
        return "main";
    }
    
	

}
