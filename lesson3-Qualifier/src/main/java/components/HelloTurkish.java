package components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("turkish")
@Primary
public class HelloTurkish implements IHello{

    @Override
    public String sayHello(String name) {
      return "Merhaba bay ya da bayan "+ name+"!";
    }
}
