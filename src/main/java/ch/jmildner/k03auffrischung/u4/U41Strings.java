
package ch.jmildner.k03auffrischung.u4;

import ch.jmildner.tools11.MyTools;

public class U41Strings {

    private static String s1 = "ein string";
    private static String s2 = "ein string";
    private static String s3 = "ein string";

    public static void main(String[] args) {
        MyTools.h1("U41Strings");

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));

        s1 = s1 + "x";
        s2 = s2 + "x";
        s3 = s3 + "x";

        System.out.println();
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));

    }

}
