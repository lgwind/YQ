package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.Data;
import com.lgwind.mapping.DataMapperI;

public class DataDao {
	
	//创建sql会话
	SqlSession sqlSession;
	//获取mapper文件信息
	DataMapperI mapper;

    public DataDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 用户表添加操作
     * @param data 用户实体类
     * @return 返回操作结果(int数据)
     */
    public int add(Data data) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到DataMapperI接口的实现类对象，DataMapperI接口的实现类对象由sqlSession.getMapper(DataMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DataMapperI.class);
        //执行添加操作
        int retResult = mapper.add(data);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表删除操作
     * @param username 用户名
     * @return 返回操作结果(int数据)
     */
    public int delete(String username) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到DataMapperI接口的实现类对象，DataMapperI接口的实现类对象由sqlSession.getMapper(DataMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DataMapperI.class);
        //执行删除操作
        int retResult = mapper.delete(username);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表更新操作
     * @param data 用户表实体类
     * @return 返回操作结果(int数据)
     */
    public int update(Data data) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到DataMapperI接口的实现类对象，DataMapperI接口的实现类对象由sqlSession.getMapper(DataMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DataMapperI.class);
        //执行修改操作
        int retResult = mapper.update(data);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表查询操作(默认查询所有)
     * @param username 用户名
     * @return 返回 用户表实体类
     */
    public Data get(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到DataMapperI接口的实现类对象，DataMapperI接口的实现类对象由sqlSession.getMapper(DataMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DataMapperI.class);
        //执行查询操作，将查询结果自动封装成Data返回
        Data Data = mapper.get(username);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return Data;
    }
    
    /**
     * 用户表查询多行操作(默认查询所有)
     * @return 返回 用户表实体类list集合
     */
    public List<Data> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到DataMapperI接口的实现类对象，DataMapperI接口的实现类对象由sqlSession.getMapper(DataMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DataMapperI.class);
        //执行查询操作，将查询结果自动封装成List<Data>返回
        List<Data> listData = mapper.getAll("%");
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listData;
    }
    
    /**
     * 用户表查询多行操作(按用户名查询)
     * @return 返回 用户表实体类list集合
     */
    public List<Data> getAll(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到DataMapperI接口的实现类对象，DataMapperI接口的实现类对象由sqlSession.getMapper(DataMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DataMapperI.class);
        //执行查询操作，将查询结果自动封装成List<Data>返回
        String str="%";
        for(int i=0; i<username.length();i++){
            str+=username.charAt(i)+"%";
        }
        List<Data> listData = mapper.getAll(str);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listData;
    }
    
    /**
     * 用户表查询多行操作(按用户名查询)
     * @return 返回 用户表实体类list集合
     */
    public List<Data> getAllByCompany(String company) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到DataMapperI接口的实现类对象，DataMapperI接口的实现类对象由sqlSession.getMapper(DataMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(DataMapperI.class);
        //执行查询操作，将查询结果自动封装成List<Data>返回
        String str="%";
        for(int i=0; i<company.length();i++){
            str+=company.charAt(i)+"%";
        }
        List<Data> listData = mapper.getAllByCompany(str);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listData;
    }

}
