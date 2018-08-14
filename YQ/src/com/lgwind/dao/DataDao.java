package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.Data;
import com.lgwind.mapping.DataMapperI;

public class DataDao {
	
	//����sql�Ự
	SqlSession sqlSession;
	//��ȡmapper�ļ���Ϣ
	DataMapperI mapper;

    public DataDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * �û�����Ӳ���
     * @param data �û�ʵ����
     * @return ���ز������(int����)
     */
    public int add(Data data) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�DataMapperI�ӿڵ�ʵ�������DataMapperI�ӿڵ�ʵ���������sqlSession.getMapper(DataMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DataMapperI.class);
        //ִ����Ӳ���
        int retResult = mapper.add(data);
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
        //�õ�DataMapperI�ӿڵ�ʵ�������DataMapperI�ӿڵ�ʵ���������sqlSession.getMapper(DataMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DataMapperI.class);
        //ִ��ɾ������
        int retResult = mapper.delete(username);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û�����²���
     * @param data �û���ʵ����
     * @return ���ز������(int����)
     */
    public int update(Data data) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�DataMapperI�ӿڵ�ʵ�������DataMapperI�ӿڵ�ʵ���������sqlSession.getMapper(DataMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DataMapperI.class);
        //ִ���޸Ĳ���
        int retResult = mapper.update(data);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û����ѯ����(Ĭ�ϲ�ѯ����)
     * @param username �û���
     * @return ���� �û���ʵ����
     */
    public Data get(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�DataMapperI�ӿڵ�ʵ�������DataMapperI�ӿڵ�ʵ���������sqlSession.getMapper(DataMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DataMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��Data����
        Data Data = mapper.get(username);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return Data;
    }
    
    /**
     * �û����ѯ���в���(Ĭ�ϲ�ѯ����)
     * @return ���� �û���ʵ����list����
     */
    public List<Data> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�DataMapperI�ӿڵ�ʵ�������DataMapperI�ӿڵ�ʵ���������sqlSession.getMapper(DataMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DataMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<Data>����
        List<Data> listData = mapper.getAll("%");
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listData;
    }
    
    /**
     * �û����ѯ���в���(���û�����ѯ)
     * @return ���� �û���ʵ����list����
     */
    public List<Data> getAll(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�DataMapperI�ӿڵ�ʵ�������DataMapperI�ӿڵ�ʵ���������sqlSession.getMapper(DataMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DataMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<Data>����
        String str="%";
        for(int i=0; i<username.length();i++){
            str+=username.charAt(i)+"%";
        }
        List<Data> listData = mapper.getAll(str);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listData;
    }
    
    /**
     * �û����ѯ���в���(���û�����ѯ)
     * @return ���� �û���ʵ����list����
     */
    public List<Data> getAllByCompany(String company) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�DataMapperI�ӿڵ�ʵ�������DataMapperI�ӿڵ�ʵ���������sqlSession.getMapper(DataMapperI.class)��̬��������
        mapper = sqlSession.getMapper(DataMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<Data>����
        String str="%";
        for(int i=0; i<company.length();i++){
            str+=company.charAt(i)+"%";
        }
        List<Data> listData = mapper.getAllByCompany(str);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listData;
    }

}
