package com.company.hr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.company.hr.dal.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager {

    @Autowired
    private  EmployeeDAO dao;

    public Set<Employee> getAllEmployees(){
        return dao.getAllEmployees();
    }

    public Employee getEmployee(String id) {
        return dao.getEmployee(id);
    }


    public Employee addEmployee(String firstName, String lastName) {

        Employee emp = dao.addEmployee(firstName, lastName);

        return emp;
    }

    public void updateEmployee(String id, long salary) {
        dao.updateEmployee(id, salary);
    }

    public void deleteEmployee(String id) {
        dao.deleteEmployee(id);
    }

}
