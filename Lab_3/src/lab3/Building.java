package lab3;
enum Type{House, Flat};
interface Destoyer
{
    public abstract void destroy();
}
public abstract class Building implements Destoyer {
    public String toString() {
        return "Тип: " + (type==Type.House ?"Дом":"Квартира");
    }
    public abstract void destroy();
    public abstract void open();
    protected int windowsCount;
    public Type type;
}
