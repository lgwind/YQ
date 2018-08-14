package com.lgwind.mapping;

import java.util.List;

import com.lgwind.domain.User;

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
public interface UserMapperI {
	
	/**
	 * sql���
	 */
	String insert = "insert into user(username,password,role) "
			+ "values(#{username},#{password},#{role})";
	String delete = "delete from user "
			+ "where username=#{username}";
	String update = "update user set password=#{password},role=#{role} "
			+ "where username=#{username}";
	String select = "select * from user "
			+ "where username=#{username}";
	String selectAll = "select * from user where username like #{username}";

	// ʹ��@Insertע��ָ��add����Ҫִ�е�SQL
	@Insert(insert)
    public int add(User user);

	// ʹ��@Deleteע��ָ��deleteById����Ҫִ�е�SQL
	@Delete(delete)
    public int delete(String username);

	// ʹ��@Updateע��ָ��update����Ҫִ�е�SQL
	@Update(update)
    public int update(User user);

	// ʹ��@Selectע��ָ��getById����Ҫִ�е�SQL
	@Select(select)
    public User get(String username);

	// ʹ��@Selectע��ָ��getAll����Ҫִ�е�SQL
	@Select(selectAll)
    public List<User> getAll(String username);
}