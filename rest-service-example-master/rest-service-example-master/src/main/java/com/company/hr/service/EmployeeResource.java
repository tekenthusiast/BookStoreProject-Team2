package com.company.hr.service;

import com.company.hr.service.representation.EmployeeRepresentation;
import com.company.hr.service.representation.EmployeeRequest;
import com.company.hr.service.workflow.EmployeeActivity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/employeeservice/")
@Api(value ="EmployeeResource")
public class EmployeeResource implements EmployeeService {
    @Autowired
    private EmployeeActivity empActivity;


    @GetMapping(value = "/employee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    //@Cacheable(cc="public, maxAge=3600") example for caching
    @ApiOperation(value = "Get all employees")
    public ResponseEntity<Set<EmployeeRepresentation>> getEmployees() {
        System.out.println("GET METHOD Request for all employees .............");
        return ResponseEntity
                .ok()
                .body(empActivity.getEmployees());
    }

    @GetMapping(value = "/employee/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<EmployeeRepresentation> getEmployee(@PathVariable("employeeId") String id) {
        System.out.println("GET METHOD Request from Client with employeeRequest String ............." + id);
        EmployeeRepresentation response = empActivity.getEmployee(id);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @PostMapping(value = "/employee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<EmployeeRepresentation> createEmployee(EmployeeRequest  employeeRequest) {
        System.out.println("POST METHOD Request from Client with ............." + employeeRequest.getFirstName() + "  " + employeeRequest.getLastName());
        return ResponseEntity
                .ok()
                .body(empActivity.createEmployee(employeeRequest.getFirstName(), employeeRequest.getLastName()));
    }

    @DeleteMapping(value = "/employee/{employeeId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") String id) {
        System.out.println("Delete METHOD Request from Client with employeeRequest String ............." + id);
        String res = empActivity.deleteEmployee(id);
        if (res.equals("OK")) {
            return ResponseEntity
                    .ok()
                    .body("OK");
        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred");
    }

}