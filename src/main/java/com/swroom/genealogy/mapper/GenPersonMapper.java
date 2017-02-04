package com.swroom.genealogy.mapper;

import com.swroom.genealogy.model.po.GenPerson;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("personMapper")
public interface GenPersonMapper extends Mapper<GenPerson> {

    List<GenPerson> selectPersonByName(@Param("simplifiedName") String simplifiedName,
                            @Param("traditionalName") String traditionalName);
}