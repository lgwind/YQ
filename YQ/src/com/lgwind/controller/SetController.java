package com.lgwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgwind.dao.*;
import com.lgwind.domain.*;
import com.lgwind.util.*;
import com.lgwind.view.*;

@Controller
@RequestMapping("/set")
public class SetController {
    
    /**
     * ���  �û���¼��
     * @return
     */
    @RequestMapping("user/add")
    public String userAdd(User user,Model model){
        try{
        System.out.println("\n");
//        System.out.println(company.getJwName());
            if(!user.getUsername().equals("")){
                new UserDao().add(user);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\n�û���Ϣ��/��Ӳ�������");
        }
        model.addAttribute("userList",new UserDao().getAll());
        return "main";
    }
    
    /**
     * ���� �û���¼��
     * @return
     */
    @RequestMapping("user/update")
    public String userUpdate(User user,Model model){
        try{
            System.out.println("\n");
//        System.out.println(company.getJwName());
        new UserDao().update(user);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\n��ҵ��Ϣ��/�޸Ĳ�������");
        }
        model.addAttribute("userList",new UserDao().getAll());
        return "main";
    }
    
    /**
     * ɾ�� �û���¼��
     * @return
     */
    @RequestMapping("user/delete")
    public String userDelete(@RequestParam(value="username",required=true) String username,Model model){
        try{
            System.out.println("\n");
//        System.out.println(user.getJwName());
            new UserDao().delete(username);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\n��ҵ��Ϣ��/ɾ����������");
        }
        model.addAttribute("userList",new UserDao().getAll());
        return "main";
    }
    
    /**
     * ���� �û���¼��
     * @return
     */
    @RequestMapping("user/search")
    public String userSearch(User user,Model model){
        System.out.println("\n");
        model.addAttribute("messageInput",user.getUsername());
        model.addAttribute("userList",new UserDao().getAll(user.getUsername()));
        return "main";
    }
    
    /**
     * ���  �û���Ϣ��
     * @return
     */
    @RequestMapping("data/add")
    public String dataAdd(Data data,Model model){
        try{
        System.out.println("\n");
//        System.out.println(company.getJwName());
            if(!data.getUsername().equals("")){
                new DataDao().add(data);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\n�û���Ϣ��/��Ӳ�������");
        }
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * ���� �û���Ϣ��
     * @return
     */
    @RequestMapping("data/update")
    public String dataUpdate(Data data,Model model){
        try{
        System.out.println("\n");
//        System.out.println(company.getJwName());
        new DataDao().update(data);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\n�û���Ϣ��/�޸Ĳ�������");
        }
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * ɾ�� �û���Ϣ��
     * @return
     */
    @RequestMapping("data/delete")
    public String dataDelete(@RequestParam(value="username",required=true) String username,Model model){
        try{
            System.out.println("\n");
//        System.out.println(company.getJwName());
        new DataDao().delete(username);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\n�û���Ϣ��/ɾ����������");
        }
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * ���� �û���Ϣ��
     * @return
     */
    @RequestMapping("data/search")
    public String dataSearch(Data data,Model model){
        System.out.println("\n");
        model.addAttribute("messageInput",data.getUsername());
        model.addAttribute("dataList",new DataDao().getAll(data.getUsername()));
        return "main";
    }
    
    /**
     * ���  ��ҵ��Ϣ��
     * @return
     */
    @RequestMapping("company/add")
    public String companyAdd(Company company,Model model){
        try{
            System.out.println("\n");
//        System.out.println(company.getJwName());
            if(!company.getCompanyName().equals("")){
                new CompanyDao().add(company);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\n�û���Ϣ��/��Ӳ�������");
        }
        model.addAttribute("companyList",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * ���� ��ҵ��Ϣ��
     * @return
     */
    @RequestMapping("company/update")
    public String companyUpdate(Company company,Model model){
        try{
            System.out.println("\n");
//        System.out.println(company.getJwName());
        new CompanyDao().update(company);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\n��ҵ��Ϣ��/�޸Ĳ�������");
        }
        model.addAttribute("companyList",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * ɾ�� ��ҵ��Ϣ��
     * @return
     */
    @RequestMapping("company/delete")
    public String companyDelete(@RequestParam(value="companyName",required=true) String companyName,Model model){
        try{
            System.out.println("\n");
//        System.out.println(company.getJwName());
            new CompanyDao().delete(companyName);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("\n��ҵ��Ϣ��/ɾ����������");
        }
        model.addAttribute("companyList",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * ���� �û���Ϣ��
     * @return
     */
    @RequestMapping("company/search")
    public String companySearch(Company company,Model model){
        System.out.println("\n");
        model.addAttribute("messageInput",company.getCompanyName());
        model.addAttribute("companyList",new CompanyDao().getAll(company.getCompanyName()));
        return "main";
    }
    

}
