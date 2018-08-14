package com.lgwind.mapping;

import java.util.List;

import com.lgwind.domain.Data;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * �����û����sqlӳ��ӿڣ�ʹ��ע��ָ������Ҫִ�е�SQL���
 * 
 * @author lgwind
 * 
 */
public interface DataMapperI {
	
	/**
	 * sql���
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

	// ʹ��@Insertע��ָ��add����Ҫִ�е�SQL
	@Insert(insert)
    public int add(Data data);

	// ʹ��@Deleteע��ָ��deleteById����Ҫִ�е�SQL
	@Delete(delete)
    public int delete(String username);

	// ʹ��@Updateע��ָ��update����Ҫִ�е�SQL
	@Update(update)
    public int update(Data data);

	// ʹ��@Selectע��ָ��getById����Ҫִ�е�SQL
	@Select(select)
    public Data get(String username);

	// ʹ��@Selectע��ָ��getAll����Ҫִ�е�SQL
	@Select(selectAll)
    public List<Data> getAll(String username);
	
	// ʹ��@Selectע��ָ��getAll����Ҫִ�е�SQL
    @Select(selectAllByCompany)
    public List<Data> getAllByCompany(String company);
}