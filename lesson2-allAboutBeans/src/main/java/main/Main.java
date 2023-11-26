package main;

import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Owner o = context.getBean(Owner.class);
       // Cat c = context.getBean(Cat.class);
        System.out.println(o);


//        System.out.println(o);
//        System.out.println(c);      //cat name kedi olsun
//        c.setName("Föwz");          //cat component old. için beandir. contexte gidilir kedi ismi Föwz yapılır ve Cat beanini inject eden tüm beanler ya da fieldlar Föwz olur. Çünkü default singleton?
//        System.out.println(o);
//        System.out.println(c);
//        System.out.println(new Cat().getCatId());       //cat id 1
//        System.out.println(new Cat().getCatId());       //cat id 2 bean ile alakalı değil. normal cat instancesi alınır.


    }
}
