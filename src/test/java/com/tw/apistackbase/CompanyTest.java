package com.tw.apistackbase;

import com.tw.apistackbase.bean.Company;
import com.tw.apistackbase.bean.CompanyRespository;
import com.tw.apistackbase.bean.Employee;
import com.tw.apistackbase.controller.CompanyController;
import org.junit.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.actuate.metrics.web.servlet.WebMvcTags.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CompanyController companyController;
    @MockBean
    private CompanyRespository companyRespository;
    @Test
    public void should_return_companys_when_get() throws Exception {
        Employee employee=new Employee(4,"alibaba1",20,"male",6000);
        Employee firstEmployee=new Employee(11,"tunxun2",19,"female",7000);
        Employee secondEmployee=new Employee(6,"alibaba3",19,"male",8000);
        Employee thirdEmployee=new Employee(13,"alibaba5",20,"male",6000);
        Employee fourEmployee=new Employee(10,"alibaba8",20,"male",6000);
        List<Employee> employees=new ArrayList<>();
        employees.add(employee);
        employees.add(firstEmployee);
        employees.add(secondEmployee);
        employees.add(thirdEmployee);
        employees.add(fourEmployee);
        List<Company> mockList=new ArrayList<>();
        mockList.add( new Company("alibaba",200,employees));
        Mockito.when(companyRespository.getCompanies()).thenReturn(mockList);
        mockMvc.perform(get("/companies")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().json("[\n" +
                "    {\n" +
                "        \"id\": 0,\n" +
                "        \"companyName\": \"alibaba\",\n" +
                "        \"employees\": [\n" +
                "            {\n" +
                "                \"id\": 4,\n" +
                "                \"name\": \"alibaba1\",\n" +
                "                \"age\": 20,\n" +
                "                \"gender\": \"male\",\n" +
                "                \"salary\": 6000\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 11,\n" +
                "                \"name\": \"tunxun2\",\n" +
                "                \"age\": 19,\n" +
                "                \"gender\": \"female\",\n" +
                "                \"salary\": 7000\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 6,\n" +
                "                \"name\": \"alibaba3\",\n" +
                "                \"age\": 19,\n" +
                "                \"gender\": \"male\",\n" +
                "                \"salary\": 8000\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 13,\n" +
                "                \"name\": \"alibaba5\",\n" +
                "                \"age\": 20,\n" +
                "                \"gender\": \"male\",\n" +
                "                \"salary\": 6000\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 10,\n" +
                "                \"name\": \"alibaba8\",\n" +
                "                \"age\": 20,\n" +
                "                \"gender\": \"male\",\n" +
                "                \"salary\": 6000\n" +
                "            }\n" +
                "        ],\n" +
                "        \"employeesNumber\": 200\n" +
                "    }\n" +
                "]"
               ));
    }
    @Test
    public void should_return_company_when_get() throws Exception {
        List<Company> mockList=new ArrayList<>();
        mockList.add(new Company(1,"sss"));
        Mockito.when(companyRespository.getCompanies()).thenReturn(mockList);
        mockMvc.perform(get("/companies/1")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().json(
                "{\n" +
                "    \"id\": 1,\n" +
                "    \"companyName\": \"sss\"\n" +
                "}"
        ));
    }

}
