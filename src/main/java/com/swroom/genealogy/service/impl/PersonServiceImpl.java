package com.swroom.genealogy.service.impl;

import com.swroom.genealogy.common.Constants;
import com.swroom.genealogy.common.Enums;
import com.swroom.genealogy.mapper.CardInfoMapper;
import com.swroom.genealogy.mapper.GenPersonInfoMapper;
import com.swroom.genealogy.mapper.GenPersonMapper;
import com.swroom.genealogy.model.po.GenPerson;
import com.swroom.genealogy.model.po.GenPersonInfo;
import com.swroom.genealogy.model.vo.VCardInfo;
import com.swroom.genealogy.model.vo.VPerson;
import com.swroom.genealogy.service.PersonService;
import com.swroom.genealogy.utils.CharacterConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.util.List;

/**
 * 家族成员
 * Created by jingz on 2017/2/4.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private GenPersonMapper personMapper;

    @Autowired
    private GenPersonInfoMapper personInfoMapper;

    @Autowired
    private CardInfoMapper cardInfoMapper;

    /**
     * 根据名字查询成员方法
     *
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

    /**
     * 个人详细页需要的所有信息
     *
     * @param pid 主键
     * @return
     */
    @Override
    public VPerson getPersonDetail(int pid) throws Exception {
        GenPerson genPerson = this.personMapper.selectByPrimaryKey(pid);
        GenPersonInfo genPersonInfo = this.personInfoMapper.selectByPrimaryKey(pid);

        // 封装view-bean
        VPerson vPerson = new VPerson(genPerson, genPersonInfo);

        // 子、女数量
        int[] childrenNum = this.getChildrenNum(pid);
        vPerson.setSonNum(Enums.getEnuName(Constants.RANK, String.valueOf(childrenNum[0])));
        vPerson.setDaughterNum(Enums.getEnuName(Constants.RANK, String.valueOf(childrenNum[1])));

        // 兄弟姐妹
        vPerson.setBrothers(this.cardInfoMapper.selectBrothersById(pid));
        // 子女
        vPerson.setChildren(this.cardInfoMapper.selectChildrenById(pid));
        // 父
        if (genPerson.getFatherId() != null) {
            vPerson.setFather(this.cardInfoMapper.selectCardInfoById(genPerson.getFatherId()));
        }
        // 嗣父
        if ("1".equals(genPerson.getHeir())) {
            vPerson.setHeirFather(this.cardInfoMapper.selectCardInfoById(genPerson.getHeirFatherId()));
        }
        // 母
        VCardInfo vi = new VCardInfo();
        vi.setName(genPerson.getMotherName());
        vPerson.setMother(vi);

        return vPerson;
    }

    /**
     * 新增一个成员
     *
     * @param person
     * @return
     */
    @Override
    public int insertPerson(GenPerson person) {
        return this.personMapper.insert(person);
    }

    /**
     * 获取子、女数量
     *
     * @param pid
     * @return
     */
    @Override
    public int[] getChildrenNum(int pid) {
        return new int[]{this.personMapper.getSonNum(pid), this.personMapper.getDaughterNum(pid)};
    }

    @Override
    public int getAllPersonCount() {
        return this.personMapper.getAllPersonCount();
    }

    @Override
    public List<VCardInfo> getCardsInfo(String name) {
        // 如果输入的值中包含姓，则需加判断去掉姓后再查
        String lastName = name.substring(0, 1);
        if ("景".equals(lastName)){
            name = name.substring(1);
        }

        // 获取name的简体和繁体
        String simplifiedName = CharacterConvert.toSimplified(name);
        String traditionalName = CharacterConvert.toTraditional(name);
        return cardInfoMapper.selectCardInfo(simplifiedName, traditionalName);
    }

}
