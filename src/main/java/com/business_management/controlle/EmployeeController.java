package com.business_management.controlle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business_management.service.EmployeeService;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

}
