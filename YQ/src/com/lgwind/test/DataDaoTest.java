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
        Data Data = new Data("С��","","","","","","","","20180202","",1);
        new DataDao().add(Data);
    }

    @Test
    public void testDelete() {
        new DataDao().delete("С��");
    }

    @Test
    public void testUpdate() {
        Data Data = new Data("С��","С����ҵ","�ܾ���","","��С��","��","689959","689959@qq.com","20180202","�㶫����",1);
        new DataDao().update(Data);
    }

    @Test
    public void testGet() {
        System.out.println(new DataDao().get("С��"));
    }

    @Test
    public void testGetAll() {
        System.out.println(new DataDao().getAll());
    }

    @Test
    public void testGetAllString() {
        System.out.println(new DataDao().getAllByCompany("С����ҵ"));
    }

}
