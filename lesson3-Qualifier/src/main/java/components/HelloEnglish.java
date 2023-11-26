package components;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("english")
public class HelloEnglish implements IHello{

    @Override
    public String sayHello(String name) {
        return "Hi mr. or mrs. " + name +"!";
    }
}
