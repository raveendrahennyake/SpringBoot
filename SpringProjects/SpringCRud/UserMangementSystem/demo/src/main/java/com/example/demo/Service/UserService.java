package com.example.demo.Service;
import com.example.demo.D.T.O.Req.UserRequst;
import com.example.demo.Model.User;
import com.example.demo.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private Repository repository;
    public List<User> getUser() {
        return repository.findAll();
    }
    public Optional<User> getuser(Integer id) {
        return repository.findById(id);
    }
    public ResponseEntity<User> addUser(@RequestBody UserRequst userRequst) {
        User user = new User();
        user.setName(userRequst.getName());
        repository.save(user);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<String> updateUser(@RequestParam UserRequst userRequst, @RequestParam Integer id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userRequst.getName());
            user.setPassword(userRequst.getPassword());
            user.setEmail(userRequst.getEmail());
            repository.save(user);
            return ResponseEntity.ok("User data is Update");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity <String> delectUser (@RequestParam Integer id) {
        Optional<User> optionalUser=repository.findById(id);
        if(optionalUser.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok("User is Delects");

        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
