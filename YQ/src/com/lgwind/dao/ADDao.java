package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.AD;
import com.lgwind.mapping.ADMapperI;

public class ADDao {
	
	//����sql�Ự
	SqlSession sqlSession;
	//��ȡmapper�ļ���Ϣ
	ADMapperI mapper;

    public ADDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * ���ڱ���Ӳ���
     * @param ad �û�ʵ����
     * @return ���ز������(int����)
     */
    public int add(AD ad) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�ADMapperI�ӿڵ�ʵ�������ADMapperI�ӿڵ�ʵ���������sqlSession.getMapper(ADMapperI.class)��̬��������
        mapper = sqlSession.getMapper(ADMapperI.class);
        //ִ����Ӳ���
        int retResult = mapper.add(ad);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * ���ڱ�ɾ������
     * @param ad ������ʵ��
     * @return ���ز������(int����)
     */
    public int delete(AD ad) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�ADMapperI�ӿڵ�ʵ�������ADMapperI�ӿڵ�ʵ���������sqlSession.getMapper(ADMapperI.class)��̬��������
        mapper = sqlSession.getMapper(ADMapperI.class);
        //ִ��ɾ������
        int retResult = mapper.delete(ad);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    /**
     * ���ڱ�ɾ������
     * @param username �û���
     * @return ���ز������(int����)
     */
    public int delete(String username, String adTime) {
        AD ad = new AD();
        ad.setUsername(username);
        ad.setAdTime(adTime);
        return delete(ad);
    }
    
    /**
     * ���ڱ���²���
     * @param AD ���ڱ�ʵ����
     * @return ���ز������(int����)
     */
    public int update(AD ad) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�ADMapperI�ӿڵ�ʵ�������ADMapperI�ӿڵ�ʵ���������sqlSession.getMapper(ADMapperI.class)��̬��������
        mapper = sqlSession.getMapper(ADMapperI.class);
        //ִ���޸Ĳ���
        int retResult = mapper.update(ad);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * ���ڱ��ѯ����(Ĭ�ϲ�ѯ����)
     * @param username �û���
     * @return ���� ���ڱ�ʵ����
     */
    public AD get(AD ad) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�ADMapperI�ӿڵ�ʵ�������ADMapperI�ӿڵ�ʵ���������sqlSession.getMapper(ADMapperI.class)��̬��������
        mapper = sqlSession.getMapper(ADMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��AD����
        AD adReturn = mapper.get(ad);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return adReturn;
    }
    
    /**
     * ���ڱ��ѯ����(Ĭ�ϲ�ѯ����)
     * @param username �û���
     * @return ���� ���ڱ�ʵ����
     */
    public AD get(String username, String adTime) {
        AD ad = new AD();
        ad.setUsername(username);
        ad.setAdTime(adTime);    
        return get(ad);
    }
    
    /**
     * ���ڱ��ѯ���в���(Ĭ�ϲ�ѯ����)
     * @return ���� ���ڱ�ʵ����list����
     */
    public List<AD> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�ADMapperI�ӿڵ�ʵ�������ADMapperI�ӿڵ�ʵ���������sqlSession.getMapper(ADMapperI.class)��̬��������
        mapper = sqlSession.getMapper(ADMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<AD>����
        List<AD> listAD = mapper.getAll("%");
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listAD;
    }
    
    /**
     * ���ڱ��ѯ���в���(���û�����ѯ)
     * @return ���� ���ڱ�ʵ����list����
     */
    public List<AD> getAll(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�ADMapperI�ӿڵ�ʵ�������ADMapperI�ӿڵ�ʵ���������sqlSession.getMapper(ADMapperI.class)��̬��������
        mapper = sqlSession.getMapper(ADMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<AD>����
        String str="%";
        for(int i=0; i<username.length();i++){
            str+=username.charAt(i)+"%";
        }
        List<AD> listAD = mapper.getAll(str);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listAD;
    }

}
