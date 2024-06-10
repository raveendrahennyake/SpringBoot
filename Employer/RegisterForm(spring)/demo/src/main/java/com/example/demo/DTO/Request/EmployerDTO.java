package com.example.demo.DTO.Request;

import jakarta.persistence.Entity;

public class EmployerDTO {
    private String employerName;
    private  String address;

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhonenumber(Integer phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPhonenumber() {
        return Phonenumber;
    }

    private  Integer Phonenumber;





}




