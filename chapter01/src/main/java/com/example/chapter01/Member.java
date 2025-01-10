package com.example.chapter01;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="MEMBER",
        uniqueConstraints = {@UniqueConstraint(name = "NAME_AGE_UNIQUE", columnNames = {"NAME", "AGE"})})
public class Member {


    @Id
    @Column(name = "ID")
    private String id;

    @Column(name="NAME", nullable = false, length = 10)
    private String userName;

    @Column(name="AGE")
    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Lob
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descriptionl) {
        this.description = descriptionl;
    }

    protected Member(){

    }






}
