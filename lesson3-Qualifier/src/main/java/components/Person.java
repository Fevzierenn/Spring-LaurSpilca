package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Autowired
    @Qualifier("english")       //2 bean arasında primary olan olsa da qualifier daha baskındır. iki beanden birinde primary olması ona oncelik saglar.
    private IHello sayHelloToFriends;

    public void sayHello(String name)
    {
        String message = sayHelloToFriends.sayHello(name);
        System.out.println(message);
    }
}
