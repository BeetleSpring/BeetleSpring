package com.beetle.onlinevideo.entity;

public class CourseType {
    private Integer id;
    private String typeName;
    private Integer flag;

    public CourseType(Integer id, String typeName, Integer flag) {
        this.id = id;
        this.typeName = typeName;
        this.flag = flag;
    }

    public CourseType() {
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", flag=" + flag +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
