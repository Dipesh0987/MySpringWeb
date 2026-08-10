package io.herald.MySpringWeb.Controller;

import io.herald.MySpringWeb.Model.UserTable;
import io.herald.MySpringWeb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class SignUpController {

    @Autowired
    private PasswordEncoder passwordEncoder;


//    @Autowired
//    private JavaMailSender mailSender;


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
    public String postSignup(HttpServletRequest request, Model m){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //MDS hashing - crackable
        // String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes())
        String hashPassword = passwordEncoder.encode(password);

        UserTable user =  new UserTable();
        user .setUsername(username);
        user.setPassword(hashPassword);


        uRepo.save(user);
        //mail sender
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Signup Successful");
        message.setText("Welcome "+username+"!");
//        mailSender.send(message);

        System.out.println(username);
        System.out.println(password);



        //model ko m vanne object le message liyera gako -> login.html lai
        //message lai attribute vaninxa model ko vasa ma

        // m.attribute(msg title, message)
        m.addAttribute("SignupSuccess", "You have successfully signed up");
        return "login.html";
    }
}
