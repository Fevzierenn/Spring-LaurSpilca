package com.example.RestEndpointe2.services;


import com.example.RestEndpointe2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public void addProduct(String name){
        productRepository.addProduct(name);
    }
}
