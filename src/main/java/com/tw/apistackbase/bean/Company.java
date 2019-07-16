package com.tw.apistackbase.bean;

public class Company {
    private long id;
    private  String companyName;

    public void setId(long id) {
        this.id = id;
    }

    public Company(long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
