package com.swroom.genealogy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jingz on 2017/2/7.
 */
@Controller
@RequestMapping(value = "person")
public class PersonController {

    @RequestMapping(value = "")
    public String personDetail(){
        return "person";
    }

    @RequestMapping(value = "dash")
    public String dashboard() {
        return "dashboard";
    }
}
