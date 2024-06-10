package com.example.demo.controller;
import com.example.demo.DTO.Request.EmployerDTO;
import com.example.demo.model.Employer;
import com.example.demo.service.EmpolyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Employer")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployerControl {
    
    @Autowired
    private EmpolyerService empolyerService;
    @PostMapping("/addEmployer")
    public ResponseEntity<Employer> AddEmployer (@RequestBody EmployerDTO employerDTO) {
        return empolyerService.AddEmployer(employerDTO);
    }

    @GetMapping("/getEmployer")
    public List<Employer> getEmployer() {
        return empolyerService.getEmployer();
    }
    @GetMapping("/{id}")
    public Optional<Employer> getEmployers (@PathVariable Integer id) {
        return empolyerService. getEmployers(id);
    }


}
