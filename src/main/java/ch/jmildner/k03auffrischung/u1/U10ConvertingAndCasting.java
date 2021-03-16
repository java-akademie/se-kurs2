package ch.jmildner.k03auffrischung.u1;

import ch.jmildner.tools11.MyTools;

public class U10ConvertingAndCasting {

    public static void main(String[] args) {
        MyTools.h1("U1ConvertingAmdCasting");
        test1();
        test2();
    }

    private static void test1() {
        MyTools.h2("Converting Primitives");

        char c = 98;
        byte b = 98;
        short s = 32000;
        int i = 2_034_456_890;
        long l = 8_234_567_890_123_456_789L;
        float f = 5.1234F;
        double d = 9_012_345_678_190_123_456_111_222_333_444.123_456_789;

        // widening (automatically)

        System.out.println("d " + d);
        System.out.println("f " + f);
        System.out.println("l " + l);
        System.out.println("i " + i);
        System.out.println("s " + s);
        System.out.println("b " + b);
        System.out.println("c " + c);
        System.out.println();

        System.out.println("df " + (double) f);
        System.out.println("fl " + (float) l);
        System.out.println("li " + (long) i);
        System.out.println("is " + (int) s);
        System.out.println("sb " + (short) b);
        System.out.println("ic " + (int) c);

        System.out.println();
    }

    private static void test2() {
        MyTools.h2("Casting Primitives");

        char c = 98;
        byte b = -98;
        short s = 32123;
        int i = 2_123_456_789;
        long l = 9_987_654_321L;
        float f = 5.12345F;
        double d = 10.123456789;

        // narrowing (cast required, data can be lost)

        System.out.println(d);
        System.out.println(f);
        System.out.println(l);
        System.out.println(i);
        System.out.println(s);
        System.out.println(b);
        System.out.println(c);
        System.out.println();

        c = (char) b;
        b = (byte) s;
        s = (short) i;
        i = (int) l;
        l = (long) f;
        f = (float) d;

        System.out.println(d);
        System.out.println(f);
        System.out.println(l);
        System.out.println(i);
        System.out.println(s);
        System.out.println(b);
        System.out.println(c);
        System.out.println();
    }
}
