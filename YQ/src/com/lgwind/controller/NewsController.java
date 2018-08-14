package com.lgwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.dao.ADDao;
import com.lgwind.dao.CompanyDao;
import com.lgwind.dao.DataDao;
import com.lgwind.dao.NewsDao;
import com.lgwind.dao.UserDao;
import com.lgwind.domain.AD;
import com.lgwind.domain.Company;
import com.lgwind.domain.Data;
import com.lgwind.domain.News;
import com.lgwind.domain.User;
import com.lgwind.util.ADUtil;
import com.lgwind.util.IData;
import com.lgwind.util.MapUtil;
import com.lgwind.util.UserUtil;
import com.lgwind.view.ADSet;
import com.lgwind.view.SignUp;

@Controller
@RequestMapping("/news")
public class NewsController {
    
    /**
     * 添加企业申请
     * @return
     */
    @RequestMapping("companyAdd")
    public String companyAdd(News news,Model model){
        try{
//            System.out.println(news);
//        System.out.println(company.getJwName());
            System.out.println();
//            news.setTime(IData.getDate()+" "+IData.getTime());
            //处理该信息
            new NewsDao().update(news);
            //若处理结果为通过
            if(news.getFinish()==2){
                //添加该企业
                Company company = new Company();
                company.setCompanyName(news.getCompany());
                new CompanyDao().add(company);
                //将申请用户角色为普通用户，则改为企业管理员
                User user = new UserDao().get(news.getUsername());
                if(user.getRole().equals("普通用户")){
                    user.setRole("企业管理员");
                    new UserDao().update(user);
                }
                //将申请用户的企业改为新添加的企业
                Data data = new DataDao().get(news.getUsername());
                data.setCompany(news.getCompany());
                new DataDao().update(data);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("“添加企业申请处理”操作有误！");
        }
        return "main";
    }
    
    /**
     * 添加企业申请
     * @return
     */
    @RequestMapping("companyUserAdd")
    public String companyUserAdd(News news,Model model){
        try{
//            System.out.println(news);
//        System.out.println(company.getJwName());
            System.out.println();
//            news.setTime(IData.getDate()+" "+IData.getTime());
            //处理该信息
            new NewsDao().update(news);
            //若处理结果为通过
            if(news.getFinish()==2){
                //将申请用户角色为普通用户，则改为企业管理员
                User user = new UserDao().get(news.getUsername());
                if(user.getRole().equals("普通用户")){
                    user.setRole("企业管理员");
                    new UserDao().update(user);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("“企业管理员申请处理”操作有误！");
        }
        return "main";
    }
    
    /**
     * 添加企业申请
     * @return
     */
    @RequestMapping("read")
    public String read(@RequestParam(value="id",required=true) int id, Model model){
        try{
//            System.out.println(news);
//        System.out.println(company.getJwName());
            System.out.println();
//            news.setTime(IData.getDate()+" "+IData.getTime());
            //获取要处理的news
            News news = new NewsDao().get(id);
            //待处理的信息不能改为已阅
            if(news.getFinish()==0){
            }else{
                news.setFinish(1);
            }
            new NewsDao().update(news);
            
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("“企业管理员申请处理”操作有误！");
        }
        return "main";
    }

}
