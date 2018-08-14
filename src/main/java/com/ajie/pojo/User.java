package com.ajie.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private Byte age;

    private String gendar;

    private Long phone;

    private Date createtime;

    private Integer bindmember;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getGendar() {
        return gendar;
    }

    public void setGendar(String gendar) {
        this.gendar = gendar == null ? null : gendar.trim();
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getBindmember() {
        return bindmember;
    }

    public void setBindmember(Integer bindmember) {
        this.bindmember = bindmember;
    }
}