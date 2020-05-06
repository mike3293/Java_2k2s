package by.bstu.fit.poit.group4.selitsky.task2_2;


import javax.crypto.Mac;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int AMOUNT_OF_CASHBOX = 3;
    public static final int AMOUNT_OF_VISITORS = 30;

    public static void main(String[] args) {
        MacDonalds macDonalds = new MacDonalds(AMOUNT_OF_CASHBOX);
        for(int i= 1;i<AMOUNT_OF_VISITORS;i++){
            macDonalds.AddVisitor(new Visitor(String.valueOf(i)));
        }
        macDonalds.startWork();
        Thread.yield();
    }
}

