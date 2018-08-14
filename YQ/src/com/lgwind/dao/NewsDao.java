package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.News;
import com.lgwind.mapping.NewsMapperI;

public class NewsDao {
	
	//����sql�Ự
	SqlSession sqlSession;
	//��ȡmapper�ļ���Ϣ
	NewsMapperI mapper;

    public NewsDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * �û�����Ӳ���
     * @param user �û�ʵ����
     * @return ���ز������(int����)
     */
    public int add(News news) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�NewsMapperI�ӿڵ�ʵ�������NewsMapperI�ӿڵ�ʵ���������sqlSession.getMapper(NewsMapperI.class)��̬��������
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //ִ����Ӳ���
        int retResult = mapper.add(news);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û���ɾ������
     * @param username �û���
     * @return ���ز������(int����)
     */
    public int delete(int id) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�NewsMapperI�ӿڵ�ʵ�������NewsMapperI�ӿڵ�ʵ���������sqlSession.getMapper(NewsMapperI.class)��̬��������
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //ִ��ɾ������
        int retResult = mapper.delete(id);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û�����²���
     * @param user �û���ʵ����
     * @return ���ز������(int����)
     */
    public int update(News news) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�NewsMapperI�ӿڵ�ʵ�������NewsMapperI�ӿڵ�ʵ���������sqlSession.getMapper(NewsMapperI.class)��̬��������
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //ִ���޸Ĳ���
        int retResult = mapper.update(news);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * �û����ѯ����(Ĭ�ϲ�ѯ����)
     * @param username �û���
     * @return ���� �û���ʵ����
     */
    public News get(int id) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�NewsMapperI�ӿڵ�ʵ�������NewsMapperI�ӿڵ�ʵ���������sqlSession.getMapper(NewsMapperI.class)��̬��������
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��User����
        News news = mapper.get(id);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return news;
    }
    
    /**
     * �û����ѯ���в���(Ĭ�ϲ�ѯ����)
     * @return ���� �û���ʵ����list����
     */
    public List<News> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�NewsMapperI�ӿڵ�ʵ�������NewsMapperI�ӿڵ�ʵ���������sqlSession.getMapper(NewsMapperI.class)��̬��������
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        List<News> listNews = mapper.getAll("%");
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listNews;
    }
    
    /**
     * �û����ѯ���в���(���û�����ѯ)
     * @return ���� �û���ʵ����list����
     */
    public List<News> getAll(String itype) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�NewsMapperI�ӿڵ�ʵ�������NewsMapperI�ӿڵ�ʵ���������sqlSession.getMapper(NewsMapperI.class)��̬��������
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        String str="%";
        for(int i=0; i<itype.length();i++){
            str+=itype.charAt(i)+"%";
        }
        List<News> listNews = mapper.getAll(str);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listNews;
    }
    
    /**
     * �û����ѯ���в���(���û�����ѯ)
     * @return ���� �û���ʵ����list����
     */
    public List<News> getAllByUsername(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //�õ�NewsMapperI�ӿڵ�ʵ�������NewsMapperI�ӿڵ�ʵ���������sqlSession.getMapper(NewsMapperI.class)��̬��������
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        String str="%";
        for(int i=0; i<username.length();i++){
            str+=username.charAt(i)+"%";
        }
        List<News> listNews = mapper.getAllByUsername(str);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        return listNews;
    }

}
