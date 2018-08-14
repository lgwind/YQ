package com.lgwind.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lgwind.dao.CompanyDao;
import com.lgwind.domain.Company;

public class CompanyDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCompanyDao() {
        fail("Not yet implemented");
    }

    @Test
    public void testAdd() {
        Company Company = new Company("毒菜公司","00:00:00","00:00:00","00:00:00", 1000,"","","广东省湛江市麻章区湖光镇广东海洋大学学生宿舍海怀A栋","","","","","","");
        new CompanyDao().add(Company);
    }

    @Test
    public void testDelete() {
        new CompanyDao().delete("毒菜公司");
    }

    @Test
    public void testUpdate() {
        Company company = new Company();
//        Company Company = new Company("毒菜公司","09:00:00","18:00:00","21:00:00",1000,"110","21","广东省湛江市麻章区湖光镇广东海洋大学学生宿舍海怀A栋","110","21","广东省湛江市麻章区湖光镇广东海洋大学学生宿舍海怀B栋","110","21","广东省湛江市麻章区湖光镇广东海洋大学学生宿舍海怀A栋");
        company.setCompanyName("测试企业1");
//        company.setStartTime("02:00:00");
        company.setLastTime("06:05:55");
        new CompanyDao().update(company);
    }

    @Test
    public void testGet() {
        System.out.println(new CompanyDao().get("毒菜公司"));
    }

    @Test
    public void testGetAll() {
        System.out.println(new CompanyDao().getAll());
    }

    @Test
    public void testGetAllString() {
        fail("Not yet implemented");
    }

}
