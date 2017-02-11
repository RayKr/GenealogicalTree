package com.swroom.genealogy.controller;

import com.swroom.genealogy.model.vo.VCardInfo;
import com.swroom.genealogy.model.vo.VJson;
import com.swroom.genealogy.model.vo.VPerson;
import com.swroom.genealogy.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Person
 * Created by jingz on 2017/2/7.
 */
@Controller
@RequestMapping(value = "/person")
public class PersonController {

    private VJson vJson;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "")
    public String personSearch(){
        return "person";
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView personDetail(ModelMap map, @RequestParam("p") int pid) {

        ModelAndView mv = new ModelAndView("detail");
        try {
//            VPerson personDetail = personService.getPersonDetail(pid);
//
//            map.addAttribute("person", personDetail);
//
//            mv = new ModelAndView("detail", map);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping(value = "dash")
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping(value = "vue")
    public String vueTree() {
        return "vuetree";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object searchPeopleList(@RequestParam("name") String name) {

        // 获取记录
        List<VCardInfo> genPeople = personService.getCardsInfo(name);

        // 封装结果
        vJson = new VJson();
        if (genPeople.isEmpty()) {
            vJson.setMsg("查无此人！");
            vJson.setSuccess(false);
        } else {
            vJson.setSuccess(true);
            vJson.setResult(genPeople);
        }
        return vJson;
    }

    @RequestMapping(value = "detailinfo", method = RequestMethod.GET)
    @ResponseBody
    public Object showPersonDetailInfo(@RequestParam("p") int pid) {
        VPerson personDetail = null;
        try {
            personDetail = personService.getPersonDetail(pid);
            // 封装结果
            vJson = new VJson();

            vJson.setSuccess(true);
            vJson.setResult(personDetail);
        } catch (Exception e) {
            e.printStackTrace();
            vJson.setMsg("查无此人！");
            vJson.setSuccess(false);
        }
        return personDetail;
    }
}
