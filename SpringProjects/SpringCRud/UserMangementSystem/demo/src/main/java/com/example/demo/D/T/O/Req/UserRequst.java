package com.example.demo.D.T.O.Req;
import jakarta.persistence.Entity;
import lombok.Data;
@Entity
@Data
public class UserRequst {
    private String name;
    private String address;
    private String email;
    private String password;



}
