package com.company.hr.service;

import com.company.hr.service.representation.EmployeeRepresentation;
import com.company.hr.service.representation.EmployeeRequest;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface EmployeeService {

    ResponseEntity<Set<EmployeeRepresentation>> getEmployees();
    ResponseEntity<EmployeeRepresentation> getEmployee(String employeeId);
    ResponseEntity<EmployeeRepresentation> createEmployee(EmployeeRequest employeeRequest);

    //public Response updateEmployee(EmployeeRequest employeeRequest);
    //public Response deleteEmployee(String employeeId);
}
