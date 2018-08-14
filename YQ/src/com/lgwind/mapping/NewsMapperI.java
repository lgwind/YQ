package com.lgwind.mapping;

import java.util.List;

import com.lgwind.domain.News;

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
public interface NewsMapperI {
	
	/**
	 * sql语句
	 */
	String insert = "insert into news(id,itype,company,username,reason,time,finish) "
			+ "values(#{id},#{itype},#{company},#{username},#{reason},#{time},#{finish})";
	String delete = "delete from news "
			+ "where id=#{id}";
	String update = "update news set itype=#{itype},company=#{company},username=#{username},reason=#{reason},time=#{time},finish=#{finish} "
			+ "where id=#{id}";
	String select = "select * from news "
			+ "where id=#{id}";
	String selectAll = "select * from news where itype like #{itype}";
    String selectAllByUsername = "select * from news where username like #{username}";

	// 使用@Insert注解指明add方法要执行的SQL
	@Insert(insert)
    public int add(News news);

	// 使用@Delete注解指明deleteById方法要执行的SQL
	@Delete(delete)
    public int delete(int id);

	// 使用@Update注解指明update方法要执行的SQL
	@Update(update)
    public int update(News news);

	// 使用@Select注解指明getById方法要执行的SQL
	@Select(select)
    public News get(int id);

	// 使用@Select注解指明getAll方法要执行的SQL
	@Select(selectAll)
    public List<News> getAll(String itype);
	
	// 使用@Select注解指明getAll方法要执行的SQL
    @Select(selectAllByUsername)
    public List<News> getAllByUsername(String username);
}