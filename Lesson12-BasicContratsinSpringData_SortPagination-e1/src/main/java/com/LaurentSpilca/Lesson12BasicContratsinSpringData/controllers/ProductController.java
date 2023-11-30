<<<<<<< HEAD
package com.LaurentSpilca.Lesson12BasicContratsinSpringData.controllers;

import com.LaurentSpilca.Lesson12BasicContratsinSpringData.entities.Product;
import com.LaurentSpilca.Lesson12BasicContratsinSpringData.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/get/{id}")
    public Product findById(@PathVariable int id){
        return productRepository.findById(id).orElse(null);
    }


    @GetMapping("/sort")
    public Iterable<Product> getAllSortedDescendingById(){
        return productRepository.findAll(Sort.by("id").descending());   //id'ye gore sırala desc-> z to a or 99 to 1 (artandan azalana) descending=azalan
    }

    @GetMapping("/page/{page}")
    public List<Product> getProductsByPage(@PathVariable int page){
        Sort s= Sort.by("id").descending();
        return productRepository.findAll(PageRequest.of(page, 3,s)).getContent(); //page-> toplam veri page size'a bolunur ve page ile istenilen sayfadaki bilgiler alınır
                                                                                        //database'de cok fazla veri olabilir pagination ile loading problemlerine onlem alınabilir.
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name){
        return productRepository.findProductsByName(name, Sort.by("id").descending());
    }

    @GetMapping("/name/{name}/{page}")
    public List<Product> getProductsWithPagination(@PathVariable String name, @PathVariable int page)
    {
        Pageable p = PageRequest.of(page, 2, Sort.by("id").descending());
        return productRepository.findProductsByName(name,p);
    }


}

