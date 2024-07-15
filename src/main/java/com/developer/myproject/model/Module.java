package com.developer.myproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long passmark;
    private Boolean option;
    private String bhValue;
    private Long eeCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPassmark() {
        return passmark;
    }

    public void setPassmark(Long passmark) {
        this.passmark = passmark;
    }

    public Boolean getOption() {
        return option;
    }

    public void setOption(Boolean option) {
        this.option = option;
    }

    public String getBhValue() {
        return bhValue;
    }

    public void setBhValue(String bhValue) {
        this.bhValue = bhValue;
    }

    public Long getEeCode() {
        return eeCode;
    }

    public void setEeCode(Long eeCode) {
        this.eeCode = eeCode;
    }
}
