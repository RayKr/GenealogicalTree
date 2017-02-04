package com.swroom.genealogy.service;

import com.swroom.genealogy.model.po.GenPerson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * Created by jingz on 2017/2/4.
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

}