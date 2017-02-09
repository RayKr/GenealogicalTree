package com.swroom.genealogy.mapper;

import com.swroom.genealogy.model.vo.VCardInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by jingz on 2017/2/9.
 */
@Repository("cardInfoMapper")
public interface CardInfoMapper extends Mapper<VCardInfo> {

    List<VCardInfo> selectCardInfo(@Param("simplifiedName") String simplifiedName,
                                   @Param("traditionalName") String traditionalName);
}
