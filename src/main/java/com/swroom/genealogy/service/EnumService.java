package com.swroom.genealogy.service;

import com.swroom.genealogy.mapper.GenEnuMainMapper;
import com.swroom.genealogy.mapper.GenEnumDetailMapper;
import com.swroom.genealogy.model.po.GenEnuMain;
import com.swroom.genealogy.model.po.GenEnumDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 枚举
 * Created by jingz on 2017/2/6.
 */
@Service("enumsService")
public class EnumService {

    @Autowired
    private GenEnuMainMapper enuMainMapper;

    @Autowired
    private GenEnumDetailMapper enumDetailMapper;

    /**
     * 获取所有枚举类型
     * @return
     */
    public List<GenEnuMain> selectAllTypes() {
        return this.enuMainMapper.selectAll();
    }

    /**
     * 获取某一枚举类型的所有记录
     * @param type
     * @return
     */
    public List<GenEnumDetail> selectEnumsByType(String type) {
        return this.enumDetailMapper.selectByType(type);
    }

    /**
     * 获取所有类型Map key-enumType,value-enumValue
     * @return
     */
    public Map<String, Map> getTypeMap() {

        String type;
        String value;
        String name;
        Map<String, String> enuMap = new HashMap<>();
        Map<String, Map> typeMap = new HashMap<>();

        List<GenEnuMain> types = this.selectAllTypes();
        Iterator<GenEnuMain> itType = types.iterator();
        while (itType.hasNext()) {
            // 清空enuMap
            enuMap.clear();
            // 获取类型
            GenEnuMain enu = itType.next();
            type = enu.getEnumType();
            // 根据类型获取该类型所有枚举
            List<GenEnumDetail> enumDetails = this.selectEnumsByType(type);
            Iterator<GenEnumDetail> itDetails = enumDetails.iterator();
            while (itDetails.hasNext()) {
                GenEnumDetail enumDetail = itDetails.next();
                value = enumDetail.getEnumValue();
                name = enumDetail.getEnumName();
                // 将枚举值-名对放入map
                enuMap.put(value, name);
            }
            // 将枚举放入类型map
            typeMap.put(type, enuMap);
        }

        return typeMap;
    }

}
