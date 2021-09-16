package com.beetle.onlinevideo.entity;

public class ToolType {
    private Integer id;
    private String name;
    private Integer flag;

    public ToolType() {
    }

    public ToolType(Integer id, String name, Integer flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ToolType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                '}';
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
        this.name = name;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
