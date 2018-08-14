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
     * ������ҳ
     * @return
     */
    @RequestMapping("home")
    public String home(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��ҳ";
        UserUtil.subpage="";
        return "main";
    }
    
    /**
     * ���뿼��
     * @return
     */
    @RequestMapping("attendance")
    public String attendance(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="��";
        return "main";
    }
    
    /**
     * ���뿼����ҳ�� ǩ��ҳ��
     * @return
     */
    @RequestMapping("attendance/signUp")
    public String attendanceSignUP(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="��";
        return "main";
    }
    
    /**
     * ���뿼����ҳ�� ���ڼ�¼ҳ��
     * @return
     */
    @RequestMapping("attendance/record")
    public String attendanceRecord(@RequestParam(value="username",required=true) String username,Model model){
        try{
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="���ڼ�¼";
//        System.out.print(IData.getDate());
        model.addAttribute("record_date",IData.getDate());        
        model.addAttribute("record",ADUtil.adResult(username, IData.getDate()));
        }catch(Exception e){
            System.out.println("�򿪿�����ҳ��/���ڼ�¼�����쳣");
        }
        return "main";
    }
    
    /**
     * ���뿼����ҳ�� Ա�����ڼ�¼ҳ��
     * @param model
     * @return
     */
    @RequestMapping("attendance/recordCompany")
    public String attendanceRecordCompany(@RequestParam(value="username",required=true) String username,Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="Ա�����ڼ�¼";
        List<ADone> companyDate = ADUtil.companyDay(username, IData.getDate());
        model.addAttribute("nowDate",IData.getDate());        
        model.addAttribute("companyDate",companyDate);
        return "main";
    }
    
    /**
     * ���뿼����ҳ�� ��ҵ��Ϣ����ҳ��
     * @return
     */
    @RequestMapping("attendance/companyPerson")
    public String attendanceCompanyPerson(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="��ҵ��Ϣ����";
        return "main";
    }
    
    /**
     * ���뿼����ҳ�� ��ҵ��Ϣ����ҳ��
     * @return
     */
    @RequestMapping("attendance/company")
    public String attendanceCompany(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="��ҵ��Ϣ����";
        model.addAttribute("company",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * ���뿼����ҳ�� ������Ϣ����ҳ��
     * @return
     */
    @RequestMapping("attendance/messagePerson")
    public String attendanceMessagePerson(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="������Ϣ����";
        return "main";
    }
    
    /**
     * ���뿼����ҳ�� �û���Ϣ����ҳ��
     * @return
     */
    @RequestMapping("attendance/message")
    public String attendanceMessage(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="�û���Ϣ����";
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }
    
    /**
     * ���뿼����ҳ�� ���ÿ��ڵ�ַҳ��
     * @return
     */
    @RequestMapping("attendance/set")
    public String attendanceSet(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="���ÿ��ڵص�";
        return "main";
    }
    
    /**
     * ���뿼����ҳ�� ��ҵԱ������ҳ��
     * @return
     */
    @RequestMapping("attendance/apply")
    public String attendanceApply(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="��ҵ�������";
        return "main";
    }
    
    /**
     * ������̳
     * @return
     */
    @RequestMapping("forum")
    public String forum(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��̳";
        UserUtil.subpage="";
        return "main";
    }
    
    /**
     * �������
     * @return
     */
    @RequestMapping("friend")
    public String friend(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="";
        return "main";
    }
    
    /**
     * ������Ϣ
     * @return
     */
    @RequestMapping("news")
    public String news(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��Ϣ";
        UserUtil.subpage="";
        return "main";
    }
    
    /**
     * ������Ϣ��ҳ�� �ҵ�����
     * @return
     */
    @RequestMapping("news/myApply")
    public String newsMyApply(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��Ϣ";
        UserUtil.subpage="�ҵ�����";
        return "main";
    }
    
    /**
     * ������Ϣ��ҳ�� �����ҵ����
     * @return
     */
    @RequestMapping("news/companyAdd")
    public String newsCompnayAdd(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��Ϣ";
        UserUtil.subpage="�����ҵ����";
        return "main";
    }
    
    /**
     * ������Ϣ��ҳ�� ��ҵ����Ա����
     * @return
     */
    @RequestMapping("news/companyUserAdd")
    public String newsCompnayUserAdd(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��Ϣ";
        UserUtil.subpage="��ҵ����Ա����";
        return "main";
    }
    
    /**
     * ��������
     * @return
     */
    @RequestMapping("set")
    public String set(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="";
        model.addAttribute("userList",new UserDao().getAll());
        return "main";
    }
    
    /**
     * ����������ҳ�� �û���¼�����
     * @return
     */
    @RequestMapping("set/user")
    public String setUser(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="�û���¼�����";
        model.addAttribute("userList",new UserDao().getAll());
        return "main";
    }
    
    /**
     * ����������ҳ�� �û���Ϣ�����
     * @return
     */
    @RequestMapping("set/data")
    public String setData(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="�û���Ϣ�����";
        model.addAttribute("dataList",new DataDao().getAll());
        return "main";
    }

    /**
     * ����������ҳ�� ��Ϣ�����
     * @return
     */
    @RequestMapping("set/news")
    public String setNews(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="��Ϣ�����";
        model.addAttribute("newsList",new NewsDao().getAll());
        return "main";
    }
    
    /**
     * ����������ҳ�� ��ҵ��Ϣ�����
     * @return
     */
    @RequestMapping("set/company")
    public String setCompany(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="��ҵ��Ϣ�����";
        model.addAttribute("companyList",new CompanyDao().getAll());
        return "main";
    }

    /**
     * ����������ҳ�� ���ڼ�¼�����
     * @return
     */
    @RequestMapping("set/ad")
    public String setAD(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="����";
        UserUtil.subpage="���ڼ�¼�����";
        model.addAttribute("adList",new ADDao().getAll());
        return "main";
    }
    
    /**
     * �����ҵ�ҳ��
     * @return
     */
    @RequestMapping("me")
    public String me(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��";
        UserUtil.subpage="��¼";
        return "main";
    }
    
    /**
     * �����ҵ���ҳ�� ��¼ҳ��
     * @return
     */
    @RequestMapping("me/login")
    public String meLogin(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��";
        UserUtil.subpage="��¼";
        return "main";
    }
    
    /**
     * �����ҵ���ҳ�� ��¼ע��ҳ��
     * @return
     */
    @RequestMapping("me/register")
    public String meRegister(){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��";
        UserUtil.subpage="ע��";
        return "main";
    }
	
    /**
     * �����ҵ���ҳ�� ������Ϣҳ��
     * @return
     */
    @RequestMapping("me/messagePerson")
    public String meMessagePerson(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��";
        UserUtil.subpage="������Ϣ����";
        return "main";
    }
    
    /**
     * �����ҵ���ҳ�� �����޸�ҳ��
     * @return
     */
    @RequestMapping("me/passwordUpdate")
    public String mePasswordUpdate(Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        UserUtil.page="��";
        UserUtil.subpage="�����޸�";
        return "main";
    }
    
	

}
