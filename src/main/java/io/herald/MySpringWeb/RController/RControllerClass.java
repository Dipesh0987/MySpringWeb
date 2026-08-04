package io.herald.MySpringWeb.RController;


import io.herald.MySpringWeb.Model.UserTable;
import io.herald.MySpringWeb.Repository.ImageRepository;
import io.herald.MySpringWeb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RControllerClass {

    @Autowired
    private ImageRepository imageRepo;
    @Autowired
    private UserRepository userRepo;


    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/getAllUsers")
    public List<UserTable> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody UserTable user) {

        //@requestbody -> json ma data aako xa vane, requestbody lekhna parxa
        userRepo.save(user);
        return "saved successfully";
    }

    @GetMapping("/getOne/{id}")
    public UserTable getOne(@PathVariable int id) {
        UserTable u = userRepo.findById(id).get();
        return u;


    }
    @GetMapping("/getId/{id}")
    public ResponseEntity<?> getId(@PathVariable int id) {
        if(userRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(userRepo.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
