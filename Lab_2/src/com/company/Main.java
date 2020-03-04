package com.company;

import by.belstu.it.gorodilov.TextFunction;
import by.belstu.it.gorodilov.WrapperString;

import static java.lang.Math.*;

/**
 * @author dd
 */
public class Main {
    public static void main(String[] args) {
        // todo: write your code here
        invokeTextFunction();

        WrapperString str = new WrapperString("1");
        str.replace('1', '2');
    }

    private static void invokeTextFunction() {
        TextFunction function = new TextFunction();
        for (int i = 0; i < 4; i++) {
            System.out.println(function.getValue());
        }

        int intOne = 5;
        String stringOne = "Hello";
        char charOne = 't';
        short shortOne = 45;
        boolean boolVariable = true;
        boolean boolVariable1 = false;
        long longOne = 452345;
        byte byteOne = 10;
        double doubleOne = 10;
        System.out.println(stringOne + intOne);
        System.out.println(stringOne + charOne);
        System.out.println(stringOne + doubleOne);
        //byte result = byteOne+intOne;
        //int result1=doubleOne+longOne;
        long long1 = intOne + 2147483647;
        System.out.println(long1);
        System.out.println(boolVariable && boolVariable1);
        System.out.println(boolVariable ^ boolVariable1);
        //System.out.println( boolVariable+boolVariable1);
        //long var2= 0x7fff_ffff_fff;
        //long var1= 9223372036854775807;
        char ch1 = 'a', ch2 = '\u0061', ch3 = 97;
        System.out.println(ch1 + " " + ch2 + " " + ch3);
        System.out.println(ch1 + ch2 + ch3);
        System.out.println(3.45 % 2.4);
        System.out.println(1.0 / 0.0);
        System.out.print(log(-345));
        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));
        System.out.println(fr);


        System.out.println(Math.PI);
        System.out.println(Math.E);
        System.out.println(Math.min(Math.round(Math.PI), Math.round(Math.E)));
        double math1 = Math.random();
        System.out.println(math1);

        testBoxing();
        testString();
        testArrays();
    }

    static int fr;

    static public void testBoxing() {
        System.out.println("Boxing");

        Character oChar = 'a';
        Integer oInt = 10;
        Short oShort = (short) -2;
        Long oLOng = 12345678901L;
        Double oDouble = 123.456;

        int nInt = ~oInt;
        System.out.println("~Integer=" + nInt);

        char ze = 'b';
        ze += oChar;
        System.out.println("+Char=" + ze);

        int ne = oShort >> 2;
        System.out.println(ne);
        int be = oShort >>> 2;
        System.out.println(be);

        long lo = oLOng & 111;
        System.out.println("Long&111=" + lo);

        System.out.println("longMIN=" + Long.MIN_VALUE);
        System.out.println("longMAX=" + Long.MAX_VALUE);
        System.out.println("doubleMIN=" + Double.MIN_VALUE);
        System.out.println("doubleMAX=" + Double.MAX_VALUE);

        Integer zint = 123;
        int zu = zint;
        Byte zbyte = (byte) 255;
        byte zer = zbyte;
        int x = Integer.parseInt("9");
        System.out.println(x);
        System.out.println(Integer.toHexString(10));
        System.out.println(Integer.compare(10, 2));
        System.out.println(Integer.toString(123, 2));
        System.out.println(Integer.bitCount(123));
    }

    static public void testString() {
        String s34 = "2345";
        System.out.println(Integer.valueOf(s34));
        Integer kek = new Integer(s34);
        System.out.println(kek);

        byte[] nen = s34.getBytes();
        System.out.println(nen);
        String news34 = new String(nen);
        System.out.println(news34);

        System.out.println(Boolean.valueOf(s34));
        System.out.println(Boolean.getBoolean(s34));


        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("-------------");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));

        String str = new String("hello my dear friends");
        for (String retval : str.split(" ")) {
            System.out.println(retval);
        }
        System.out.println(str.contains("my"));
        System.out.println(str.hashCode());
        System.out.println(str.indexOf("my"));
        System.out.println(str.length());
        System.out.println(str.replace("friends", "group"));
    }

    static public void testArrays() {
        char[][] c1;
        int[] c2[];
        int c3[][];

        int ze[] = new int[0];

        //System.out.println(ze[2]);

        c1 = new char[3][];
        c1[0] = new char[0];
        c1[1] = new char[1];
        c1[2] = new char[2];
        System.out.println(c1.length);
        System.out.println(c1[0].length);
        System.out.println(c1[1].length);
        System.out.println(c1[2].length);

        c2 = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        c3 = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        boolean comRez = c2 == c3;
        System.out.println(comRez);
        c2 = c3;

        for (int[] z2 : c2) {
            for (int z : z2) {
                System.out.println(z);
            }
        }
    }
}
