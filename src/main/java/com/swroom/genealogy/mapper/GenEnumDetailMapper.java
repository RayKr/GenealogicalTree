package com.swroom.genealogy.mapper;

import com.swroom.genealogy.model.po.GenEnumDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository("enumDetailMapper")
public interface GenEnumDetailMapper extends Mapper<GenEnumDetail> {

    List<GenEnumDetail> selectByType(@Param("type") String type);
}