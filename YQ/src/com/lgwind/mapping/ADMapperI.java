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
 * ���忼�ڱ��sqlӳ��ӿڣ�ʹ��ע��ָ������Ҫִ�е�SQL���
 * 
 * @author lgwind
 * 
 */
public interface ADMapperI {
	
	/**
	 * sql���
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

	// ʹ��@Insertע��ָ��add����Ҫִ�е�SQL
	@Insert(insert)
    public int add(AD ad);

	// ʹ��@Deleteע��ָ��deleteById����Ҫִ�е�SQL
	@Delete(delete)
    public int delete(AD ad);

	// ʹ��@Updateע��ָ��update����Ҫִ�е�SQL
	@Update(update)
    public int update(AD ad);

	// ʹ��@Selectע��ָ��getById����Ҫִ�е�SQL
	@Select(select)
    @Results({@Result(property = "adTime", column = "ad_time"),
              @Result(property = "jwName", column = "jw_name")})
    public AD get(AD ad);

	// ʹ��@Selectע��ָ��getAll����Ҫִ�е�SQL
	@Select(selectAll)
    @Results({@Result(property = "adTime", column = "ad_time"),
              @Result(property = "jwName", column = "jw_name")})
    public List<AD> getAll(String username);
}