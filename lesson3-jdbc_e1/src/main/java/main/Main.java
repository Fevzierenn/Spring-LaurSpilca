package main;

import config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.ProductRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
//        Product product1 = new Product("Beer",5.65);
//        productRepository.addProduct(product1);

//        productRepository.addProduct(new Product("Champagne",1234.12));
//        productRepository.addProduct(new Product("Vodka",23.31));
//        productRepository.addProduct(new Product("Gin",41.44));

        int donut=productRepository.updateProductNameById(3,"Vodka");
        System.out.println(donut);

        List<Product> productList = productRepository.getProducts();
        productList.forEach(System.out::println);
    }
}
