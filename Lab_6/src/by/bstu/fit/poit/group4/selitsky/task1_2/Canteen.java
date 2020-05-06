package by.bstu.fit.poit.group4.selitsky.task1_2;

import java.util.ArrayDeque;

public class Canteen
{
    private Student[] students;
    private ArrayDeque<Student> queue;
    private int canteenSize;

    public Canteen(int size, int count)
    {
        this.canteenSize = size;
        students = new Student[size];
        queue = new ArrayDeque<Student>(count);
    }

    public int getFreePlace()
    {
        for (int i = 0; i < canteenSize; i++)
        {
            if (students[i] == null)
            {
                return i;
            }
        }
        return -1;
    }

    public synchronized void setStudent(Student student)
    {
        System.out.println("Student " + student.getStudentName() + " take a place");
        students[getFreePlace()] = student;
    }

    public synchronized void leaveStudent(Student student)
    {
        for(int i=0;i<canteenSize;i++)
        {
            if(students[i] == student)
            {
                students[i] = null;
                System.out.println("Student " + student.getStudentName() + " leave the canteen");
            }
        }
    }

    public synchronized void addStudentToQueue(Student student)
    {
        this.queue.addFirst(student);
    }

    public synchronized Student setStudentFromQueue()
    {
        return this.queue.pollFirst();
    }

    public synchronized boolean checkStudentInQueue()
    {
        return this.queue.isEmpty();
    }

    public void showCanteen()
    {
        System.out.println("Canteen places:\n{");
        for (int i = 0; i < canteenSize; i++)
        {
            if(students[i] != null)
            {
                System.out.println(i+1 + ") " + students[i].getStudentName());
            }
            else
            {
                System.out.println(i + ") empty");
            }
        }
        System.out.println("}");
    }
}
