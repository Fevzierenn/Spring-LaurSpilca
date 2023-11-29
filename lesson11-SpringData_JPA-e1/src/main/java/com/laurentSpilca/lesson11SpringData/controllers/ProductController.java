package com.laurentSpilca.lesson11SpringData.controllers;

import com.laurentSpilca.lesson11SpringData.entities.Product;
import com.laurentSpilca.lesson11SpringData.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController( ProductService productService)
    {
        this.productService=productService;
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping("/get/{name}")
    public Product getProduct(@PathVariable String name){
        return productService.findProductByName(name);
    }
    @GetMapping("/getId/{id}")
    public Product getProduct2(@PathVariable Integer id){
        return productService.findProductById(id);
    }
}
