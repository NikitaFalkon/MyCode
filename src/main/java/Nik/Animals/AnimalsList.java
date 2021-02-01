package Nik.Animals;

import Nik.Working.Reader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

@Component
public class AnimalsList {
    private Boolean DB = false;
    private List<Animal> animals;
    //private List<Animal> animalsDB;
    Scanner ini = new Scanner(System.in);
    private static int ID=0;
    public int getID()
    {
        ++ID;
        return ID;
    }

    public AnimalsList(List<Animal> animals){
        this.animals=animals;
        ID=animals.size()-1;
    }
    public AnimalsList(Reader reader)
    {
        animals = new ArrayList<>();
        reader.Reading(animals);
        DB = true;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
    public Animal getById(int id)
    {
        for (Animal animal: animals)
        {
          if(id==animal.getId())
          {
              return animal;
          }
        }
        return null;
    }
    public void  Create()
    {
        System.out.println("Which animal you want to create?\nDog - 1\nCat - 2");
        int i = ini.nextInt();
        Animal animal;
        switch (i)
        {
            case 1:
                animal = new Dog(getID());
                animals.add(animal);
                break;
            case 2:
                animal = new Cat(getID());
                animals.add(animal);
                break;
        }
    }
    public void delete(String name)
    {
        for (Animal animal: animals) {

            if (animal.getName().equals(name)) {
                animals.remove(animal);
                break;
            }
        }
    }
    public void WriteAnimals()
    {
        for(Animal animal : animals)
        {
            System.out.println(animal.getName()+" "+animal.Scream()+"\n");
        }
    }

    public Boolean getDB() {
        return DB;
    }

}
