
package ch.jmildner.k04lambdas.u3weitere_techniken;

import ch.jmildner.tools11.MyTools;
import java.util.List;

public class U31MethodReference {
    public static void main(String[] args) {
        MyTools.h1("U31MethodReference");
        testMethodReference1();
        testMethodReference2();
    }

    private static void testMethodReference2() {
        MyTools.h2("testMethodReference2");

        List<String> l = List.of("xxx", "yyy", "zzz");

        l.forEach(x->System.out.println(x));
        l.forEach(x->Foo.bar(x));

        System.out.println("---");

        l.forEach(System.out::println);
        l.forEach(Foo::bar);
    }

    private static void testMethodReference1() {
        MyTools.h2("testMethodReference1");

        List<Integer> l= List.of(111, 112, 113);

        l.forEach(x->System.out.println(x));
        l.forEach(x->Foo.bar(x));

        System.out.println("---");

        l.forEach(System.out::println);
        l.forEach(Foo::bar);
    }

    private static class Foo {
        static void bar(Integer i) {
            System.out.println("Foo.bar(Integer):" + i * 2);
        }
        static void bar(String i) {
            System.out.println("Foo.bar(String):" + i + " " + i);
        }
    }
}
