package com.swroom.genealogy.service;

import com.swroom.genealogy.model.po.GenPerson;
import com.swroom.genealogy.model.vo.VPerson;

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

    /**
     * 返回给前台的个人信息明细
     * @param pid 主键
     * @return VPerson
     */
    VPerson getPersonDetail(int pid) throws Exception;

    /**
     * 新增成员
     * @param person
     * @return
     */
    int insertPerson(GenPerson person);

    /**
     * 获取子女数量
     * @param pid
     * @return array 0-子，1-女
     */
    int[] getChildrenNum(int pid);

}
