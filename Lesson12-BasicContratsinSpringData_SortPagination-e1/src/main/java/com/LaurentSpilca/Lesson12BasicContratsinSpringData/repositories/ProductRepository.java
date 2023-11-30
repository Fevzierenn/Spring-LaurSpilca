<<<<<<< HEAD
package com.LaurentSpilca.Lesson12BasicContratsinSpringData.repositories;

import com.LaurentSpilca.Lesson12BasicContratsinSpringData.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer> {
        public List<Product> findProductsByName(String name, Sort s);           //s -> Sort.by("id").descending() ornegi olabilir.
        public List<Product> findProductsByName(String name, Pageable p);   // p-> Pageable p = PageRequest.of(page, 2, Sort.by("id").descending());        //Sort ile Pagination birlikte bu sekilde kullanılabilir.
}

