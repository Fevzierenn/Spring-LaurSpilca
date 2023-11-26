package BeanEkleme.BeanContext.beans;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private String text;

    @PostConstruct  //MyBean bileşeni oluşturulduktan hemen sonra çağrılır. Context yapısı içinde olmazsa çağrılmaz(MyBean b1 = new MyBean() gibi)
    private void init()
    {
        this.text="inside of the init function.";
    }

    public void setText(String text){
        this.text=text;
    }
    public String getText(){
        return this.text;
    }
}
