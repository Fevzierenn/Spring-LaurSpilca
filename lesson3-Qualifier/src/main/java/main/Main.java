package main;

import config.ProjectConfig;
import components.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person p1 = context.getBean(Person.class);

        p1.sayHello("Eren");


    }
}
