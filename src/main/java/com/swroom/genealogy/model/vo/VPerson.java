package com.swroom.genealogy.model.vo;

import com.swroom.genealogy.common.Constants;
import com.swroom.genealogy.common.Enums;
import com.swroom.genealogy.model.po.GenPerson;
import com.swroom.genealogy.model.po.GenPersonInfo;
import com.swroom.genealogy.utils.DateUtil;
import com.swroom.genealogy.utils.NumericUtil;

import java.util.*;

/**
 * View Bean Person
 * Created by jingz on 2017/2/4.
 */
public class VPerson {

    // 名称
    private String pid; // 主键
    private String name; // 名
    private String styleName; // 字
    private String selfName; // 号

    // 世序相关
    private String ancestralSeq; // 世序
    private String ancestralSeqMemo; // 世序备注
    private String branch; // 家族分支

    // 基本信息
    private String sex; // 性别
    private String rank; // 排行
    private String personMemo; // 个人说明
    private String dead; // 是否已故
    private String deathDate; // 已故时间
    private String heir; // 是否存在过继关系
    private String sonNum; // 子数量
    private String daughterNum; // 女数量

    // 关系网
    private List<String> spouse = new ArrayList<>(); // 配偶，介于古时一夫多妻制
    private Map<String, String> spouseAddress = new HashMap<>(); // 配偶原址
    private String father; // 父
    private String mother; // 母
    private String heirFather; // 嗣父，存在过继关系才显示
    private Map<Integer, String> brothers = new HashMap<>(); // 兄弟姐妹Map<pid, name>
    private Map<Integer, String> children = new HashMap<>(); // 子女Map<pid, name>

    // 个人信息
    private String birthday; // 生辰
    private String currentAddress; // 当前住址
    private String cellphone; // 联系电话
    private String profession; // 行业
    private String position; // 职位
    private String introduction; // 个人介绍


    public VPerson(GenPerson genPerson, GenPersonInfo genPersonInfo) throws Exception {
        init(genPerson);
        init(genPersonInfo);
    }

    private void init(GenPerson genPerson) throws Exception {

        if (genPerson == null) {
            throw new Exception("抱歉，查无此人！");
        }

        this.pid = genPerson.getPid().toString();
        this.name = genPerson.getName();
        this.styleName = genPerson.getStyleName();
        this.selfName = genPerson.getSelfName();

        this.ancestralSeq = NumericUtil.arabicToNumeric(String.valueOf(genPerson.getAncestralSequence())) + "世";
        this.ancestralSeqMemo = genPerson.getAncestralSequenceMemo();
        this.branch = Enums.getEnuName(Constants.BRANCH, String.valueOf(genPerson.getBranch()));

        this.sex = Enums.getEnuName(Constants.SEX, String.valueOf(genPerson.getSex()));
        // 排行需要判断男女，男：行一、行二；女：女一、女二
        String rankCN = Enums.getEnuName(Constants.RANK, String.valueOf(genPerson.getRank()));
        String prefix = genPerson.getSex() == 1 ? "行" : "女";
        this.rank = prefix + rankCN;

        personMemo = genPerson.getPersonMemo();
        this.dead = Enums.getEnuName(Constants.BOOLEAN, String.valueOf(genPerson.getDead()));
        this.deathDate = DateUtil.getDateStr(genPerson.getDeathDate());
        this.heir = Enums.getEnuName(Constants.BOOLEAN, String.valueOf(genPerson.getHeir()));

        // 古时一夫多妻，数据库中用`/`做分割
        if (genPerson.getSpouseName() != null) {
            String[] spouses = genPerson.getSpouseName().split("/");
            // 将数组添加到集合，可使用Collections.addALL(map, array);
            Collections.addAll(this.spouse, spouses);
        }
        // 配偶地址在数据库中采用 `配偶名一:地址一/配偶名二:地址二/配偶名三:地址三` 形式存储
        if (genPerson.getSpouseAddress() != null) {
            String[] addrs = genPerson.getSpouseAddress().split("/");
            for (String addr : addrs) {
                String[] p = addr.split(":");
                this.spouseAddress.put(p[0], p[1]);
            }
        }

        this.father = genPerson.getFatherName();
        this.mother = genPerson.getMotherName();
        this.heirFather = genPerson.getHeirFatherName();

    }

    private void init(GenPersonInfo genPersonInfo) {

        if (genPersonInfo == null) {
            return;
        }

        this.birthday = DateUtil.getDateStr(genPersonInfo.getBirthday());
        this.currentAddress = genPersonInfo.getCurrentAddress();
        this.cellphone = genPersonInfo.getCellphone();
        this.profession = genPersonInfo.getProfession();
        this.position = genPersonInfo.getPosition();
        this.introduction = genPersonInfo.getIntroduction();
    }

    public void setSonNum(String sonNum) {
        this.sonNum = sonNum;
    }

    public void setDaughterNum(String daughterNum) {
        this.daughterNum = daughterNum;
    }

    public Map<Integer, String> getBrothers() {
        return brothers;
    }

    public Map<Integer, String> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "VPerson{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", styleName='" + styleName + '\'' +
                ", selfName='" + selfName + '\'' +
                ", ancestralSeq='" + ancestralSeq + '\'' +
                ", ancestralSeqMemo='" + ancestralSeqMemo + '\'' +
                ", branch='" + branch + '\'' +
                ", sex='" + sex + '\'' +
                ", rank='" + rank + '\'' +
                ", personMemo='" + personMemo + '\'' +
                ", dead='" + dead + '\'' +
                ", deathDate='" + deathDate + '\'' +
                ", heir='" + heir + '\'' +
                ", sonNum='" + sonNum + '\'' +
                ", daughterNum='" + daughterNum + '\'' +
                ", spouse=" + spouse +
                ", spouseAddress=" + spouseAddress +
                ", father='" + father + '\'' +
                ", mother='" + mother + '\'' +
                ", heirFather='" + heirFather + '\'' +
                ", brothers=" + brothers +
                ", children=" + children +
                ", birthday='" + birthday + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", profession='" + profession + '\'' +
                ", position='" + position + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
