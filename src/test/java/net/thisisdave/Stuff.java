package net.thisisdave;

/**
 * Created by david on 3/12/16.
 */
public class Stuff {

    public static void main(String[] args) {
        int a = 3;
        printStuff(a);
        a = a >>1;
        printStuff(a);
        a = 4;
        printStuff(a);
        a = ~a;
        printStuff(a);
        a++;
        printStuff(a);
    }

    public static void printStuff(int a){
        System.out.println("In binary: " + Integer.toBinaryString(a));
        System.out.println("In signed int: " + a);
        System.out.println();
    }
}
