package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.AD;
import com.lgwind.mapping.ADMapperI;

public class ADDao {
	
	//创建sql会话
	SqlSession sqlSession;
	//获取mapper文件信息
	ADMapperI mapper;

    public ADDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 考勤表添加操作
     * @param ad 用户实体类
     * @return 返回操作结果(int数据)
     */
    public int add(AD ad) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到ADMapperI接口的实现类对象，ADMapperI接口的实现类对象由sqlSession.getMapper(ADMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(ADMapperI.class);
        //执行添加操作
        int retResult = mapper.add(ad);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 考勤表删除操作
     * @param ad 考勤类实体
     * @return 返回操作结果(int数据)
     */
    public int delete(AD ad) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到ADMapperI接口的实现类对象，ADMapperI接口的实现类对象由sqlSession.getMapper(ADMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(ADMapperI.class);
        //执行删除操作
        int retResult = mapper.delete(ad);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    /**
     * 考勤表删除操作
     * @param username 用户名
     * @return 返回操作结果(int数据)
     */
    public int delete(String username, String adTime) {
        AD ad = new AD();
        ad.setUsername(username);
        ad.setAdTime(adTime);
        return delete(ad);
    }
    
    /**
     * 考勤表更新操作
     * @param AD 考勤表实体类
     * @return 返回操作结果(int数据)
     */
    public int update(AD ad) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到ADMapperI接口的实现类对象，ADMapperI接口的实现类对象由sqlSession.getMapper(ADMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(ADMapperI.class);
        //执行修改操作
        int retResult = mapper.update(ad);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 考勤表查询操作(默认查询所有)
     * @param username 用户名
     * @return 返回 考勤表实体类
     */
    public AD get(AD ad) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到ADMapperI接口的实现类对象，ADMapperI接口的实现类对象由sqlSession.getMapper(ADMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(ADMapperI.class);
        //执行查询操作，将查询结果自动封装成AD返回
        AD adReturn = mapper.get(ad);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return adReturn;
    }
    
    /**
     * 考勤表查询操作(默认查询所有)
     * @param username 用户名
     * @return 返回 考勤表实体类
     */
    public AD get(String username, String adTime) {
        AD ad = new AD();
        ad.setUsername(username);
        ad.setAdTime(adTime);    
        return get(ad);
    }
    
    /**
     * 考勤表查询多行操作(默认查询所有)
     * @return 返回 考勤表实体类list集合
     */
    public List<AD> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到ADMapperI接口的实现类对象，ADMapperI接口的实现类对象由sqlSession.getMapper(ADMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(ADMapperI.class);
        //执行查询操作，将查询结果自动封装成List<AD>返回
        List<AD> listAD = mapper.getAll("%");
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listAD;
    }
    
    /**
     * 考勤表查询多行操作(按用户名查询)
     * @return 返回 考勤表实体类list集合
     */
    public List<AD> getAll(String username) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到ADMapperI接口的实现类对象，ADMapperI接口的实现类对象由sqlSession.getMapper(ADMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(ADMapperI.class);
        //执行查询操作，将查询结果自动封装成List<AD>返回
        String str="%";
        for(int i=0; i<username.length();i++){
            str+=username.charAt(i)+"%";
        }
        List<AD> listAD = mapper.getAll(str);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listAD;
    }

}
