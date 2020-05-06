package by.bstu.fit.poit.group4.selitsky.task2_2;

public class Visitor{
    public  Visitor(String name){
        this.name = name;
    }
    private String name;
    public String getVisitorName() {
        return this.name;
    }

    public static Visitor Clone(Visitor visitor){
        return new Visitor(visitor.name);
    }
}


