package com.lgwind.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lgwind.domain.Company;
import com.lgwind.mapping.CompanyMapperI;

public class CompanyDao {
	
	//创建sql会话
	SqlSession sqlSession;
	//获取mapper文件信息
	CompanyMapperI mapper;

    public CompanyDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 用户表添加操作
     * @param company 用户实体类
     * @return 返回操作结果(int数据)
     */
    public int add(Company company) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到CompanyMapperI接口的实现类对象，CompanyMapperI接口的实现类对象由sqlSession.getMapper(CompanyMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //执行添加操作
        int retResult = mapper.add(company);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表删除操作
     * @param Companyname 用户名
     * @return 返回操作结果(int数据)
     */
    public int delete(String companyName) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到CompanyMapperI接口的实现类对象，CompanyMapperI接口的实现类对象由sqlSession.getMapper(CompanyMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //执行删除操作
        int retResult = mapper.delete(companyName);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表更新操作
     * @param Company 用户表实体类
     * @return 返回操作结果(int数据)
     */
    public int update(Company company) {
        sqlSession = MyBatisUtil.getSqlSession(true);
        //得到CompanyMapperI接口的实现类对象，CompanyMapperI接口的实现类对象由sqlSession.getMapper(CompanyMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //执行修改操作
        int retResult = mapper.update(company);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return retResult;
    }
    
    /**
     * 用户表查询操作(默认查询所有)
     * @param Companyname 用户名
     * @return 返回 用户表实体类
     */
    public Company get(String companyName) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到CompanyMapperI接口的实现类对象，CompanyMapperI接口的实现类对象由sqlSession.getMapper(CompanyMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //执行查询操作，将查询结果自动封装成Company返回
        Company company = mapper.get(companyName);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return company;
    }
    
    /**
     * 用户表查询多行操作(默认查询所有)
     * @return 返回 用户表实体类list集合
     */
    public List<Company> getAll() {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到CompanyMapperI接口的实现类对象，CompanyMapperI接口的实现类对象由sqlSession.getMapper(CompanyMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //执行查询操作，将查询结果自动封装成List<Company>返回
        List<Company> listCompany = mapper.getAll("%");
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listCompany;
    }
    
    /**
     * 用户表查询多行操作(按用户名查询)
     * @return 返回 用户表实体类list集合
     */
    public List<Company> getAll(String companyName) {
        sqlSession = MyBatisUtil.getSqlSession();
        //得到CompanyMapperI接口的实现类对象，CompanyMapperI接口的实现类对象由sqlSession.getMapper(CompanyMapperI.class)动态构建出来
        mapper = sqlSession.getMapper(CompanyMapperI.class);
        //执行查询操作，将查询结果自动封装成List<Company>返回
        String str="%";
        for(int i=0; i<companyName.length();i++){
            str+=companyName.charAt(i)+"%";
        }
        List<Company> listCompany = mapper.getAll(str);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        return listCompany;
    }

}
