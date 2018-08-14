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
     * ��Ӹ����û���Ϣ
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
            System.err.println("�û�������Ϣ��Ӳ�������");
        }
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * ���¸����û���Ϣ
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
            System.err.println("�û�������Ϣ�޸Ĳ�������");
        }
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * ɾ���û�������Ϣ
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
            System.err.println("�û�������Ϣ�޸Ĳ�������");
        }
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * ��Ӹ����û���Ϣ
     * @return
     */
    @RequestMapping("data/search")
    public String companySearch(Data data,Model model){
        model.addAttribute("messageInput",data.getUsername());
        model.addAttribute("dataList",new DataDao().getAll(data.getUsername()));
        return "main";
    }
    

}
