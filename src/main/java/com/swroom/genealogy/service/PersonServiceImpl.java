package com.swroom.genealogy.service;

import com.swroom.genealogy.mapper.GenPersonMapper;
import com.swroom.genealogy.model.po.GenPerson;
import com.swroom.genealogy.utils.CharacterConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 家族成员
 * Created by jingz on 2017/2/4.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private GenPersonMapper personMapper;

    /**
     * 根据名字查询成员方法
     * @param name 名(简/繁)，字，号
     * @return 成员对象列表
     */
    @Override
    public List<GenPerson> selectByName(String name) {
        // 若支持模糊查询，则name有可能是名、字、号，并且简繁也需考虑
        // 获取name的简体和繁体
        String simplifiedName = CharacterConvert.toSimplified(name);
        String traditionalName = CharacterConvert.toTraditional(name);
        // 调用DAO去数据库查询
        List<GenPerson> genPeople = personMapper.selectPersonByName(simplifiedName, traditionalName);
        // 返回查询结果
        return genPeople;
    }

}
