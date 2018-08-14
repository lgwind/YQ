package com.lgwind.mapping;

import java.util.List;

import com.lgwind.domain.Data;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 定义用户表的sql映射接口，使用注解指明方法要执行的SQL语句
 * 
 * @author lgwind
 * 
 */
public interface DataMapperI {
	
	/**
	 * sql语句
	 */
	String insert = "insert into Data(username,company,position,icon,name,"
	        + "sex,phone,email,birthday,address,jwd) "
			+ "values(#{username},#{company},#{position},#{icon},#{name},"
			+ "#{sex},#{phone},#{email},#{birthday},#{address},#{jwd})";
	String delete = "delete from Data "
			+ "where username=#{username}";
	String update = "update Data set company=#{company}, position=#{position}, icon=#{icon}, "
	        + "name=#{name}, sex=#{sex}, phone=#{phone}, "
	        + "email=#{email}, birthday=#{birthday}, address=#{address}, jwd=#{jwd} "
			+ "where username=#{username}";
	String select = "select * from Data "
			+ "where username=#{username}";
	String selectAll = "select * from Data where username like #{username}";
    String selectAllByCompany = "select * from Data where company like #{company}";

	// 使用@Insert注解指明add方法要执行的SQL
	@Insert(insert)
    public int add(Data data);

	// 使用@Delete注解指明deleteById方法要执行的SQL
	@Delete(delete)
    public int delete(String username);

	// 使用@Update注解指明update方法要执行的SQL
	@Update(update)
    public int update(Data data);

	// 使用@Select注解指明getById方法要执行的SQL
	@Select(select)
    public Data get(String username);

	// 使用@Select注解指明getAll方法要执行的SQL
	@Select(selectAll)
    public List<Data> getAll(String username);
	
	// 使用@Select注解指明getAll方法要执行的SQL
    @Select(selectAllByCompany)
    public List<Data> getAllByCompany(String company);
}