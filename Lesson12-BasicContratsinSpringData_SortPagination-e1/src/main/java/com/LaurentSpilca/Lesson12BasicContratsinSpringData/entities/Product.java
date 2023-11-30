package com.LaurentSpilca.Lesson12BasicContratsinSpringData.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")    //class ismi ile table ismi aynı olursa bu tanımı yapmaya gerek kalmaz
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
