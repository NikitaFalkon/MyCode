package Nik.Working;

import Nik.Animals.AnimalsList;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    private AnimalsList animalsList;
    boolean Work = true;
    private int Choice;
    Reader reader;

    public Program(AnimalsList animalsList) {
        this.animalsList = animalsList;
    }

    public void Do() {
        while (Work) {
            animalsList.WriteAnimals();

            Scanner in = new Scanner(System.in);
            Boolean Trying = false;
            while (Trying==false)
            {
                System.out.println("Menu\nPress 1 to create a new Pet\nPress 2 to sell a Pet\nPress 3 to End the Program");
                try
                {
                    Choice = in.nextInt();
                }catch (InputMismatchException e)
                {
                    System.out.println("You write incorrect data");
                    in = new Scanner(System.in);
                }
                switch (Choice) {
                    case 1:
                        animalsList.Create();
                        Trying=true;
                        break;
                    case 2:
                        System.out.println("Write the name of your pet");
                        Scanner ini = new Scanner(System.in);
                        String name = ini.nextLine();
                        animalsList.delete(name);
                        Trying=true;
                        break;
                    case 3:
                        Work = false;
                        Trying=true;
                        if(animalsList.getDB()==true)
                        {
                            End();
                        }
                        break;
                    default:
                        System.out.println("I don't know such a symbol(");
                }
            }
        }
    }
    private void End()
    {
        Reader reader = new Reader();
        reader.Writting(animalsList.getAnimals());
    }
}
