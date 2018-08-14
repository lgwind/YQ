package com.lgwind.util;

import java.util.List;

import com.lgwind.dao.UserDao;
import com.lgwind.domain.User;

public class UserUtil {
	
	public static String username="��û�����û���Ŷ~";//��¼ʱ������û�������ʱ����
	public static String userrole="��û�����û���ɫŶ~";//��¼ʱ������û���ɫ����ʱ����
	
	public static String page="null";//��ǰҳ�棬��ʱ����
	public static String subpage="null";//��ǰҳ����ҳ�棬��ʱ����
	
	private static String usernameSuper="Lgwind";//�����û����û���
	private static String passwordSuper="11111";//�����û�������
	
	/**
	 * ��֤�Ƿ���ϵͳ�����û�
	 * @param user ��¼���û���Ϣʵ����
	 * @return
	 */
	public static boolean isSuperUser(User user) {
		//���ǳ����û����û���
		if(user.getUsername().equals(usernameSuper)) {
			//���ǳ����û�������
			if(user.getPassword().equals(passwordSuper)) {
				//ȷ����ϵͳ�����û�
				return true;
			}
		}
		//��֤���ֲ���ϵͳ�����û�
		return false;
	}
	
	/**
	 * ��֤�û����Ƿ����
	 * @param username �û���
	 * @return
	 */
	public static boolean isExitName(String username) {
		//��ȡ�û����������Ϣ
		List<User> listUser = new UserDao().getAll();
		//�����û���������Ϣ���ж��Ƿ��д��û���
		String username_temp="";//��ʱ�û���
//		System.out.println(username);
		for(int i=0; i<listUser.size(); i++) {
			username_temp=listUser.get(i).getUsername();
//			System.out.println("username_temp="+username_temp);
			//���û����д�����ͬ���û������򷵻�true
			if(username.equals(username_temp)) {
				return true;
			}
		}
		//���û����в�������ͬ���û������򷵻�false
		return false;
	}
	
	/**
	 * ��֤�����Ƿ���ȷ
	 * @param user ��¼���û���Ϣʵ����
	 * @return
	 */
	public static boolean isTruePassword(User user) {
		//��ȡ���ݿ��д��û�����Ӧ��ʵ������Ϣ
		User user_temp=new UserDao().get(user.getUsername());
		if(user_temp.getPassword().equals(user.getPassword())) {
			//��������ͬ���򷵻�true
			return true;
		}
		//�����벻ͬ���򷵻�false
		return false;
	}
	
	/**
	 * �����û�����Ӧ�Ľ�ɫ���
	 * @param username
	 * @return
	 */
	public static String roleIS(String username) {
		//��ȡ���ݿ��д��û�����Ӧ��ʵ������Ϣ
		User user_temp=new UserDao().get(username);
		//���ش��û����Ľ�ɫ���
		return user_temp.getRole();
	}

	/**
	 * ��������Ա�������get() 
	 * @return
	 */
	public static String getPasswordSuper() {
		return passwordSuper;
	}

	/**
	 * ��������Ա�������set()
	 * @param passwordSuper
	 */
	public static void setPasswordSuper(String passwordSuper) {
		UserUtil.passwordSuper = passwordSuper;
	}
	
	/**
	 * ��֤��������������Ƿ�һ��
	 * @param password
	 * @param password2
	 * @return
	 */
	public static boolean isTwiceSamePassword(String password, String password2){
	    if(password.equals(password2)){
	        return true;
	    }
	    return false;
	}	

}
