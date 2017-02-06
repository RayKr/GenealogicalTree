package com.swroom.genealogy.model.vo;

import com.swroom.genealogy.model.po.GenPerson;
import com.swroom.genealogy.model.po.GenPersonInfo;

import java.util.List;
import java.util.Map;

/**
 * View Bean Person
 * Created by jingz on 2017/2/4.
 */
public class VPerson {

    private GenPerson genPerson;
    private GenPersonInfo genPersonInfo;

    // 名称
    private String name; // 名
    private String styleName; // 字
    private String selfName; // 号

    // 世序相关
    private Integer ancestralSeq; // 世序
    private String ancestralSeqMemo; // 世序备注
    private String branch; // 家族分支

    // 基本信息
    private String sex; // 性别
    private Integer rank; // 排行
    private String personMemo; // 个人说明
    private Boolean dead; // 是否已故
    private String deathDate; // 已故时间
    private Boolean heir; // 是否存在过继关系
    private Integer sonNum; // 子数量
    private Integer daughterNum; // 女数量

    // 关系网
    private List<String> spouse; // 配偶，介于古时一夫多妻制
    private Map<String, String> spouseAddress; // 配偶原址
    private String father; // 父
    private String mother; // 母
    private String heirFather; // 嗣父，存在过继关系才显示
    private List<String> brothers; // 兄弟姐妹
    private List<String> children; // 子女

    // 个人信息
    private String birthday; // 生辰
    private String currentAddress; // 当前住址
    private String cellphone; // 联系电话
    private String profession; // 行业
    private String position; // 职位
    private String introduction; // 个人介绍


    public VPerson(GenPerson genPerson, GenPersonInfo genPersonInfo) {
        this.genPerson = genPerson;
        this.genPersonInfo = genPersonInfo;

        init();
    }

    private void init() {
        this.name = this.genPerson.getName();
        this.styleName = this.genPerson.getStyleName();
        this.selfName = this.genPerson.getSelfName();

        this.ancestralSeq = this.genPerson.getAncestralSequence();
        this.ancestralSeqMemo = this.genPerson.getAncestralSequenceMemo();
//        this.branch = ;


    }
}
