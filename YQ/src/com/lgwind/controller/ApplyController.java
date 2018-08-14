package com.lgwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.dao.ADDao;
import com.lgwind.dao.CompanyDao;
import com.lgwind.dao.NewsDao;
import com.lgwind.domain.AD;
import com.lgwind.domain.Company;
import com.lgwind.domain.News;
import com.lgwind.util.ADUtil;
import com.lgwind.util.IData;
import com.lgwind.util.MapUtil;
import com.lgwind.util.UserUtil;
import com.lgwind.view.ADSet;
import com.lgwind.view.SignUp;

@Controller
@RequestMapping("/apply")
public class ApplyController {
    
    /**
     * 添加企业申请
     * @return
     */
    @RequestMapping("companyAdd")
    public String companyAdd(News news,Model model){
        try{
//        System.out.println(company);
//        System.out.println(company.getJwName());
            System.out.println();
            if(new CompanyDao().get(news.getCompany())!=null){
                model.addAttribute("companyAddResult","申请失败，企业名已存在！");
                model.addAttribute("companyAddNews", news);
                return "main";             
            }
            news.setTime(IData.getDate()+" "+IData.getTime());
            new NewsDao().add(news);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("“添加企业申请”操作有误！");
        }
        model.addAttribute("companyAddResult","申请已提交！");
        model.addAttribute("companyAddNews", news);
        return "main";
    }
    
    /**
     * 企业管理员申请
     * @return
     */
    @RequestMapping("companyUserAdd")
    public String companyUserAdd(News news,Model model){
        try{
//        System.out.println(company);
//        System.out.println(company.getJwName());
            System.out.println();
            news.setTime(IData.getDate()+" "+IData.getTime());
            new NewsDao().add(news);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("“企业管理员申请”操作有误！");
        }
        model.addAttribute("companyUserAddResult","申请已提交！");
        model.addAttribute("companyUserAddNews", news);
        return "main";
    }

}
