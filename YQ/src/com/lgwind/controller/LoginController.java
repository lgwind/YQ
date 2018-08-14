package com.lgwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgwind.dao.UserDao;
import com.lgwind.domain.User;
import com.lgwind.util.UserUtil;
import com.lgwind.view.Password;

@Controller
@RequestMapping("/user")
public class LoginController {
       
    /**
     * ִ�е�¼��������֤�û���������
     * @param user �û�ʵ����
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(User user, Model model) {
        System.out.print("\n�����û���¼������");
        //��յ�¼ʱ���û���
        UserUtil.username="δ��¼";
        //��յ�¼ʱ���û���ɫ
        UserUtil.userrole="null";
        
        //��֤�Ƿ���ϵͳ�����û�
        boolean superUser=UserUtil.isSuperUser(user);
        //���ǳ����û��������õ�¼��ɫΪ��������Ա�������û���̨����
        if (superUser) {
            //�����¼ʱ���û���
            UserUtil.username=user.getUsername();
            //�����¼ʱ���û���ɫ
            UserUtil.userrole="��������Ա";
            System.out.print("��¼�ɹ�\n");
            return "main";
        }
        
        //��֤�û����Ƿ����
        boolean exit = UserUtil.isExitName(user.getUsername());
        //���û��������ڣ��򷵻ص�¼ҳ�����µ�¼
        if (!exit) {            
            //�����û�ʵ���ഫ��ȥ
            model.addAttribute("user",user);
            //���û��������ڵ���Ϣ����ȥ
            if(user.getUsername().equals("")) {
                model.addAttribute("loginResult","������û���Ϊ�գ����������룡����");
            }else {
                model.addAttribute("loginResult","���û��������ڣ����������룡����");
            }
            System.out.print("��¼ʧ��\n");
            return "main";
        }
        
        //��֤�����Ƿ���ȷ
        boolean truePassword=UserUtil.isTruePassword(user);
        //�����벻��ȷ���򷵻ص�¼ҳ�����µ�¼
        if(!truePassword) {         
            //�����û�ʵ���ഫ��ȥ
            model.addAttribute("user",user);
            //����������������Ϣ����ȥ
            if(user.getPassword().equals("")) {
                model.addAttribute("loginResult","���������Ϊ�գ����������룡����");
            }else {
                model.addAttribute("loginResult","��������������������룡����");
            }
            System.out.print("��¼ʧ��\n");
            return "main";
        }
        
        //��֤�û���ɫ���
        String role = UserUtil.roleIS(user.getUsername());
        //����ɫ����ǹ���Ա�������õ�¼��ɫΪ����Ա�������̨����
        if(role.equals("����Ա")) {
            //�����¼ʱ���û���
            UserUtil.username=user.getUsername();
            //�����¼ʱ���û���ɫ
            UserUtil.userrole="����Ա";
            System.out.print("��¼�ɹ�\n");
            return "main";
        }
        //����ɫ�������ҵ����Ա�������õ�¼��ɫΪ��ҵ����Ա�������̨����
        if(role.equals("��ҵ����Ա")) {
            //�����¼ʱ���û���
            UserUtil.username=user.getUsername();
            //�����¼ʱ���û���ɫ
            UserUtil.userrole="��ҵ����Ա";
            System.out.print("��¼�ɹ�\n");
            return "main";
        }
        //����ɫ�������ͨ�û��������õ�¼��ɫΪ��ͨ�û��������̨����
        //�����¼ʱ���û���
        UserUtil.username=user.getUsername();
        //�����¼ʱ���û���ɫ
        UserUtil.userrole="��ͨ�û�";
        System.out.print("��¼�ɹ�\n");
        return "main";
    }
	
    /**
     * ������ͨ�û�ע�����
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("register")
    public String register(User user,String password2, Model model) {
        System.out.print("\n������ͨ�û�ע�������");
        //��յ�¼ʱ���û���
        UserUtil.username="δ��¼";
        //��յ�¼ʱ���û���ɫ
        UserUtil.userrole="null";
        //��֤�û����Ƿ����
        boolean exit = UserUtil.isExitName(user.getUsername());
        //���û����Ѵ��ڣ����ش�����Ϣ
        if(exit){
            System.err.println("���û����Ѵ��ڣ�");
            //�����û������б�
            model.addAttribute("user",user);
            //�����û���������
            model.addAttribute("password2",password2);
            //���ظ��û����Ѵ��ڵ���Ϣ
            model.addAttribute("registerResult","���û����Ѵ��ڣ�");
            return "main";            
        }
        //���û���Ϊ�գ����ش�����Ϣ
        if(user.getUsername().equals("")) {
            System.err.println("�û���Ϊ�գ�");
            //�����û������б�
            model.addAttribute("user",user);
            //�����û���������
            model.addAttribute("password2",password2);
            //�����û���Ϊ�յ���Ϣ
            model.addAttribute("registerResult","�û���Ϊ�գ�");
            return "main";            
        }
        //������Ϊ�գ��򷵻ش�����Ϣ
        if(user.getPassword().equals("")) {
            System.err.println("����Ϊ�գ�");
            //�����û������б�
            model.addAttribute("user",user);
            //�����û���������
            model.addAttribute("password2",password2);
            //��������Ϊ�յ���Ϣ
            model.addAttribute("registerResult","����Ϊ�գ�");
            return "main";            
        }
        //��ȷ������Ϊ�գ��򷵻ش�����Ϣ
        if(password2.equals("")) {
            System.err.println("ȷ������Ϊ�գ�");
            //�����û������б�
            model.addAttribute("user",user);
            //�����û���������
            model.addAttribute("password2",password2);
            //��������Ϊ�յ���Ϣ
            model.addAttribute("registerResult","ȷ������Ϊ�գ�");
            return "main";            
        }
        //��֤��������������Ƿ�һ��
        boolean twiceSamePassword = UserUtil.isTwiceSamePassword(user.getPassword(), password2);
        //��������������벻һ�£����ش�����Ϣ
        if(!twiceSamePassword){
            System.err.println("�û�ע���쳣��������������벻һ�£�");
            //�����û������б�
            model.addAttribute("user",user);
            //�����û���������
            model.addAttribute("password2",password2);
            //����������������벻һ�µ���Ϣ
            model.addAttribute("registerResult","������������벻һ�£�");
            return "main";
        }
        //�����û���ɫΪ��ͨ�û�
        user.setRole("��ͨ�û�");
        //������ݿ�������Ϣ
        try {
            new UserDao().add(user);
            System.out.println("�û�ע��ɹ�");
        }catch(Exception e) {
            System.err.println("�û�ע���쳣");
            e.printStackTrace();
        }
        //�����û������б�
        model.addAttribute("user",user);
        return "main";
    }
    
    /**
     * ִ�е�¼��������֤�û���������
     * @param user �û�ʵ����
     * @param model
     * @return
     */
    @RequestMapping("loginExit")
    public String loginExit(Model model) {
        System.out.print("\n�˳���¼��");
        //��յ�¼ʱ���û���
        UserUtil.username="δ��¼";
        UserUtil.subpage="��¼";
        //��յ�¼ʱ���û���ɫ
        UserUtil.userrole="null";
        return "main";
    }
	
    @RequestMapping("passwordUpdate")
    public String passwordUpdate(Password password, Model model) {
        User user = new UserDao().get(password.getUsername());
        //��ԭ������ȷ
        if(user.getPassword().equals(password.getPassword0())){
            user.setPassword(password.getPassword());
            new UserDao().update(user);
        }
        else{
            model.addAttribute("passwordUpdateResult", "ԭ���벻��ȷ");
        }
        model.addAttribute("password", password);
        return "main";
    }
    
    

}
