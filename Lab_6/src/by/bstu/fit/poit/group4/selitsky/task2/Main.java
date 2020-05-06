package by.bstu.fit.poit.group4.selitsky.task2;


import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int AMOUNT_OF_OPERATORS = 3;
    public static final int AMOUNT_OF_CLIENTS = 30;

    public static void main(String[] args) {
        Random rand = new Random();
        Semaphore semaphore = new Semaphore(AMOUNT_OF_OPERATORS, true);
        SkyCenter skyCenter = new SkyCenter(AMOUNT_OF_OPERATORS);
        Client client;
        try {
            for (int i = 0; i < AMOUNT_OF_CLIENTS; i++) {
                if(rand.nextBoolean())
                {
                    client = new Client(skyCenter, semaphore, i+1,Thread.MAX_PRIORITY);
                }
                else{
                    client = new Client(skyCenter, semaphore, i+1,Thread.MIN_PRIORITY);
                }

                client.start();
                Thread.sleep(rand.nextInt(10) + 300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

