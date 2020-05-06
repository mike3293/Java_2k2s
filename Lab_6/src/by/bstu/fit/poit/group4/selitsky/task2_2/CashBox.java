package by.bstu.fit.poit.group4.selitsky.task2_2;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class CashBox implements Runnable {
    private int name;
    ReentrantLock locker = new ReentrantLock();
    MacDonalds mc;

    public CashBox(int n,MacDonalds m){
        this.name= n;
        this.mc = m;
    }

        public void run(){
            try{
                Random rand = new Random();
                Visitor myVisitor = mc.GetVisitor(name);
                while(!myVisitor.getVisitorName().equals("null"))
                {
                    System.out.println(String.format("Visitor %s start on %s cashbox.", myVisitor.getVisitorName(),(name+1) ));
                    Thread.sleep(100+rand.nextInt(1000));
                    System.out.println(String.format("Visitor %s finish on %s cashbox.", myVisitor.getVisitorName(),(name+1) ));
                    System.out.println(mc.toString());
                    myVisitor = mc.GetVisitor(name);
                }
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

    }
}

