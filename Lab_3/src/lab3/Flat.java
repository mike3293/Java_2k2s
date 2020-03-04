package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Flat extends Building
{
    public Flat() throws FileNotFoundException {
            PrintStream ps = new PrintStream(new File("log.txt"));
            System.setErr(ps);
        System.err.println("Создан объект квартира");
        this.type = Type.Flat;
    }
    @Override
    public void destroy() {
        System.err.println("Квартира уничтожена");
    }
    @Override
    public void open(){
        System.err.println("Квартира открыта");
    }
}