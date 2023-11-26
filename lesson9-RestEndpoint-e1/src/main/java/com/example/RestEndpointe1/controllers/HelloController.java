package com.example.RestEndpointe1.controllers;


import com.example.RestEndpointe1.dto.Person;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody   //static icinden html sayfası arar ve render etmeye calısır. @RestController = @Controller + @ResponseBody
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    public String hello(@PathVariable(name = "name") String isim){
        return "Hello my lonely loser friend."+ isim;
    }
    @GetMapping("/hello2/{isim}")
    public String sayHello(@PathVariable String isim){
        return "Hey "+ isim;
    }

    @PostMapping(path = "/goodbye")
    public String sayGoodBye(@RequestBody Person person){    //person request'in body'sinden alınmalı
        return "Goodbye "+ person.getName() + "!...";
    }

    @GetMapping("/getPerson")
    public Person getPerson(){
        Person p = new Person();
        p.setName("Eren");
        return p;       //person objesini Json olarak doner.
    }

    @GetMapping("/getPeople")
    public List<Person> getPeople(){
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setName("isim "+ i);
            personList.add(p);
        }
        return personList;
    }

    @GetMapping("/status")
    public void statusContent(HttpServletResponse status)
    {
        status.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

   
}
