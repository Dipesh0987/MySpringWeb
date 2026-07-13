package io.herald.MySpringWeb.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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

    @PostMapping("/login")
    public String loginPost(HttpServletRequest request){
        request.getParameter( "username");
        request.getParameter( "password");
        String username = request.getParameter( "username") ;
        String password = request.getParameter( "password");
        //when a from data does post request, httpServletRequest obtains those data as parameters
        // in controller

        if(username.equals("admin") && password.equals("admin")){
            return "HomePage";
        }else{
            return "login";
        }

    }


}
