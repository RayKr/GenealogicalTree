package com.swroom.genealogy.controller;

import com.swroom.genealogy.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 站点配置路由
 * Created by jingz on 2017/2/8.
 */
@Controller
@RequestMapping(value = "/")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @RequestMapping(value = "initmenu", method = RequestMethod.GET)
    @ResponseBody
    public Object initMenu() {
        return siteService.getMenu();
    }

    @RequestMapping(value = "siteinfo", method = RequestMethod.GET)
    @ResponseBody
    public Object siteinfo() {
        return siteService.getSiteConfig();
    }
}
