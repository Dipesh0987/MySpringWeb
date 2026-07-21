package io.herald.MySpringWeb.Controller;


import io.herald.MySpringWeb.Model.UserTable;
import io.herald.MySpringWeb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id, Model m) {
        userRepository.deleteById(id);
        m.addAttribute("totalUsers", userRepository.findAll());
        return "home.html";
    }
    @GetMapping("/editUser")
    public String editUser(@RequestParam("id") int id, Model m) {
        UserTable user = userRepository.findById(id).orElse(null);

        m.addAttribute("user", user);

        return "edit.html";
    }
    @PostMapping("/updateUser")
    public String updateUser(HttpServletRequest request, Model m) {

        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserTable user = userRepository.findById(id).orElse(null);

        if(user != null){

            user.setUsername(username);

            if(password != null && !password.isEmpty()){
                String hashPassword =
                        DigestUtils.md5DigestAsHex(password.getBytes());
                user.setPassword(hashPassword);
            }
            userRepository.save(user);
        }
        m.addAttribute("totalUsers", userRepository.findAll());

        return "Home.html";
    }

}
