package com.example.RestEndpointe2.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public void addProduct(String name)
    {
        String sqlQuery ="INSERT INTO demo VALUES (NULL,?)";
        jdbcTemplate.update(sqlQuery,name);
    }
}
