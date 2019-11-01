package com.hzq.dragonshopping.entity;

import org.springframework.stereotype.Repository;

/**
 * 用户实体类
 */
public class UserEntity {

    private Integer user_id;
    private String user_name;
    private String user_sex;
    private String user_password;
    private String user_address;
    private String user_phone;
    //用户头像图片地址
    private String user_headimgurl;
    //状态（1禁用，0未禁用）
    private Integer user_status;
    //身份标识（1买家，2卖家，3超级管理员）
    private Integer user_type;
    //用户账户余额
    private Double user_money;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_headimgurl() {
        return user_headimgurl;
    }

    public void setUser_headimgurl(String user_headimgurl) {
        this.user_headimgurl = user_headimgurl;
    }

    public Integer getUser_status() {
        return user_status;
    }

    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    public Double getUser_money() {
        return user_money;
    }

    public void setUser_money(Double user_money) {
        this.user_money = user_money;
    }

    public UserEntity(Integer user_id, String user_name, String user_sex, String user_password, String user_address, String user_phone, String user_headimgurl, Integer user_status, Integer user_type, Double user_money) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_sex = user_sex;
        this.user_password = user_password;
        this.user_address = user_address;
        this.user_phone = user_phone;
        this.user_headimgurl = user_headimgurl;
        this.user_status = user_status;
        this.user_type = user_type;
        this.user_money = user_money;
    }

    public UserEntity() {
        super();
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_headimgurl='" + user_headimgurl + '\'' +
                ", user_status=" + user_status +
                ", user_type=" + user_type +
                ", user_money=" + user_money +
                '}';
    }
}
