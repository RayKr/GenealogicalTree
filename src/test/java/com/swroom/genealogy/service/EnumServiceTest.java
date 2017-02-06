package com.swroom.genealogy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by jingz on 2017/2/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:*.xml")
public class EnumServiceTest {

    @Autowired
    private EnumService enumService;

    @Test
    public void getTypeMap() throws Exception {
        Map<String, Map> typeMap = enumService.getTypeMap();
        System.out.println(typeMap);
    }

}