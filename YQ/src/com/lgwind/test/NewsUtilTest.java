package com.lgwind.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lgwind.util.NewsUtil;

public class NewsUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNews() {
        System.out.println(NewsUtil.news("�����ҵ����", 0));
    }

}
