package com.beetle.onlinevideo.entity;

public class Tool {

    private Integer id;
    private String name;
    private String toolUrl;
    private String iconUrl;
    private Integer typeId;

    @Override
    public String toString() {
        return "Tool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", toolUrl='" + toolUrl + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", typeId=" + typeId +
                '}';
    }

    public Tool(Integer id, String name, String toolUrl, String iconUrl, Integer typeId) {
        this.id = id;
        this.name = name;
        this.toolUrl = toolUrl;
        this.iconUrl = iconUrl;
        this.typeId = typeId;
    }

    public Tool() {
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

    public String getToolUrl() {
        return toolUrl;
    }

    public void setToolUrl(String toolUrl) {
        this.toolUrl = toolUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
