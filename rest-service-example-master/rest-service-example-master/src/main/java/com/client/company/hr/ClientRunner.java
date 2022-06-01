package com.client.company.hr;

import com.client.company.hr.domain.EmployeeCreateRequest;
import com.client.company.hr.domain.EmployeeResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.util.Set;

@Service
@Component


public class ClientRunner {

    HrClient hrClient;
    @Autowired
    public void ClientRunner(HrClient hrClient) {
        this.hrClient = hrClient;
        runClient();
    }

    public void runClient() {
        /*****************************************************************************************
         * GET METHOD invoke
         *****************************************************************************************/
        System.out.println("GET METHOD .........................................................");

        EmployeeResponse response = hrClient.getEmployee("XY1111");
        System.out.println("GET METHOD Response: ...." + response);

        /*****************************************************************************************
         * POST METHOD invoke
         *****************************************************************************************/
        System.out.println("POST METHOD .........................................................");


        // change application/xml  to application/json get in json format

        EmployeeCreateRequest employeeRequest = new EmployeeCreateRequest();
        employeeRequest.setFirstName("Michael");
        employeeRequest.setLastName("Gerard");

        String createdEmployee = hrClient.createEmployee(employeeRequest).toString();

        System.out.println("POST MEDTHOD Response ........." + createdEmployee);

        /*****************************************************************************************
         * GET METHOD invoke for all employees
         *****************************************************************************************/
        System.out.println("GET METHOD for all employees..........................................");

        Set<EmployeeResponse> getAllResponse = hrClient.getEmployees();
        System.out.println("GET All METHOD Response: ...." + getAllResponse);

        /*****************************************************************************************
         * DELETE METHOD invoke
         *****************************************************************************************/
        System.out.println("DELETE METHOD .........................................................");
        String deleteMsg = hrClient.deleteEmployee("XY1111");
        System.out.println("DELETE MEDTHOD Response ........." + deleteMsg);
    }


}
