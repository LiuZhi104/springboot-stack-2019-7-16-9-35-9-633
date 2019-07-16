package com.tw.apistackbase.controller;

import com.tw.apistackbase.bean.Company;
import com.tw.apistackbase.bean.CompanyRespository;
import com.tw.apistackbase.bean.Employee;
import com.tw.apistackbase.bean.EmployeeRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private EmployeeRespository employeeRespository= new EmployeeRespository();

    @GetMapping("/employees")
    public ResponseEntity getAllEmployees() {
        Employee employee = new Employee(4, "alibaba1", 20, "male", 6000);
        Employee firstEmployee = new Employee(11, "tunxun2", 19, "female", 7000);
        Employee secondEmployee = new Employee(6, "alibaba3", 19, "male", 8000);
        Employee thirdEmployee = new Employee(13, "alibaba5", 20, "male", 6000);
        Employee fourEmployee = new Employee(10, "alibaba8", 20, "male", 6000);
        employeeRespository.add(employee);
        employeeRespository.add(firstEmployee);
        employeeRespository.add(secondEmployee);
        employeeRespository.add(thirdEmployee);
        employeeRespository.add(fourEmployee);
        return ResponseEntity.ok(employeeRespository.getCompanies());
    }
    @GetMapping("/employees/{id}")
    public Employee getSpecialEmployee(@PathVariable long id) {
        return employeeRespository.getCompanies().stream().filter(element->element.getId()==id).findFirst().get();
    }
    @GetMapping("/employees?page=1&pageSize=5")
    public ResponseEntity getHasPageAndPageSizeEmployee(@RequestParam int page, @RequestParam int pageSize) {
        if (page == 1 && pageSize == 5) {
            return ResponseEntity.ok(employeeRespository.getCompanies());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("employees?gender=male")
    public ResponseEntity getEmployeeOfMale(@PathVariable String gender){
      Employee employee= employeeRespository.getCompanies().stream().filter(elemet->elemet.getGender()=="male").findFirst().get();
      return ResponseEntity.ok(employee);
    }
    @PostMapping("/employees")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employee.setId(1);
        employeeRespository.add(employee);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable long id) {
       Employee employee = employeeRespository.getCompanies().stream().filter(update ->update.getId() == id).findFirst().orElse(null);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable long id) {
        Employee employee=employeeRespository.getCompanies().stream().filter(delete->delete.getId()== id).findFirst().get();
        if(employee != null){
            return ResponseEntity.ok(employeeRespository.getCompanies().remove(employee));
        }
        return  ResponseEntity.notFound().build();
    }

}
