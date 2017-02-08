package com.swroom.genealogy.controller;

import com.swroom.genealogy.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jingz on 2017/2/7.
 */
@Controller
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "")
    public String personDetail(){
        return "person";
    }

    @RequestMapping(value = "dash")
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping(value = "vue")
    public String vueTree() {
        return "vuetree";
    }

    @RequestMapping(value = "getperson", method = RequestMethod.GET)
    @ResponseBody
    public Object getperson() {
        return siteService.getMenu();
    }
}
