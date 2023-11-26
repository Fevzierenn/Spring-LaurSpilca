package BeanEkleme.BeanContext.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component    component genel adıdır. Contexte instance eklenmesi için repository annotationu kullanılabilir.
@Repository
public class ProductRepository {

    public void add(){
        System.out.println("new product was added");
    }
}
