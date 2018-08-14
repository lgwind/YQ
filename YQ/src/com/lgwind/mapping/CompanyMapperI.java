package com.lgwind.mapping;

import java.util.List;

import com.lgwind.domain.Company;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * �����û����sqlӳ��ӿڣ�ʹ��ע��ָ������Ҫִ�е�SQL���
 * 
 * @author lgwind
 * 
 */
public interface CompanyMapperI {
	
	/**
	 * sql���
	 */
	String insert = "insert into company(company_name,start_time,last_time,add_time,jd,wd,jw_name,scope,jd2,wd2,jw_name2,jd3,wd3,jw_name3) "
			+ "values(#{companyName},#{startTime},#{lastTime},#{addTime},#{jd},#{wd},#{jwName},#{scope},#{jd2},#{wd2},#{jwName2},#{jd3},#{wd3},#{jwName3})";
	String delete = "delete from company "
			+ "where company_name=#{companyName}";
	String update = "update company set start_time=#{startTime},last_time=#{lastTime},add_time=#{addTime},"
	        + "jd=#{jd}, wd=#{wd}, jw_name=#{jwName},jd2=#{jd2}, wd2=#{wd2}, jw_name2=#{jwName2},jd3=#{jd3}, wd3=#{wd3}, jw_name3=#{jwName3}, scope=#{scope} "
			+ "where company_name=#{companyName}";
	String select = "select * from company "
			+ "where company_name=#{companyName}";
	String selectAll = "select * from company where company_name like #{companyName}";

	// ʹ��@Insertע��ָ��add����Ҫִ�е�SQL
	@Insert(insert)
    public int add(Company company);

	// ʹ��@Deleteע��ָ��deleteById����Ҫִ�е�SQL
	@Delete(delete)
    public int delete(String companyName);

	// ʹ��@Updateע��ָ��update����Ҫִ�е�SQL
	@Update(update)
    public int update(Company company);

	// ʹ��@Selectע��ָ��getById����Ҫִ�е�SQL
	@Select(select)
    @Results({@Result(property = "companyName", column = "company_name"),
              @Result(property = "startTime", column = "start_time"),
              @Result(property = "lastTime", column = "last_time"),
              @Result(property = "addTime", column = "add_time"),
              @Result(property = "jwName", column = "jw_name"),
              @Result(property = "jwName2", column = "jw_name2"),
              @Result(property = "jwName3", column = "jw_name3")})
    public Company get(String companyName);

	// ʹ��@Selectע��ָ��getAll����Ҫִ�е�SQL
	@Select(selectAll)
    @Results({@Result(property = "companyName", column = "company_name"),
              @Result(property = "startTime", column = "start_time"),
              @Result(property = "lastTime", column = "last_time"),
              @Result(property = "addTime", column = "add_time"),
              @Result(property = "jwName", column = "jw_name"),
              @Result(property = "jwName2", column = "jw_name2"),
              @Result(property = "jwName3", column = "jw_name3")})
    public List<Company> getAll(String companyName);
}