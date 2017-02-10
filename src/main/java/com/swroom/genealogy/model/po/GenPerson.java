package com.swroom.genealogy.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "gen_person")
public class GenPerson {
    /**
     * 主键
     */
    @Id
    private Integer pid;

    private String name;

    @Column(name = "style_name")
    private String styleName;

    @Column(name = "self_name")
    private String selfName;

    private Integer sex;

    @Column(name = "father_id")
    private Integer fatherId;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    private Integer rank;

    private Integer married;

    @Column(name = "spouse_name")
    private String spouseName;

    @Column(name = "spouse_address")
    private String spouseAddress;

    private Integer dead;

    @Column(name = "death_date")
    private Date deathDate;

    private Integer heir;

    @Column(name = "heir_father_id")
    private Integer heirFatherId;

    @Column(name = "heir_father_name")
    private String heirFatherName;

    @Column(name = "ancestral_sequence")
    private Integer ancestralSequence;

    @Column(name = "ancestral_sequence_memo")
    private String ancestralSequenceMemo;

    private Integer branch;

    @Column(name = "person_memo")
    private String personMemo;

    /**
     * 获取主键
     *
     * @return pid - 主键
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置主键
     *
     * @param pid 主键
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return style_name
     */
    public String getStyleName() {
        return styleName;
    }

    /**
     * @param styleName
     */
    public void setStyleName(String styleName) {
        this.styleName = styleName == null ? null : styleName.trim();
    }

    /**
     * @return self_name
     */
    public String getSelfName() {
        return selfName;
    }

    /**
     * @param selfName
     */
    public void setSelfName(String selfName) {
        this.selfName = selfName == null ? null : selfName.trim();
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return father_id
     */
    public Integer getFatherId() {
        return fatherId;
    }

    /**
     * @param fatherId
     */
    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * @return father_name
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName == null ? null : fatherName.trim();
    }

    /**
     * @return mother_name
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * @param motherName
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName == null ? null : motherName.trim();
    }

    /**
     * @return rank
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * @param rank
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * @return married
     */
    public Integer getMarried() {
        return married;
    }

    /**
     * @param married
     */
    public void setMarried(Integer married) {
        this.married = married;
    }

    /**
     * @return spouse_name
     */
    public String getSpouseName() {
        return spouseName;
    }

    /**
     * @param spouseName
     */
    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName == null ? null : spouseName.trim();
    }

    /**
     * @return spouse_address
     */
    public String getSpouseAddress() {
        return spouseAddress;
    }

    /**
     * @param spouseAddress
     */
    public void setSpouseAddress(String spouseAddress) {
        this.spouseAddress = spouseAddress == null ? null : spouseAddress.trim();
    }

    /**
     * @return dead
     */
    public Integer getDead() {
        return dead;
    }

    /**
     * @param dead
     */
    public void setDead(Integer dead) {
        this.dead = dead;
    }

    /**
     * @return death_date
     */
    public Date getDeathDate() {
        return deathDate;
    }

    /**
     * @param deathDate
     */
    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    /**
     * @return heir
     */
    public Integer getHeir() {
        return heir;
    }

    /**
     * @param heir
     */
    public void setHeir(Integer heir) {
        this.heir = heir;
    }

    /**
     * @return heir_father_id
     */
    public Integer getHeirFatherId() {
        return heirFatherId;
    }

    /**
     * @param heirFatherId
     */
    public void setHeirFatherId(Integer heirFatherId) {
        this.heirFatherId = heirFatherId;
    }

    /**
     * @return heir_father_name
     */
    public String getHeirFatherName() {
        return heirFatherName;
    }

    /**
     * @param heirFatherName
     */
    public void setHeirFatherName(String heirFatherName) {
        this.heirFatherName = heirFatherName == null ? null : heirFatherName.trim();
    }

    /**
     * @return ancestral_sequence
     */
    public Integer getAncestralSequence() {
        return ancestralSequence;
    }

    /**
     * @param ancestralSequence
     */
    public void setAncestralSequence(Integer ancestralSequence) {
        this.ancestralSequence = ancestralSequence;
    }

    /**
     * @return ancestral_sequence_memo
     */
    public String getAncestralSequenceMemo() {
        return ancestralSequenceMemo;
    }

    /**
     * @param ancestralSequenceMemo
     */
    public void setAncestralSequenceMemo(String ancestralSequenceMemo) {
        this.ancestralSequenceMemo = ancestralSequenceMemo == null ? null : ancestralSequenceMemo.trim();
    }

    /**
     * @return branch
     */
    public Integer getBranch() {
        return branch;
    }

    /**
     * @param branch
     */
    public void setBranch(Integer branch) {
        this.branch = branch;
    }

    /**
     * @return person_memo
     */
    public String getPersonMemo() {
        return personMemo;
    }

    /**
     * @param personMemo
     */
    public void setPersonMemo(String personMemo) {
        this.personMemo = personMemo == null ? null : personMemo.trim();
    }
}