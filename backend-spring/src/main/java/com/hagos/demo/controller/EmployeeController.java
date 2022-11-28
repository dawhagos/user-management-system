package com.hagos.demo.controller;

import com.hagos.demo.entity.Employee;
import com.hagos.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        System.out.println("POST /api/v1/employees endpoint invoked");
        return ResponseEntity.status(201).body(employeeService.createEmployee(employee));
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees() {
        System.out.println("GET /api/v1/employees endpoint invoked");
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        System.out.println("DELETE /api/v1/employees/" + id + " endpoint invoked");
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        System.out.println("GET /api/v1/employees" + id + " endpoint invoked");
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        System.out.println("PUT /api/v1/employees/" + id + " endpoint invoked");
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }


}
