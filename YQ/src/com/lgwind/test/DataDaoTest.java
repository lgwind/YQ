package com.lgwind.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lgwind.dao.DataDao;
import com.lgwind.domain.Data;

public class DataDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDataDao() {
        fail("Not yet implemented");
    }

    @Test
    public void testAdd() {
        Data Data = new Data("小黑","","","","","","","","20180202","",1);
        new DataDao().add(Data);
    }

    @Test
    public void testDelete() {
        new DataDao().delete("小黑");
    }

    @Test
    public void testUpdate() {
        Data Data = new Data("小黑","小黑企业","总经理","","刘小黑","男","689959","689959@qq.com","20180202","广东深圳",1);
        new DataDao().update(Data);
    }

    @Test
    public void testGet() {
        System.out.println(new DataDao().get("小黑"));
    }

    @Test
    public void testGetAll() {
        System.out.println(new DataDao().getAll());
    }

    @Test
    public void testGetAllString() {
        System.out.println(new DataDao().getAllByCompany("小黑企业"));
    }

}
