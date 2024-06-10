package com.example.demo.service;

import com.example.demo.DTO.Request.EmployerDTO;
import com.example.demo.model.Employer;
import com.example.demo.repository.EmployerRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmpolyerService {
    @Autowired
    private EmployerRepositor employerRepositor;
    public ResponseEntity<Employer> AddEmployer (@RequestBody EmployerDTO employerDTO ) {
       Employer employer=new Employer();
       employer.setAddress(employerDTO.getAddress());
       employer.setEmployerName(employerDTO.getEmployerName());
       employer.setAddress(employerDTO.getAddress());
       employer.setPhonenumber(employerDTO.getPhonenumber());
       employerRepositor.save(employer);
        return ResponseEntity.ok(employer);

    }
    public List <Employer>getEmployer () {
        return employerRepositor.findAll();

    }

    public Optional<Employer> getEmployers (@PathVariable Integer id) {
        return employerRepositor.findById(id);
    }

}
