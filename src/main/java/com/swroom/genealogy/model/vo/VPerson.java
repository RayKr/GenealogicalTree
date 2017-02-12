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
    private VCardInfo father; // 父
    private VCardInfo mother; // 母
    private VCardInfo heirFather; // 嗣父，存在过继关系才显示
    private List<VCardInfo> brothers = new ArrayList<>(); // 兄弟姐妹
    private List<VCardInfo> children = new ArrayList<>(); // 子女
    private List<VCardInfo> spouse = new ArrayList<>(); // 配偶，介于古时一夫多妻制

    // 个人信息
    private String birthday; // 生辰
    private String currentAddress; // 当前住址
    private String cellphone; // 联系电话
    private String profession; // 行业
    private String position; // 职位
    private String introduction; // 个人介绍
    private String portrait; // 头像


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
        if (genPerson.getRank() != null) {
            String rankCN = Enums.getEnuName(Constants.RANK, String.valueOf(genPerson.getRank()));
            String prefix = genPerson.getSex() == 1 ? "行" : "女";
            this.rank = prefix + rankCN;
        }

        personMemo = genPerson.getPersonMemo();
        this.dead = Enums.getEnuName(Constants.BOOLEAN, String.valueOf(genPerson.getDead()));
        this.deathDate = DateUtil.getDateStr(genPerson.getDeathDate());
        this.heir = Enums.getEnuName(Constants.BOOLEAN, String.valueOf(genPerson.getHeir()));

        // 配偶地址在数据库中采用 `配偶名一:地址一/配偶名二:地址二/配偶名三:地址三` 形式存储
        Map<String, String> addrmap = new HashMap<>();
        if (genPerson.getSpouseAddress() != null) {
            String[] addrs = genPerson.getSpouseAddress().split("/");
            for (String addr : addrs) {
                String[] p = addr.split(":");
                addrmap.put(p[0], p[1]);
            }
        }

        // 古时一夫多妻，数据库中用`/`做分割
        if (genPerson.getSpouseName() != null) {
            String[] spouses = genPerson.getSpouseName().split("/");
            // 将数组添加到集合，可使用Collections.addALL(map, array);
            for (int i = 0; i < spouses.length; i++) {
                VCardInfo ci = new VCardInfo();
                ci.setName(spouses[i]);

                if (addrmap.containsKey(spouses[i])) {
                    ci.setMemo(addrmap.get(spouses[i]));
                }
            }
        }
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
        this.portrait = genPersonInfo.getPortrait();
    }

    public void setSonNum(String sonNum) {
        this.sonNum = sonNum;
    }

    public void setDaughterNum(String daughterNum) {
        this.daughterNum = daughterNum;
    }

    public void setFather(VCardInfo father) {
        this.father = father;
    }

    public void setMother(VCardInfo mother) {
        this.mother = mother;
    }

    public void setHeirFather(VCardInfo heirFather) {
        this.heirFather = heirFather;
    }

    public void setBrothers(List<VCardInfo> brothers) {
        this.brothers = brothers;
    }

    public void setChildren(List<VCardInfo> children) {
        this.children = children;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName;
    }

    public String getAncestralSeq() {
        return ancestralSeq;
    }

    public void setAncestralSeq(String ancestralSeq) {
        this.ancestralSeq = ancestralSeq;
    }

    public String getAncestralSeqMemo() {
        return ancestralSeqMemo;
    }

    public void setAncestralSeqMemo(String ancestralSeqMemo) {
        this.ancestralSeqMemo = ancestralSeqMemo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPersonMemo() {
        return personMemo;
    }

    public void setPersonMemo(String personMemo) {
        this.personMemo = personMemo;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getHeir() {
        return heir;
    }

    public void setHeir(String heir) {
        this.heir = heir;
    }

    public String getSonNum() {
        return sonNum;
    }

    public String getDaughterNum() {
        return daughterNum;
    }

    public VCardInfo getFather() {
        return father;
    }

    public VCardInfo getMother() {
        return mother;
    }

    public VCardInfo getHeirFather() {
        return heirFather;
    }

    public List<VCardInfo> getBrothers() {
        return brothers;
    }

    public List<VCardInfo> getChildren() {
        return children;
    }

    public List<VCardInfo> getSpouse() {
        return spouse;
    }

    public void setSpouse(List<VCardInfo> spouse) {
        this.spouse = spouse;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
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
