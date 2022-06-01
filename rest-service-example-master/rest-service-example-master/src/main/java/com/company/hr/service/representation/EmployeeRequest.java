package com.company.hr.service.representation;

public class EmployeeRequest {

    private String firstName;
    private String lastName;

    public EmployeeRequest() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}