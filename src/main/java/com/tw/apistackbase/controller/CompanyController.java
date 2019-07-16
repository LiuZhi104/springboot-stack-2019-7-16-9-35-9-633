package com.tw.apistackbase.controller;

import com.tw.apistackbase.bean.Company;
import com.tw.apistackbase.bean.CompanyRespository;
import com.tw.apistackbase.bean.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CompanyController {
    private CompanyRespository companyRespository = new CompanyRespository();

    @GetMapping("/companies")
    public ResponseEntity getAllCompanies() {
        Employee employee = new Employee(4, "alibaba1", 20, "male", 6000);
        Employee firstEmployee = new Employee(11, "tunxun2", 19, "female", 7000);
        Employee secondEmployee = new Employee(6, "alibaba3", 19, "male", 8000);
        Employee thirdEmployee = new Employee(13, "alibaba5", 20, "male", 6000);
        Employee fourEmployee = new Employee(10, "alibaba8", 20, "male", 6000);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);
        employees.add(fourEmployee);
        Company Company = new Company("alibaba", 200, employees);
        companyRespository.add(Company);
        return ResponseEntity.ok(companyRespository.getCompanies());
    }

    @GetMapping("/companies/{id}")
    public Company getSpecialCompany(@PathVariable long id) {
        return companyRespository.getCompanies().stream().filter(element -> element.getId() == id).findFirst().get();
    }

    @GetMapping("/companies/{id}/employees")
    public ResponseEntity getSpecialCompanyOfEmployee(@PathVariable long id) {
        Company company=companyRespository.getCompanies().stream().filter(element -> element.getId() == id).findFirst().get();
        return ResponseEntity.ok(company);
    }

    @GetMapping("/companies?page=1&pageSize=5")
    public ResponseEntity getHasPageAndPageSize(@RequestParam int page, @RequestParam int pageSize) {
        if (page == 1 && pageSize == 5) {
            return ResponseEntity.ok(companyRespository.getCompanies());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/companies")
    public ResponseEntity createCompany(@RequestBody Company company) {
        company.setId(1);
        companyRespository.add(company);
        return ResponseEntity.ok(company);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity updateCompany(@PathVariable long id) {
        Company company = companyRespository.getCompanies().stream().filter(update ->update.getId() == id).findFirst().orElse(null);
        if (company != null) {
            return ResponseEntity.ok(company);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity deleteCompany(@PathVariable long id,@RequestBody Employee employee) {
        Company company=companyRespository.getCompanies().stream().filter(delete->delete.getId()== id).findFirst().get();
        if(company != null){
           return ResponseEntity.ok(company.getEmployees().remove(employee));
        }
        return  ResponseEntity.notFound().build();
    }
}


