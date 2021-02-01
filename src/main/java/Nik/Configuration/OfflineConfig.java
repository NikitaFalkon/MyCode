package Nik.Configuration;

import Nik.Animals.Animal;
import Nik.Animals.AnimalsList;
import Nik.Working.Program;
import Nik.Working.Reader;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration()
@ComponentScan("Nik")
//@PropertySource("classpath:reader.properties")
public class OfflineConfig {
    private int ID=0;
    Scanner in = new Scanner(System.in);
    @Bean
    public AnimalsList animalsList()
    {
        List<Animal> animals = new ArrayList<>();
        return new AnimalsList(animals);
    }
    @Bean
    public Reader reader()
    {
        return new Reader();
    }
    @Bean
    public AnimalsList animalsListBD()
    {
        return new AnimalsList(reader());
    }
    @Bean
    public Program program()
    {
        boolean Trying = false;
        int choice = 0;
        while (Trying==false)
        {
            System.out.println("Do you want to read Zoo from database?\nYes-1\nNo-other");
            try
            {
                choice = in.nextInt();
                Trying = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Your symbol is incorrect");
                in = new Scanner(System.in);
                Trying = false;
            }

        }
        if(choice == 1)
        {
            return new Program(animalsListBD());
        }
        else
        {
            return new Program(animalsList());
        }
    }
}
