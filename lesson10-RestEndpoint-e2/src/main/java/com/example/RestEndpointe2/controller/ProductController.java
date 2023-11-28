package com.example.RestEndpointe2.controller;

import com.example.RestEndpointe2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping(path = "/add/{name}")
    public void addProduct(@PathVariable String name){
        productService.addProduct(name);
    }
}
