package io.herald.MySpringWeb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller  //handles HTTP requests: GET, POST, etc.
public class MappingClass {


    @GetMapping("/")   //url pattern for mappping
    public String openFirstPage(){
        return "FirstPage";
    }

    //url in this point was fixed
    @GetMapping("/NextPage")
    public String openNextPage(){
        return "NextPage";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
