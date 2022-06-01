package com.client.company.hr;

import com.client.company.hr.domain.EmployeeCreateRequest;
import com.client.company.hr.domain.EmployeeResponse;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;


@FeignClient(name = "HrClient", url = "localhost:8080")
public interface HrClient {

    @RequestMapping(method = RequestMethod.GET, value = "/employeeservice/employee")
    Set<EmployeeResponse> getEmployees();

    @RequestMapping(method = RequestMethod.GET, value = "/employeeservice/employee/{employeeId}")
    EmployeeResponse getEmployee(@PathVariable("employeeId") String employeeId);

    @RequestMapping(method = RequestMethod.POST, value = "/employeeservice/employee", consumes = "application/json")
    EmployeeCreateRequest createEmployee(@RequestBody EmployeeCreateRequest request);

    @RequestMapping(method = RequestMethod.DELETE, value = "/employeeservice/employee/{employeeId}")
    String deleteEmployee(@PathVariable("employeeId") String employeeId);
}
