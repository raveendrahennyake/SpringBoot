package com.example.demo.Control;
import com.example.demo.D.T.O.Req.UserRequst;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/User")
@Entity
public class UserControl {
    @Autowired
    private UserService userService;
    @GetMapping("/getUser")
    public List<User> getUser() {
        return userService.getUser();
    }
    @GetMapping("/getUser/{id}")
    public Optional<User> getuser(@PathVariable Integer id) {
        return userService.getuser(id);
    }
    @PostMapping("/addUser")
    public ResponseEntity <User> addUser (@RequestBody UserRequst userRequst) {
        return userService.addUser (userRequst);

    }
    @PutMapping("/updateUser")
    public ResponseEntity <String> updateUser (@RequestBody UserRequst userRequst,@RequestParam Integer id){
        return userService.updateUser(userRequst,id);

    }
    @DeleteMapping("/delectUSer")
    public ResponseEntity <String> delectUser (@RequestParam Integer id){
        return userService.delectUser(id);

    }



}

