package com.beetle.onlinevideo.entity;



import java.util.Date;

public class User {
    private int id;
    private String telephone;
    private String userName;
    private String password;
    private String email;
    private Integer vipFlag;
    private Date createTime;
    private Integer flag;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", telephone='" + telephone + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", vipFlag='" + vipFlag + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(Integer vipFlag) {
        this.vipFlag = vipFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User() {
    }

    public User(int id, String telephone, String userName, String password, String email, Integer vipFlag, Date createTime) {
        this.id = id;
        this.telephone = telephone;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.vipFlag = vipFlag;
        this.createTime = createTime;
    }
}
