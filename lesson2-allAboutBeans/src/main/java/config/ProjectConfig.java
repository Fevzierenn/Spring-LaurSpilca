package config;

import beans.Cat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"beans"})
public class ProjectConfig {

    @Bean
//    @Primary  aynı tipten birden fazla bean varsa primary ile öncelik verilebilir.
    @Qualifier("bean1")
    public Cat cat1(){
    Cat c = new Cat();
    c.setName("cat1");
    return c;
    }
    @Bean
    @Qualifier("bean2")
    public Cat cat2(){
        Cat c = new Cat();
        c.setName("cat2");
        return c;
    }





//    @Bean
//    public Cat cat()
//    {
//        Cat tempCat = new Cat();
//        System.out.println("Cat bean icinde cat olustu id:"+ tempCat.getCatId());
//        tempCat.setName("Tom");
//        return tempCat;
//    }
//
//    @Bean
//    //@Autowired        eski sürümlerde görülür. iki bean ile wired edilir.
//    public Owner owner(Cat cat){
//        Owner tempOwner = new Owner();
//        tempOwner.setCat(cat);  //Bean olduğu için context içinden direkt Cat instancesi verilecektir.
//        return tempOwner;
//
//    }

//    @Bean
//    public Owner owner(){
//        Owner tempOwner= new Owner();
//        //System.out.println("Owner bean icinde owner olustu. kedisinin id:"+ tempOwner.getCat().getCatId());
//        //tempOwner.setCat(new Cat());
//        tempOwner.setCat(cat());
//        System.out.println("owner'a cat atandı. cat ıd:"+ tempOwner.getCat().getCatId());
//        return tempOwner;
//    }
}
