package com.example.SpringBoot101.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
//@RestController // method ici static icindeki html sayfasını render etmez. Method ici okunur.
public class HelloController {
    @RequestMapping("/hello")
    //@ResponseBody   // class ustunde de yazılabilir. Olmazsa static icinde html sayfası render edilmeye calısılır.
    //@Controller + @ResponseBody = @RestController
    public String sayHello(){
        return "Hello world";
    }
}
