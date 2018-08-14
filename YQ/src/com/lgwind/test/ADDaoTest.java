package com.lgwind.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lgwind.dao.ADDao;
import com.lgwind.domain.AD;

public class ADDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testADDao() {
        fail("Not yet implemented");
    }

    @Test
    public void testAdd() {
        AD ad = new AD("小黑","20180521-am-0","","","",100,"20180512","正常考勤");
        new ADDao().add(ad);
    }

    @Test
    public void testDelete() {
        new ADDao().delete("小黑","20180521-am-0");
    }

    @Test
    public void testUpdate() {
        AD ad = new AD("小黑","20180521-am-0","110.333","21.1321123","",100,"2018-05-12","正常考勤");
        new ADDao().update(ad);
    }

    @Test
    public void testGet() {
        System.out.println(new ADDao().get("小黑","20180521-am-0"));
    }

    @Test
    public void testGetAll() {
        System.out.println(new ADDao().getAll());
    }

    @Test
    public void testGetAllString() {
        fail("Not yet implemented");
    }

}
