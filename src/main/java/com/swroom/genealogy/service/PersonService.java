package com.swroom.genealogy.service;

import com.swroom.genealogy.model.po.GenPerson;

import java.util.List;

/**
 * 家族成员接口
 * Created by jingz on 2017/2/4.
 */
public interface PersonService {

    /**
     * 根据输入项，模糊查询成员
     * @param name
     * @return
     */
    List<GenPerson> selectByName(String name);
}
