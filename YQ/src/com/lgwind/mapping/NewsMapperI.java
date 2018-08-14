package com.lgwind.mapping;

import java.util.List;

import com.lgwind.domain.News;

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
public interface NewsMapperI {
	
	/**
	 * sql���
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

	// ʹ��@Insertע��ָ��add����Ҫִ�е�SQL
	@Insert(insert)
    public int add(News news);

	// ʹ��@Deleteע��ָ��deleteById����Ҫִ�е�SQL
	@Delete(delete)
    public int delete(int id);

	// ʹ��@Updateע��ָ��update����Ҫִ�е�SQL
	@Update(update)
    public int update(News news);

	// ʹ��@Selectע��ָ��getById����Ҫִ�е�SQL
	@Select(select)
    public News get(int id);

	// ʹ��@Selectע��ָ��getAll����Ҫִ�е�SQL
	@Select(selectAll)
    public List<News> getAll(String itype);
	
	// ʹ��@Selectע��ָ��getAll����Ҫִ�е�SQL
    @Select(selectAllByUsername)
    public List<News> getAllByUsername(String username);
}