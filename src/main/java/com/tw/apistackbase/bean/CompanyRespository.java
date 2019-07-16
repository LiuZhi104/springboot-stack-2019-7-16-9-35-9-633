package com.tw.apistackbase.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CompanyRespository {
    private List<Company> companies=new ArrayList<>();
    public void add(Company company){
        this.companies.add(company);
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
