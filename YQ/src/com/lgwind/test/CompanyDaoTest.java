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
        Company Company = new Company("���˹�˾","00:00:00","00:00:00","00:00:00", 1000,"","","�㶫ʡտ����������������㶫�����ѧѧ�����ả��A��","","","","","","");
        new CompanyDao().add(Company);
    }

    @Test
    public void testDelete() {
        new CompanyDao().delete("���˹�˾");
    }

    @Test
    public void testUpdate() {
        Company company = new Company();
//        Company Company = new Company("���˹�˾","09:00:00","18:00:00","21:00:00",1000,"110","21","�㶫ʡտ����������������㶫�����ѧѧ�����ả��A��","110","21","�㶫ʡտ����������������㶫�����ѧѧ�����ả��B��","110","21","�㶫ʡտ����������������㶫�����ѧѧ�����ả��A��");
        company.setCompanyName("������ҵ1");
//        company.setStartTime("02:00:00");
        company.setLastTime("06:05:55");
        new CompanyDao().update(company);
    }

    @Test
    public void testGet() {
        System.out.println(new CompanyDao().get("���˹�˾"));
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
