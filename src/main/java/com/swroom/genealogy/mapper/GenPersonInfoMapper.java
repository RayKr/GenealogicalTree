package com.swroom.genealogy.mapper;

import com.swroom.genealogy.model.po.GenPersonInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("personInfoMapper")
public interface GenPersonInfoMapper extends Mapper<GenPersonInfo> {
}