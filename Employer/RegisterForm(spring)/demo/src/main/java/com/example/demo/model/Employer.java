package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name ="employer")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer employerId;

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhonenumber(Integer phonenumber) {
        Phonenumber = phonenumber;
    }

    public Integer getEmployerId() {
        return employerId;
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
    private String employerName;
    private  String address;
    private  Integer Phonenumber;

}
