package Nik.Animals;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class Cat extends Animal{
    /*@Value("${Animal.cost}")
    private int cost;*/
    public Cat(int i) {
        super(i);
        this.type=1;
    }
    public Cat(int i, String name)
    {
        super(i, name);
        this.type=1;
    }
    @PreDestroy
    public void doMyDestroy()
    {
        System.out.println("There's no cat(((");
    }
    @Override
    public String Scream()
    {
        return "says Meow";
    }

}
