package com.laurentSpilca.lesson11SpringData.services;

import com.laurentSpilca.lesson11SpringData.entities.Product;
import com.laurentSpilca.lesson11SpringData.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product findProductByName(String name) {
        return productRepository.findProductByName(name);
    }
    public Product findProductById(int id) {
        return productRepository.findProduct(id);
    }
}
