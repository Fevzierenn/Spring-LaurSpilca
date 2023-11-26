package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Owner {
//        @Autowired(required = false)  olur da bean yoksa default true olan required değerini false yaparak hata almasını önleyebiliriz.
        @Autowired
        @Qualifier("bean2")
        private Cat cat;

//    private final Cat cat;

//    @Autowired(required = false)
//    public Owner(Cat beandenGelenCat){
//        this.cat=beandenGelenCat;
//    }


    public Cat getCat() {
        return cat;
    }

//    //@Autowired    setter injection. pek kullanılmaz. attribute final de olamaz
//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }

    @Override
    public String toString() {
        return "Owner{" +
                "cat=" + cat +
                '}';
    }
}
