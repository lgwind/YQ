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
     * �����ҵ����
     * @return
     */
    @RequestMapping("companyAdd")
    public String companyAdd(News news,Model model){
        try{
//            System.out.println(news);
//        System.out.println(company.getJwName());
            System.out.println();
//            news.setTime(IData.getDate()+" "+IData.getTime());
            //�������Ϣ
            new NewsDao().update(news);
            //��������Ϊͨ��
            if(news.getFinish()==2){
                //��Ӹ���ҵ
                Company company = new Company();
                company.setCompanyName(news.getCompany());
                new CompanyDao().add(company);
                //�������û���ɫΪ��ͨ�û������Ϊ��ҵ����Ա
                User user = new UserDao().get(news.getUsername());
                if(user.getRole().equals("��ͨ�û�")){
                    user.setRole("��ҵ����Ա");
                    new UserDao().update(user);
                }
                //�������û�����ҵ��Ϊ����ӵ���ҵ
                Data data = new DataDao().get(news.getUsername());
                data.setCompany(news.getCompany());
                new DataDao().update(data);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("�������ҵ���봦����������");
        }
        return "main";
    }
    
    /**
     * �����ҵ����
     * @return
     */
    @RequestMapping("companyUserAdd")
    public String companyUserAdd(News news,Model model){
        try{
//            System.out.println(news);
//        System.out.println(company.getJwName());
            System.out.println();
//            news.setTime(IData.getDate()+" "+IData.getTime());
            //�������Ϣ
            new NewsDao().update(news);
            //��������Ϊͨ��
            if(news.getFinish()==2){
                //�������û���ɫΪ��ͨ�û������Ϊ��ҵ����Ա
                User user = new UserDao().get(news.getUsername());
                if(user.getRole().equals("��ͨ�û�")){
                    user.setRole("��ҵ����Ա");
                    new UserDao().update(user);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("����ҵ����Ա���봦����������");
        }
        return "main";
    }
    
    /**
     * �����ҵ����
     * @return
     */
    @RequestMapping("read")
    public String read(@RequestParam(value="id",required=true) int id, Model model){
        try{
//            System.out.println(news);
//        System.out.println(company.getJwName());
            System.out.println();
//            news.setTime(IData.getDate()+" "+IData.getTime());
            //��ȡҪ�����news
            News news = new NewsDao().get(id);
            //���������Ϣ���ܸ�Ϊ����
            if(news.getFinish()==0){
            }else{
                news.setFinish(1);
            }
            new NewsDao().update(news);
            
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("����ҵ����Ա���봦����������");
        }
        return "main";
    }

}
