package BeanEkleme.BeanContext;

import BeanEkleme.BeanContext.beans.MyBean;
import BeanEkleme.BeanContext.config.ProjectConfig;
import BeanEkleme.BeanContext.service.ProductDeliveryService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanContextApplication {

	public static void main(String[] args) {

		try (
				AnnotationConfigApplicationContext context =
						new AnnotationConfigApplicationContext(ProjectConfig.class)) {

			ProductDeliveryService service = context.getBean(ProductDeliveryService.class);
			service.addSomeProducts();






//			MyBean b1 = context.getBean(MyBean.class);	//context'te olan instanceyi objeye atarız. Ama genelde @AutoWired vb.kullanılır.
//			MyBean b2 = context.getBean(MyBean.class);
//			//MyBean b3 = context.getBean("valueOfBean1",MyBean.class);
//			//MyBean b3 = context.getBean("myBean1",MyBean.class); name ile bean cagrilabilir
//			System.out.println(b1.getText());
//			System.out.println(b2.getText());
//			//System.out.println(b3.getText());

		}
	}

}
