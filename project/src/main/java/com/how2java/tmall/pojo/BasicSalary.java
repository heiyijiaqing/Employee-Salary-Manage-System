package com.how2java.tmall.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "basicsalary")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class BasicSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="userId")

    private User user;

    private float basicSalary;
    private float laterDeductMoney;
    private float absenceDeductMoney;
    private float weekendOverWorkMoney;
    private float holidayOverWorkMoney;
    private Date createDate;
    private int isDel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public float getLaterDeductMoney() {
        return laterDeductMoney;
    }

    public void setLaterDeductMoney(float laterDeductMoney) {
        this.laterDeductMoney = laterDeductMoney;
    }

    public float getAbsenceDeductMoney() {
        return absenceDeductMoney;
    }

    public void setAbsenceDeductMoney(float absenceDeductMoney) {
        this.absenceDeductMoney = absenceDeductMoney;
    }

    public float getWeekendOverWorkMoney() {
        return weekendOverWorkMoney;
    }

    public void setWeekendOverWorkMoney(float weekendOverWorkMoney) {
        this.weekendOverWorkMoney = weekendOverWorkMoney;
    }

    public float getHolidayOverWorkMoney() {
        return holidayOverWorkMoney;
    }

    public void setHolidayOverWorkMoney(float holidayOverWorkMoney) {
        this.holidayOverWorkMoney = holidayOverWorkMoney;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "BasicSalary [id=" + id + ", User=" + user + "]";
    }

}
