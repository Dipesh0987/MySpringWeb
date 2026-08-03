package io.herald.MySpringWeb.RController;


import io.herald.MySpringWeb.Model.UserTable;
import io.herald.MySpringWeb.Repository.ImageRepository;
import io.herald.MySpringWeb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RControllerClass {

    @Autowired
    private ImageRepository imageRepo;
    @Autowired
    private UserRepository userRepo;


    @GetMapping("/api/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/api/getAllUsers")
    public List<UserTable> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/api/saveUser")
    public String saveUser(@RequestBody UserTable user) {

        //@requestbody -> json ma data aako xa vane, requestbody lekhna parxa
        userRepo.save(user);
        return "saved successfully";
    }
}
