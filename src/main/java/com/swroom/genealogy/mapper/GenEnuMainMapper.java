package com.swroom.genealogy.mapper;

import com.swroom.genealogy.model.po.GenEnuMain;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("enuMainMapper")
public interface GenEnuMainMapper extends Mapper<GenEnuMain> {
}