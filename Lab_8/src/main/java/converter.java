public class converter {
    public static String sumConv(Example ex,int a,int b)
    {
        Integer buff = ex.sum(a,b);
        return buff.toString();
    }
}
