package com.example.RestEndpointe2.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class HelloController {

    //@RequestMapping(path = "/test", method = RequestMethod.GET)
    @GetMapping(path = "/test")
    public String test(@RequestHeader String a, @RequestHeader String b,@RequestHeader String c)
    {
        return a+" "+b+" "+c;
    }

    @PostMapping(path = "/test/{isim}")
    public String test2(@PathVariable(value = "isim") String name,@RequestBody String body,@RequestHeader String a, @RequestHeader String b,@RequestHeader String c)
    {
        return name+" "+ a+" "+b+" "+c+ " "+ body;
    }

    @GetMapping("/headers")
    public Map<String, String > headers(@RequestHeader Map<String, String> map)     //gelen tüm key-value değerlerini tek bir map'e atama işlemi.
    {
        return map;
    }

    //header kısmına HttpServletResponse ile head atama.
    //this are the posibilities outputting data from endpoint;
    //birkaç yol ise şöyle-> body of the response, status of the response, adding a header
    @GetMapping(path = "/headers2/{isim}")
    public String test3(@PathVariable(value = "isim") String name,
                        @RequestHeader String a, @RequestHeader String b, @RequestHeader String c,
                        HttpServletResponse response)
    {
        response.addHeader("NAME","Fevzi Eren");
        return name+" "+ a+" "+b+" "+c+ " "+ response;
    }

    //bir pdf verisini alma( sadece yol gosterme amaclı)
    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] file(){
        byte [] file = new byte[100];
        return file;
    }


}
