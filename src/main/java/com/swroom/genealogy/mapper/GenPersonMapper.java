package com.swroom.genealogy.mapper;

import com.swroom.genealogy.model.po.GenPerson;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("personMapper")
public interface GenPersonMapper extends Mapper<GenPerson> {

    /**
     * 模糊查询成员方法
     * @param simplifiedName 简体名
     * @param traditionalName 繁体名
     * @return 所有匹配的成员列表
     */
    List<GenPerson> selectPersonByName(@Param("simplifiedName") String simplifiedName,
                                       @Param("traditionalName") String traditionalName);

    /**
     * 获取子的数量
     * @param pid 主键
     * @return int
     */
    int getSonNum(@Param("pid") String pid);

    /**
     * 获取女的数量
     * @param pid 主键
     * @return int
     */
    int getDaughterNum(@Param("pid") String pid);


}