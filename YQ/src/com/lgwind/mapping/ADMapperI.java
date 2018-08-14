package com.lgwind.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lgwind.domain.AD;

/**
 * 定义考勤表的sql映射接口，使用注解指明方法要执行的SQL语句
 * 
 * @author lgwind
 * 
 */
public interface ADMapperI {
	
	/**
	 * sql语句
	 */
	String insert = "insert into ad(username,ad_time,jd,wd,jw_name,scope,time,status) "
			+ "values(#{username},#{adTime},#{jd},#{wd},#{jwName},#{scope},#{time},#{status})";
	String delete = "delete from ad "
			+ "where username=#{username} and ad_time=#{adTime}";
	String update = "update ad set jd=#{jd},wd=#{wd},jw_name=#{jwName},scope=#{scope},time=#{time},status=#{status} "
			+ "where username=#{username} and ad_time=#{adTime}";
	String select = "select * from ad "
			+ "where username=#{username} and ad_time=#{adTime}";
	String selectAll = "select * from ad where username like #{username}";

	// 使用@Insert注解指明add方法要执行的SQL
	@Insert(insert)
    public int add(AD ad);

	// 使用@Delete注解指明deleteById方法要执行的SQL
	@Delete(delete)
    public int delete(AD ad);

	// 使用@Update注解指明update方法要执行的SQL
	@Update(update)
    public int update(AD ad);

	// 使用@Select注解指明getById方法要执行的SQL
	@Select(select)
    @Results({@Result(property = "adTime", column = "ad_time"),
              @Result(property = "jwName", column = "jw_name")})
    public AD get(AD ad);

	// 使用@Select注解指明getAll方法要执行的SQL
	@Select(selectAll)
    @Results({@Result(property = "adTime", column = "ad_time"),
              @Result(property = "jwName", column = "jw_name")})
    public List<AD> getAll(String username);
}