package beans;


import org.springframework.stereotype.Component;

//@Component        annotation sayesinde spring bu classı bean yapar ve contexte uygulama kalkarken instancesini verir.
public class Cat {
    private String name;
    private int catId;
    static int catInstance=0;

    public Cat(){
        this.catId=catInstance;
        this.name="kediii";
        catInstance+=1;
    }
    public void setName(String isim){
        this.name=isim;
    }
    public String getName(){
        return this.name;
    }

    public int getCatId() {
        return catId;
    }



    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}'+
                " Id:"+ this.catId;
    }
}
