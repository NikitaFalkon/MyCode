package Nik.Working;

import Nik.Animals.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:reader.properties")
public class Reader
{
    //считывает данные из файла, в том числе и название таблицы, которая хранит животных
    //таблица хранит id, name, type
    private String url;
    private String username;
    private String password;
    private String tabl;
    public Reader()
    {
        String[]  read = new String[5];
        int i=0;
        try {
            File file = new File("C:\\Users\\user\\IdeaProjects\\MyCodeForItibo\\src\\main\\resources\\file.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                read[i]=line;
                i++;
            }
            this.url=read[0];
            this.username=read[1];
            this.password=read[2];
            this.tabl=read[3];
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println(e);

        } catch (IOException e) {
            System.out.println("Your file is incorrect");
            System.out.println(e);
        }
    }
    public void Reading(List<Animal> animals)
    {
        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(this.url, this.username, this.password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM "+tabl+"");
                while (resultSet.next())
                {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String type = resultSet.getString(3);
                    if(type.equals("DOG"))
                    {
                        Animal animal = new Dog(id, name);
                        animals.add(animal);
                    }
                    else if (type.equals("CAT"))
                    {
                        Animal animal = new Cat(id, name);
                        animals.add(animal);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Connection failed...");
            System.out.println(e);
        }

    }
    public void Writting(List<Animal> animals)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password))
            {
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("DELETE FROM "+tabl+"");
                for (Animal animal : animals)
                {
                    String type;
                    if (animal.getType()==2)
                    {
                        type = "DOG";
                    }
                    else
                    {
                        type = "CAT";
                    }
                    rows = statement.executeUpdate("INSERT "+tabl+" (Name, Type) VALUES ('"+animal.getName()+"','"+type+"')");// так как id в таблице заполняется самостоятельно, мы можем не вставлять его
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Connection failed...");
            System.out.println(e);
        }
    }


}
