package BeanEkleme.BeanContext.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "BeanEkleme/BeanContext/beans")
@ComponentScan({"BeanEkleme/BeanContext/repositories","BeanEkleme/BeanContext/service"})
public class ProjectConfig {
//
//   @Bean("valueOfBean1")
//   //@Primary //iki bean olunca hangisinin ele alınması gerektiğini belirtiriz
//    public MyBean myBean1(){
//        MyBean b = new MyBean();
//        b.setText("i am a bean");
//        return b;
//    }
//    @Bean("valueOfBean2")
//    public MyBean myBean2(){
//        MyBean b = new MyBean();
//        b.setText("i am a bean 2 ");
//        return b;//}
}
