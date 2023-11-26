package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        ProductService pService = context.getBean(ProductService.class);
//        pService.addProduct("Bira");
            pService.addTenProduct();
    }
}
