package com.laurentSpilca.lesson11SpringData.repositories;

import com.laurentSpilca.lesson11SpringData.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Integer> {
     Product findProductByName(String name);      //spring jpa method ismi ile ilgili query'i bizim icin yapacaktır fakat istenirse kendimiz de query yazabiliriz.

     @Query("SELECT p FROM Product p WHERE p.id=:identity") //identity ile method icindeki id eslesmeli. ya ayni isim olmali ya da @Param ile belirtilmeli.
     Product findProduct(@Param("identity") int id);
}
