package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.User;
import com.lgwind.mapping.UserMapperI;

public class UserDao {
	
	//����sql�Ự
	SqlSession sqlSession;
	//��ȡmapper�ļ���Ϣ
	UserMapperI mapper;

    public UserDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * �û�����Ӳ���
     * @param user �û�ʵ����
     * @return ���ز������(int����)
     */
    public int add(User user) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(UserMapperI.class);
        //ִ����Ӳ���
        int retResult = mapper.add(user);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û���ɾ������
     * @param username �û���
     * @return ���ز������(int����)
     */
    public int delete(String username) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(UserMapperI.class);
        //ִ��ɾ������
        int retResult = mapper.delete(username);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û�����²���
     * @param user �û���ʵ����
     * @return ���ز������(int����)
     */
    public int update(User user) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(UserMapperI.class);
        //ִ���޸Ĳ���
        int retResult = mapper.update(user);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û����ѯ����(Ĭ�ϲ�ѯ����)
     * @param username �û���
     * @return ���� �û���ʵ����
     */
    public User get(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(UserMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��User����
        User user = mapper.get(username);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return user;
    }
    
    /**
     * �û����ѯ���в���(Ĭ�ϲ�ѯ����)
     * @return ���� �û���ʵ����list����
     */
    public List<User> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(UserMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        List<User> listUser = mapper.getAll("%");
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listUser;
    }
    
    /**
     * �û����ѯ���в���(���û�����ѯ)
     * @return ���� �û���ʵ����list����
     */
    public List<User> getAll(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
        mapper = sqlSession.getMapper(UserMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        String str="%";
        for(int i=0; i<username.length();i++){
            str+=username.charAt(i)+"%";
        }
        List<User> listUser = mapper.getAll(str);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listUser;
    }

}
