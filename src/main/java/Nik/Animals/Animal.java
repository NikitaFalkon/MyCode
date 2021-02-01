package Nik.Animals;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Animal {
    protected int type;
    private int id;
    private int cost;
    private String name;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public String Scream() {
        return "says Brr";
    }

    public int getType() {
        return type;
    }

    public Animal(int id) {
        this.id = id;
        System.out.println("Write name for your animal");
        Scanner in = new Scanner(System.in);
        this.name = in.nextLine();


        //this.name = name;
    }
    public Animal(int id, String name)
    {
        this.id = id;
        this.name=name;
    }
    public Animal(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
