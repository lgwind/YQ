package com.lgwind.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lgwind.dao.NewsDao;
import com.lgwind.domain.News;
import com.lgwind.util.IData;

public class NewsDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNewsDao() {
        fail("Not yet implemented");
    }

    @Test
    public void testAdd() {
        News news = new News();
        news.setItype("添加企业申请");
        news.setUsername("毒菜");
        news.setCompany("毒菜企业");
        news.setReason("老子喜欢咋滴");
        news.setTime(IData.getDate()+" "+IData.getTime());
        new NewsDao().add(news);
    }

    @Test
    public void testDelete() {
        new NewsDao().delete(3);
    }

    @Test
    public void testUpdate() {
        News news = new News();
        news.setId(1);
        news.setItype("添加企业申请2");
        news.setUsername("毒菜2");
        news.setCompany("毒菜企业2");
        news.setReason("老子喜欢咋滴2");
        news.setTime(IData.getDate()+" "+IData.getTime());
        new NewsDao().update(news);
    }

    @Test
    public void testGet() {
        News news = new NewsDao().get(1);
        System.out.println(news);
    }

    @Test
    public void testGetAll() {
        List<News> newsList = new NewsDao().getAll();
        System.out.println(newsList);
    }

    @Test
    public void testGetAllString() {
        List<News> newsList = new NewsDao().getAllByUsername("111");
        System.out.println(newsList);
    }

}
