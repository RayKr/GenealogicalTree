package com.swroom.genealogy.service.impl;

import com.swroom.genealogy.model.po.GenPerson;
import com.swroom.genealogy.model.vo.VCardInfo;
import com.swroom.genealogy.model.vo.VPerson;
import com.swroom.genealogy.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jingz on 2017/2/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:*.xml")
public class PersonServiceImplTest {
    @Autowired
    private PersonService personService;

    @Test
    public void selectByName() throws Exception {
        List<GenPerson> people = personService.selectByName("汝和");
        Iterator<GenPerson> it = people.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    @Test
    public void getPersonDetail() throws Exception {
        VPerson personDetail = personService.getPersonDetail(2);
        System.out.println(personDetail.toString());
    }

    @Test
    public void getCardsInfo() throws Exception {
        List<VCardInfo> cardsInfo = personService.getCardsInfo("爱");
        System.out.println(cardsInfo);
    }

}