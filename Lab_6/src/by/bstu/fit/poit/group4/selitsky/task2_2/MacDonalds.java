package by.bstu.fit.poit.group4.selitsky.task2_2;


import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class MacDonalds {
    ReentrantLock locker = new ReentrantLock();
    ArrayList<CashBox> cashBoxList;
    ArrayList<ArrayList<Visitor>> visitorsList;

    public MacDonalds(int numberOfCashbox) {
        cashBoxList = new ArrayList<>();

        visitorsList = new ArrayList<>();

        if (numberOfCashbox > 0)
            for (int i = 0; i < numberOfCashbox; i++) {
                cashBoxList.add(new CashBox(i, this));
                visitorsList.add(new ArrayList<>());
            }
        else {
            System.out.println("ERROR");
        }
    }

    public void startWork() {
        for (int i = 0; i < cashBoxList.size(); i++) {
            Thread a1 = new Thread(cashBoxList.get(i));
            a1.start();
        }
    }

    public void AddVisitor(Visitor visitor) {
        int min = Integer.MAX_VALUE;
        int numbOfCashBox = 0;
        for (int i = 0; i < visitorsList.size(); i++) {
            if (min > visitorsList.get(i).size()) {
                min = visitorsList.get(i).size();
                numbOfCashBox = i;
            }
        }
        visitorsList.get(numbOfCashBox).add(visitor);
    }

    @Override
    public String toString() {
        StringBuilder rc = new StringBuilder("MC State\n");
        for (int i = 0; i < visitorsList.size(); i++) {
            rc.append("Cashbox ").append(i).append("\n{ ");
            for (int j = 0; j < visitorsList.get(i).size(); j++) {
                rc.append(visitorsList.get(i).get(j).getVisitorName()).append(" ");
            }
            rc.append("}\n");
        }
        return rc.toString();
    }

    public Visitor GetVisitor(int number) {
        locker.lock();
        Visitor rc = new Visitor("null");
        if (visitorsList.get(number).size() != 0) {
            rc = Visitor.Clone(visitorsList.get(number).get(0));
            visitorsList.get(number).remove(0);
        } else {
            number = -1;
            for (int i = 0; i < visitorsList.size(); i++) {
                if (visitorsList.get(i).size() != 0) {
                    number = i;
                }
            }

            if (number > 0) {
                rc = Visitor.Clone(visitorsList.get(number).get(0));
                visitorsList.get(number).remove(0);
            }
        }
        locker.unlock();
        return rc;
    }
}
