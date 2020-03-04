package com.company;

import lab3.Building;
import lab3.House;
import lab3.Flat;

import java.io.*;


public class Main {

    public static void outPut(Object obj)
    {
        System.out.println(obj);
    }
    public static void main(String[] args){
        try {
            PrintStream ps = new PrintStream(new File("log.txt"));
            System.setErr(ps);
        } catch (FileNotFoundException e){System.out.println(e);}
        try {
            Building myHouse = new House();
            myHouse.destroy();
            Building myFlat = new Flat();
            myFlat.open();
            outPut(myFlat);
            Building otherHouse = null;
            otherHouse.open();
        }
        catch (Exception e){
            System.err.println("Ошибка: " + e.toString());
        }
    }
}


