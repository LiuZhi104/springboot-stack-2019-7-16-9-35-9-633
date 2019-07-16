package com.tw.apistackbase.controller;

import com.tw.apistackbase.bean.Company;
import com.tw.apistackbase.bean.CompanyRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CompanyController {
        private CompanyRespository companyRespository=new CompanyRespository();
         @GetMapping("/companies")
         public ResponseEntity getAllCompanies(){
             Company company=new Company(1,"sss");
            companyRespository.add(company);
            return ResponseEntity.ok(companyRespository.getCompanies());
        }
        
}
