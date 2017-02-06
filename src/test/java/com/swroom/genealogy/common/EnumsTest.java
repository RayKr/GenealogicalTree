package com.swroom.genealogy.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by jingz on 2017/2/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:*.xml")
public class EnumsTest {
    @Test
    public void getEnuName() throws Exception {
        System.out.println(Enums.getEnuName("branch", "3"));
    }

}