package com.swroom.genealogy.mapper;

import com.swroom.genealogy.model.vo.VCardInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 卡片信息
 * Created by jingz on 2017/2/9.
 */
@Repository("cardInfoMapper")
public interface CardInfoMapper extends Mapper<VCardInfo> {

    /**
     * 根据名字模糊查询所有匹配成员的信息
     * @param simplifiedName
     * @param traditionalName
     * @return
     */
    List<VCardInfo> selectCardInfo(@Param("simplifiedName") String simplifiedName,
                                   @Param("traditionalName") String traditionalName);

    /**
     * 获取该成员的信息
     * @param pid
     * @return
     */
    VCardInfo selectCardInfoById(@Param("pid") int pid);

    /**
     * 获取该成员兄弟姐妹的信息
     * @param pid
     * @return
     */
    List<VCardInfo> selectBrothersById(@Param("pid") int pid);

    /**
     * 获取该成员子女的信息
     * @param pid
     * @return
     */
    List<VCardInfo> selectChildrenById(@Param("pid") int pid);


}
