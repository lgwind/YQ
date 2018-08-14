package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.Company;
import com.lgwind.mapping.CompanyMapperI;

public class CompanyDao {
	
	//����sql�Ự
	SqlSession sqlSession;
	//��ȡmapper�ļ���Ϣ
	CompanyMapperI mapper;

    public CompanyDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * �û�����Ӳ���
     * @param company �û�ʵ����
     * @return ���ز������(int����)
     */
    public int add(Company company) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�CompanyMapperI�ӿڵ�ʵ�������CompanyMapperI�ӿڵ�ʵ���������sqlSession.getMapper(CompanyMapperI.class)��̬��������
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //ִ����Ӳ���
        int retResult = mapper.add(company);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û���ɾ������
     * @param Companyname �û���
     * @return ���ز������(int����)
     */
    public int delete(String companyName) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�CompanyMapperI�ӿڵ�ʵ�������CompanyMapperI�ӿڵ�ʵ���������sqlSession.getMapper(CompanyMapperI.class)��̬��������
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //ִ��ɾ������
        int retResult = mapper.delete(companyName);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û�����²���
     * @param Company �û���ʵ����
     * @return ���ز������(int����)
     */
    public int update(Company company) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�CompanyMapperI�ӿڵ�ʵ�������CompanyMapperI�ӿڵ�ʵ���������sqlSession.getMapper(CompanyMapperI.class)��̬��������
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //ִ���޸Ĳ���
        int retResult = mapper.update(company);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û����ѯ����(Ĭ�ϲ�ѯ����)
     * @param Companyname �û���
     * @return ���� �û���ʵ����
     */
    public Company get(String companyName) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�CompanyMapperI�ӿڵ�ʵ�������CompanyMapperI�ӿڵ�ʵ���������sqlSession.getMapper(CompanyMapperI.class)��̬��������
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��Company����
        Company company = mapper.get(companyName);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return company;
    }
    
    /**
     * �û����ѯ���в���(Ĭ�ϲ�ѯ����)
     * @return ���� �û���ʵ����list����
     */
    public List<Company> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�CompanyMapperI�ӿڵ�ʵ�������CompanyMapperI�ӿڵ�ʵ���������sqlSession.getMapper(CompanyMapperI.class)��̬��������
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<Company>����
        List<Company> listCompany = mapper.getAll("%");
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listCompany;
    }
    
    /**
     * �û����ѯ���в���(���û�����ѯ)
     * @return ���� �û���ʵ����list����
     */
    public List<Company> getAll(String companyName) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�CompanyMapperI�ӿڵ�ʵ�������CompanyMapperI�ӿڵ�ʵ���������sqlSession.getMapper(CompanyMapperI.class)��̬��������
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<Company>����
        String str="%";
        for(int i=0; i<companyName.length();i++){
            str+=companyName.charAt(i)+"%";
        }
        List<Company> listCompany = mapper.getAll(str);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listCompany;
    }

}
