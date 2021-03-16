
package ch.jmildner.k03auffrischung.u2;

import ch.jmildner.tools11.MyTools;

public class U22Assertion {

    public static void main(String[] args) {

        MyTools.h1("assertion");

        doIt(5, 2);
        doIt(6, 0);
        doIt(7, 3);
        doIt(8, 2);
    }

    private static void doIt(int z, int n) {
        assert n!=0 : "n must not be zero";
        System.out.println(divide(z, n));
    }

    private static int divide(int z, int n) {
               return z / n;
    }
}
