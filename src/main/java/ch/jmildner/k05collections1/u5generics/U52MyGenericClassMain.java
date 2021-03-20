package ch.jmildner.k05collections1.u5generics;

import ch.jmildner.k05collections1.u2list.Person2;
import ch.jmildner.tools11.MyTools;

public class U52MyGenericClassMain {

    public static void main(String[] args) {
        MyTools.h1("U52MyGenericClassMain");
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        MyTools.h2("test1");
        var mgc = new U51MyGenericClass<String>();

        System.out.println(mgc.insert("hugo"));
        mgc.insert("max");
        mgc.insert("moritz");

        System.out.println(mgc.get());
    }

    private static void test2() {
        MyTools.h2("test2");
        var mgc = new U51MyGenericClass<Person2>();

        mgc.insert(new Person2("1", "hugo"));
        mgc.insert(new Person2("2", "max"));
        mgc.insert(new Person2("3", "moritz"));

        System.out.println(mgc.get());
    }

    private static void test3() {
        MyTools.h2("test3");
        var mgc = new U51MyGenericClass<Double>();

        mgc.insert(1000d);
        mgc.insert(2000d);
        mgc.insert(3000d);
        mgc.insert(4000d);

        System.out.println(mgc.remove(0));
        System.out.println(mgc.remove(3000d));

        System.out.println(mgc.get());
        System.out.println(mgc.get(0));
    }


    private static void test4() {
        MyTools.h2("test4");
        var mgc = new U51MyGenericClass<Integer>();

        mgc.insert(1000);
        mgc.insert(2000);
        mgc.insert(3000);
        mgc.insert(4000);

        System.out.println(mgc.remove(2));
        System.out.println(mgc.remove(Integer.valueOf(3000)));

        System.out.println(mgc.get());
        System.out.println(mgc.get(0));
    }

}
