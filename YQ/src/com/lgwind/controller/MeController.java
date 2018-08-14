package com.lgwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.dao.ADDao;
import com.lgwind.dao.CompanyDao;
import com.lgwind.dao.DataDao;
import com.lgwind.domain.AD;
import com.lgwind.domain.Company;
import com.lgwind.domain.Data;
import com.lgwind.util.ADUtil;
import com.lgwind.util.IData;
import com.lgwind.util.MapUtil;
import com.lgwind.util.UserUtil;
import com.lgwind.view.SignUp;

@Controller
@RequestMapping("/me")
public class MeController {
    
    /**
     * 添加个人用户信息
     * @return
     */
    @RequestMapping("data/add")
    public String companyAdd(Data data,Model model){
        try{
//        System.out.println(company);
//        System.out.println(company.getJwName());
            if(!data.getUsername().equals("")){
                new DataDao().add(data);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("用户个人信息添加操作有误！");
        }
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * 更新个人用户信息
     * @return
     */
    @RequestMapping("data/update")
    public String companyUpdate(Data data,Model model){
        try{
//        System.out.println(company);
//        System.out.println(company.getJwName());
        new DataDao().update(data);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("用户个人信息修改操作有误！");
        }
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * 删除用户个人信息
     * @return
     */
    @RequestMapping("data/delete")
    public String companyDelete(@RequestParam(value="username",required=true) String username,Model model){
        try{
//        System.out.println(company);
//        System.out.println(company.getJwName());
        new DataDao().delete(username);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("用户个人信息修改操作有误！");
        }
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * 添加个人用户信息
     * @return
     */
    @RequestMapping("data/search")
    public String companySearch(Data data,Model model){
        model.addAttribute("messageInput",data.getUsername());
        model.addAttribute("dataList",new DataDao().getAll(data.getUsername()));
        return "main";
    }
    

}
