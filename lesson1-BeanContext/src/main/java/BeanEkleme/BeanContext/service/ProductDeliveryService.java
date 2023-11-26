package BeanEkleme.BeanContext.service;

import BeanEkleme.BeanContext.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component genel kullanımdır. Service annotationu da kullanabiliriz.
@Service
public class ProductDeliveryService {
     //@Autowired      //context'ten bean instancesini alır ve atamasını yapar.
      private final ProductRepository productRepository;      //field ile inject edilecekse final ile constant field olamaz cunku veri daha atanmadı.

    @Autowired
    public ProductDeliveryService(ProductRepository theRepo){         //ctor injection ile de context'te bulunan instanceyi(bean) inject edilebilir. @AutoWired ile aynıdır.
        this.productRepository=theRepo;               //bu sekilde olursa field'ı constant field yapmakta fayda var. private final ProductRepository productRepository;
    }
     public void addSomeProducts()
     {
         productRepository.add();
         productRepository.add();
         productRepository.add();

     }

}
