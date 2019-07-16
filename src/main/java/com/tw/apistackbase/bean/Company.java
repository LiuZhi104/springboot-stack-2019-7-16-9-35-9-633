package com.tw.apistackbase.bean;

import java.util.List;

public class Company {
    private long id;
    private  String companyName;
    private List<Employee> employees;
    private  int employeesNumber;

    public void setId(long id) {
        this.id = id;
    }

    public Company( String companyName,int employeesNumber,List<Employee> employees) {
        this.companyName = companyName;
        this.employees = employees;
        this.employeesNumber = employeesNumber;
    }

//    public Company(long id, String companyName) {
//        this.id = id;
//        this.companyName = companyName;
//    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
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
