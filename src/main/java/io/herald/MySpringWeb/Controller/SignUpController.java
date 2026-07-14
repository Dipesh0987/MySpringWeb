package io.herald.MySpringWeb.Controller;

import io.herald.MySpringWeb.Model.UserTable;
import io.herald.MySpringWeb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.charset.StandardCharsets;


@Controller
public class SignUpController {

    @Autowired
    //autowired annotation helps in dependency injection
    //when autowired is present, all the necessary dependency files are provided
     // to the autowired class
    //also new keyword is not required to satisfy the oop rule to create and object
    private UserRepository uRepo;



    @GetMapping("/signup")
    public String signup(){
        return "signup.html";
    }

    @PostMapping("/signup")
    public String postSignup(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //MDS hashing - crackable
        String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes());

        UserTable uc =  new UserTable();
        uc .setUsername(username);
        uc.setPassword(hashPassword);


        uRepo.save(uc);
        System.out.println(username);
        System.out.println(password);


        return "login.html";
    }
}
