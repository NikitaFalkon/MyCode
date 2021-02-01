package Nik.Animals;

import javax.annotation.PreDestroy;

public class Dog extends Animal {
    public Dog(int i)
    {
        super(i);
        this.type=2;
    }
    public Dog(int i, String name)
    {
        super(i, name);
        this.type=2;
    }
    @PreDestroy
    public void doMyDestroy()
    {
        System.out.println("There's no dog(((");
    }
    @Override
    public String Scream()
    {
        return "says Woof";
    }
}
