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
     * 执行登录操作，验证用户名和密码
     * @param user 用户实体类
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(User user, Model model) {
        System.out.print("\n进行用户登录操作：");
        //清空登录时的用户名
        UserUtil.username="未登录";
        //清空登录时的用户角色
        UserUtil.userrole="null";
        
        //验证是否是系统超级用户
        boolean superUser=UserUtil.isSuperUser(user);
        //若是超级用户，则设置登录角色为超级管理员，进入用户后台界面
        if (superUser) {
            //保存登录时的用户名
            UserUtil.username=user.getUsername();
            //保存登录时的用户角色
            UserUtil.userrole="超级管理员";
            System.out.print("登录成功\n");
            return "main";
        }
        
        //验证用户名是否存在
        boolean exit = UserUtil.isExitName(user.getUsername());
        //若用户名不存在，则返回登录页面重新登录
        if (!exit) {            
            //将此用户实体类传回去
            model.addAttribute("user",user);
            //将用户名不存在的信息传回去
            if(user.getUsername().equals("")) {
                model.addAttribute("loginResult","输入的用户名为空，请重新输入！！！");
            }else {
                model.addAttribute("loginResult","该用户名不存在，请重新输入！！！");
            }
            System.out.print("登录失败\n");
            return "main";
        }
        
        //验证密码是否正确
        boolean truePassword=UserUtil.isTruePassword(user);
        //若密码不正确，则返回登录页面重新登录
        if(!truePassword) {         
            //将此用户实体类传回去
            model.addAttribute("user",user);
            //将秘密输入错误的信息传回去
            if(user.getPassword().equals("")) {
                model.addAttribute("loginResult","输入的密码为空，请重新输入！！！");
            }else {
                model.addAttribute("loginResult","密码输入错误，请重新输入！！！");
            }
            System.out.print("登录失败\n");
            return "main";
        }
        
        //验证用户角色身份
        String role = UserUtil.roleIS(user.getUsername());
        //若角色身份是管理员，则设置登录角色为管理员，进入后台界面
        if(role.equals("管理员")) {
            //保存登录时的用户名
            UserUtil.username=user.getUsername();
            //保存登录时的用户角色
            UserUtil.userrole="管理员";
            System.out.print("登录成功\n");
            return "main";
        }
        //若角色身份是企业管理员，则设置登录角色为企业管理员，进入后台界面
        if(role.equals("企业管理员")) {
            //保存登录时的用户名
            UserUtil.username=user.getUsername();
            //保存登录时的用户角色
            UserUtil.userrole="企业管理员";
            System.out.print("登录成功\n");
            return "main";
        }
        //若角色身份是普通用户，则设置登录角色为普通用户，进入后台界面
        //保存登录时的用户名
        UserUtil.username=user.getUsername();
        //保存登录时的用户角色
        UserUtil.userrole="普通用户";
        System.out.print("登录成功\n");
        return "main";
    }
	
    /**
     * 进行普通用户注册操作
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("register")
    public String register(User user,String password2, Model model) {
        System.out.print("\n进行普通用户注册操作：");
        //清空登录时的用户名
        UserUtil.username="未登录";
        //清空登录时的用户角色
        UserUtil.userrole="null";
        //验证用户名是否存在
        boolean exit = UserUtil.isExitName(user.getUsername());
        //若用户名已存在，返回错误信息
        if(exit){
            System.err.println("该用户名已存在！");
            //返回用户数据列表
            model.addAttribute("user",user);
            //返回用户二次密码
            model.addAttribute("password2",password2);
            //返回该用户名已存在的信息
            model.addAttribute("registerResult","该用户名已存在！");
            return "main";            
        }
        //若用户名为空，返回错误信息
        if(user.getUsername().equals("")) {
            System.err.println("用户名为空！");
            //返回用户数据列表
            model.addAttribute("user",user);
            //返回用户二次密码
            model.addAttribute("password2",password2);
            //返回用户名为空的信息
            model.addAttribute("registerResult","用户名为空！");
            return "main";            
        }
        //若密码为空，则返回错误信息
        if(user.getPassword().equals("")) {
            System.err.println("密码为空！");
            //返回用户数据列表
            model.addAttribute("user",user);
            //返回用户二次密码
            model.addAttribute("password2",password2);
            //返回密码为空的信息
            model.addAttribute("registerResult","密码为空！");
            return "main";            
        }
        //若确认密码为空，则返回错误信息
        if(password2.equals("")) {
            System.err.println("确认密码为空！");
            //返回用户数据列表
            model.addAttribute("user",user);
            //返回用户二次密码
            model.addAttribute("password2",password2);
            //返回密码为空的信息
            model.addAttribute("registerResult","确认密码为空！");
            return "main";            
        }
        //验证两次输入的密码是否一致
        boolean twiceSamePassword = UserUtil.isTwiceSamePassword(user.getPassword(), password2);
        //若两次输入的密码不一致，返回错误信息
        if(!twiceSamePassword){
            System.err.println("用户注册异常：两次输入的密码不一致！");
            //返回用户数据列表
            model.addAttribute("user",user);
            //返回用户二次密码
            model.addAttribute("password2",password2);
            //返回两次输入的密码不一致的信息
            model.addAttribute("registerResult","两次输入的密码不一致！");
            return "main";
        }
        //设置用户角色为普通用户
        user.setRole("普通用户");
        //添加数据库数据信息
        try {
            new UserDao().add(user);
            System.out.println("用户注册成功");
        }catch(Exception e) {
            System.err.println("用户注册异常");
            e.printStackTrace();
        }
        //返回用户数据列表
        model.addAttribute("user",user);
        return "main";
    }
    
    /**
     * 执行登录操作，验证用户名和密码
     * @param user 用户实体类
     * @param model
     * @return
     */
    @RequestMapping("loginExit")
    public String loginExit(Model model) {
        System.out.print("\n退出登录！");
        //清空登录时的用户名
        UserUtil.username="未登录";
        UserUtil.subpage="登录";
        //清空登录时的用户角色
        UserUtil.userrole="null";
        return "main";
    }
	
    @RequestMapping("passwordUpdate")
    public String passwordUpdate(Password password, Model model) {
        User user = new UserDao().get(password.getUsername());
        //若原密码正确
        if(user.getPassword().equals(password.getPassword0())){
            user.setPassword(password.getPassword());
            new UserDao().update(user);
        }
        else{
            model.addAttribute("passwordUpdateResult", "原密码不正确");
        }
        model.addAttribute("password", password);
        return "main";
    }
    
    

}
