package com.lgwind.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lgwind.domain.AD;
import com.lgwind.util.ADUtil;
import com.lgwind.view.ADone;

public class ADUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPersonAD() {
        List<AD> adList = ADUtil.personAD("Lgwind");
        System.out.println(adList);
        
    }
    
    @Test
    public void companyDay() {
        List<ADone> adList = ADUtil.companyDay("Lgwind","2018-05-30");
        System.out.println(adList);
    }
    
    

}
