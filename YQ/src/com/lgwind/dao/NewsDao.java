package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.News;
import com.lgwind.mapping.NewsMapperI;

public class NewsDao {
	
	//创建sql会话
	SqlSession sqlSession;
	//获取mapper文件信息
	NewsMapperI mapper;

    public NewsDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 用户表添加操作
     * @param user 用户实体类
     * @return 返回操作结果(int数据)
     */
    public int add(News news) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到NewsMapperI接口的实现类对象，NewsMapperI接口的实现类对象由sqlSession.getMapper(NewsMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //执行添加操作
        int retResult = mapper.add(news);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表删除操作
     * @param username 用户名
     * @return 返回操作结果(int数据)
     */
    public int delete(int id) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到NewsMapperI接口的实现类对象，NewsMapperI接口的实现类对象由sqlSession.getMapper(NewsMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //执行删除操作
        int retResult = mapper.delete(id);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表更新操作
     * @param user 用户表实体类
     * @return 返回操作结果(int数据)
     */
    public int update(News news) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到NewsMapperI接口的实现类对象，NewsMapperI接口的实现类对象由sqlSession.getMapper(NewsMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //执行修改操作
        int retResult = mapper.update(news);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表查询操作(默认查询所有)
     * @param username 用户名
     * @return 返回 用户表实体类
     */
    public News get(int id) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到NewsMapperI接口的实现类对象，NewsMapperI接口的实现类对象由sqlSession.getMapper(NewsMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //执行查询操作，将查询结果自动封装成User返回
        News news = mapper.get(id);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return news;
    }
    
    /**
     * 用户表查询多行操作(默认查询所有)
     * @return 返回 用户表实体类list集合
     */
    public List<News> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到NewsMapperI接口的实现类对象，NewsMapperI接口的实现类对象由sqlSession.getMapper(NewsMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<News> listNews = mapper.getAll("%");
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listNews;
    }
    
    /**
     * 用户表查询多行操作(按用户名查询)
     * @return 返回 用户表实体类list集合
     */
    public List<News> getAll(String itype) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到NewsMapperI接口的实现类对象，NewsMapperI接口的实现类对象由sqlSession.getMapper(NewsMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        String str="%";
        for(int i=0; i<itype.length();i++){
            str+=itype.charAt(i)+"%";
        }
        List<News> listNews = mapper.getAll(str);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listNews;
    }
    
    /**
     * 用户表查询多行操作(按用户名查询)
     * @return 返回 用户表实体类list集合
     */
    public List<News> getAllByUsername(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到NewsMapperI接口的实现类对象，NewsMapperI接口的实现类对象由sqlSession.getMapper(NewsMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(NewsMapperI.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        String str="%";
        for(int i=0; i<username.length();i++){
            str+=username.charAt(i)+"%";
        }
        List<News> listNews = mapper.getAllByUsername(str);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listNews;
    }

}
