package com.swroom.genealogy.service.impl;

import com.swroom.genealogy.service.SiteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by jingz on 2017/2/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:*.xml")
public class SiteServiceImplTest {

    @Autowired
    private SiteService siteService;

    @Test
    public void getMenu() throws Exception {
        System.out.println(siteService.getMenu());
    }

}