package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
//	EmployeeService is injected as a dependency using @Autowired annotation.
        @Autowired
        EmployeeService empService;
        
        //New employee
//        @RequestBody annotation is used to map the request body of the endpoint to the method parameter. emp will contain the request JSON passed to this endpoint.
        @RequestMapping(value="/employees", method=RequestMethod.POST)
        public Employee createEmployee(@RequestBody Employee emp) {
            return empService.createEmployee(emp);
        }
        
        //read employee
        @RequestMapping(value="/employees", method=RequestMethod.GET)
        public List<Employee> readEmployees() {
            return empService.getEmployees();
        }

        
//        some methods include @PathVariable, meaning that the API endpoint has a path parameter involved. The @PathVariable will map the path variable provided in the value parameter of the endpoint to the Java method field.
        
        //update employee
        @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
        public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
            return empService.updateEmployee(id, empDetails);
        }

        //delete employee
        @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
        public void deleteEmployees(@PathVariable(value = "empId") Long id) {
            empService.deleteEmployee(id);
        }

        
        

}
