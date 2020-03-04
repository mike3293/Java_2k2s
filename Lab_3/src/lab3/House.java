package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class House extends Building
{
    public int getWC() {
        return windowsCount;
    }
    public void setWC(int op) {
        this.windowsCount = op;
    }
    public House() throws FileNotFoundException {
            PrintStream ps = new PrintStream(new File("log.txt"));
            System.setErr(ps);
        System.err.println("Создан объект дом");
        this.type = Type.House;
    }
    @Override
    public void destroy() {
        System.err.println("Дом уничтожен");
    }

    @Override
    public void open(){
        System.err.println("Дом открыт");
    }
}