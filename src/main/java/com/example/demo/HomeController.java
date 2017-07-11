package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by daylinhenry on 7/10/17.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }
}
