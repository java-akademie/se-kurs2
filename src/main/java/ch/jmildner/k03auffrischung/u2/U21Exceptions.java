package ch.jmildner.k03auffrischung.u2;

import ch.jmildner.tools11.MyTools;

public class U21Exceptions {

    public static void main(String[] args) {

        MyTools.h1("my own exception");

        doIt(5, 2);
        doIt(6, 0);
        doIt(7, 3);
    }

    private static void doIt(int z, int n) {
        try {
            System.out.println(divide(z, n));
        } catch (MyDivideByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int divide(int z, int n)
            throws MyDivideByZeroException {
        // n must not be zero
        if (n == 0) {
            throw new MyDivideByZeroException
                    ("divide by 0 is not allowed");
        }

        return z / n;
    }

    static class MyDivideByZeroException extends Exception {
        MyDivideByZeroException(String s) {
            super(s);
        }
    }
}
