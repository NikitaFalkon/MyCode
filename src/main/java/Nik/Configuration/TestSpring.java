package Nik.Configuration;

import Nik.Animals.AnimalsList;
import Nik.Working.Program;
import Nik.Working.Reader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(OfflineConfig.class);
        Program program = context.getBean("program", Program.class);
        Reader reader = context.getBean("reader", Reader.class);
        program.Do();
        context.close();
    }
}
