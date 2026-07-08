package io.herald.MySpringWeb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller  //handles HTTP requests: GET, POST, etc.
public class MappingClass {



    @GetMapping("/")   //url pattern for mappping
    public String openFirstPage(){
        return "FirstPage.html";
    }

    @GetMapping("/nextPage")
    public String openNextPage(){
        return "NextPage.html";
    }
    @GetMapping("/login")
    public String login(){
        return "login.html";
    }
}
