package com.kjcManager.json;

public class Patent {
    private Integer id;
    private String name;
    private String inventor;
    private String type;
    private String desc;
    private String appliDate;
    private String openDate;
    private String pubNum;
    private String addTime;

    @Override
    public String toString() {
        return "Patent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inventor='" + inventor + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", appliDate='" + appliDate + '\'' +
                ", openDate='" + openDate + '\'' +
                ", pubNum='" + pubNum + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }

    public String getAppliDate() {
        return appliDate;
    }

    public void setAppliDate(String appliDate) {
        this.appliDate = appliDate == null ? null : appliDate.trim();
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate == null ? null : openDate.trim();
    }

    public String getPubNum() {
        return pubNum;
    }

    public void setPubNum(String pubNum) {
        this.pubNum = pubNum == null ? null : pubNum.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor == null ? null : inventor.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }


}