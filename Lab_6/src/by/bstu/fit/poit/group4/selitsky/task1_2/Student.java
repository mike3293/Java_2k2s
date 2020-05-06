package by.bstu.fit.poit.group4.selitsky.task1_2;


import java.util.Random;

public class Student extends Thread
{
    public String studentsName;
    Canteen canteen;
    Random random = new Random();

    public Student(int pStudentName, Canteen pCanteen)
    {
        this.studentsName = String.valueOf(pStudentName);
        this.canteen = pCanteen;
        System.out.println("Student " + this.studentsName + " came");
    }

    @Override
    public void run()
    {
        synchronized (canteen) {
            if (canteen.getFreePlace() == -1) {
                int waitingTime = random.nextInt(5000);
                System.out.println("Student " + this.getStudentName() + " is waiting...");
                try {
                    canteen.wait(waitingTime);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if(canteen.getFreePlace() != -1)
        {
            if (canteen.checkStudentInQueue())
            {
                canteen.setStudent(this);
            }
            else
            {
                canteen.setStudent(canteen.setStudentFromQueue());
            }
            canteen.showCanteen();
            try
            {
                Thread.sleep(random.nextInt(5000));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            canteen.leaveStudent(this);
            synchronized (canteen)
            {
                canteen.notify();
            }
        }
        else {
            canteen.addStudentToQueue(this);
        }
    }

    public String getStudentName(){
        return this.studentsName;
    }
}

