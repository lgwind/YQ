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
     * �򿨿���
     * @return
     */
    @RequestMapping("signUp")
    public String signUp(@RequestParam(value="username",required=true) String username,
            @RequestParam(value="jd",required=true) String jd,
            @RequestParam(value="wd",required=true) String wd,
            @RequestParam(value="jwName",required=true) String jwName,
            @RequestParam(value="time",required=true) String time,
            Model model){
        System.out.print("\n���ǩ��\n");
        
        //�û���ȥ������Ŀո�
        username = username.replace(" ", "");
        
        AD ad = new AD(); 
        ad.setUsername(username);
        ad.setAdTime(ADUtil.adTime());
        ad.setJd(jd);
        ad.setWd(wd);
        ad.setJwName(jwName);
        ad.setTime(time);
        
        //��ȡ�û�ǩ������
        SignUp signUp = ADUtil.adMessage(username);
        
        //�жϿ���״̬
        String status = "��������";
        int nowTime = IData.timeNum(IData.getTime());//��ǰʱ��
        int startTime = IData.timeNum(signUp.getStartTime());
        int lastTime = IData.timeNum(signUp.getLastTime());
        //����ǩ��
        if(IData.hour()<12){
            if(startTime<nowTime){
                status="�ٵ�";
            }
        }else{
//            System.out.print(lastTime+"-"+nowTime);
            if(lastTime>nowTime){
                status="����";
            }
        }
        
        double scope = 100000000;
        try{
            // �жϿ��ڷ�Χ jd wd signUp.getJd() signUp.getWd()
            scope = MapUtil.getDistance(Double.parseDouble(jd),
                    Double.parseDouble(wd), Double.parseDouble(signUp.getJd()),
                    Double.parseDouble(signUp.getWd()));
            System.out.println("���ھ���" + scope + "��");
            model.addAttribute("scopeResult",scope+"��");
            ad.setScope((int)scope);
        }catch(Exception e){
            System.err.println("���㿼�ھ��������п����Ƕ�λʧ�ܣ�");
        }
        if(scope>signUp.getScope()){
            status="���ڿ��ڷ�Χ��";
        }
        
        ad.setStatus(status);
        
        
        
        if(new ADDao().update(ad)==0){
            new ADDao().add(ad);
        }
         
        return "main";
    }
    
    /**
     * �������ڲ鿴 ���ڼ�¼
     * @return
     */
    @RequestMapping("record")
    public String attendanceRecord(@RequestParam(value="username",required=true) String username,@RequestParam(value="date",required=true) String date,Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        username=username.replace(" ", "");
        System.out.println("��ȡ������Ϣ���û�("+username+") ʱ��("+date+")");
        model.addAttribute("record_date",date);
        model.addAttribute("record",ADUtil.adResult(username, date));
        return "main";
    }
    
    /**
     * �������ڲ鿴 ���ڼ�¼
     * @return
     */
    @RequestMapping("recordCompany")
    public String attendanceRecordCompany(@RequestParam(value="username",required=true) String username,@RequestParam(value="date",required=true) String date,Model model){
        System.out.println();
        //���ض�λ��ǰҳ��λ��
        username=username.replace(" ", "");
        System.out.println("��ȡ������Ϣ���û�("+username+") ʱ��("+date+")");
        List<ADone> companyDate = ADUtil.companyDay(username, date);
        model.addAttribute("nowDate",date);        
        model.addAttribute("companyDate",companyDate);
        return "main";
    }
    
    /**
     * �����ҵ��Ϣ
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
            System.err.println("��ҵ��Ϣ��Ӳ�������");
        }
        model.addAttribute("company",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * ������ҵ��Ϣ
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
            System.err.println("��ҵ��Ϣ�޸Ĳ�������");
        }
        model.addAttribute("company",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * ɾ����ҵ��Ϣ
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
            System.err.println("��ҵ��Ϣ�޸Ĳ�������");
        }
        model.addAttribute("company",new CompanyDao().getAll());
        return "main";
    }
    
    /**
     * �����ҵ��Ϣ
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
     * ���ÿ��ڵ�ַ
     * @return
     */
    @RequestMapping("set")
    public String set(@RequestParam(value="username",required=true) String username, @RequestParam(value="num",required=true) int num,Model model){
        try{
            System.out.println("���ÿ��ڵ�ַ��");
            ADSet.address(username, num);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("���ÿ��ڵ�ַ��������");
        }
        return "main";
    }
    
    

}
