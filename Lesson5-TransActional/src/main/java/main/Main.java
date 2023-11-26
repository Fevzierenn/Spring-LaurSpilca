package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import config.ProjectConfig;
import repositories.ProductRepository;
import services.ProductService;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("main package");
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
			var productService = context.getBean(ProductService.class);
			//productService.addProduct("Gin");
			//productService.addProduct("Beer");
			productService.addProduct("Vodka");
			//int answer=productService.deleteProductById(1);
			//System.out.println(answer);
					
	}

}
