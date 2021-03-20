
package ch.jmildner.k05collections1.u5generics;

import ch.jmildner.tools11.MyTools;

public class U55MyGenericRechnerMain {

    public static void main(String[] args) {
        MyTools.h1("U55MyGenericRechner");
        testDouble();
        testInteger();
    }

    private static void testInteger() {
        MyTools.h2("testInteger");
        var gr = new U54MyGenericRechner<Integer>();
        gr.setOperands(144, 12);

        System.out.println(gr.rechne(Integer::sum));
        System.out.println(gr.rechne((a, b) -> a - b));
        System.out.println(gr.rechne((a, b) -> a * b));
        System.out.println(gr.rechne((a, b) -> a / b));
    }

    private static void testDouble() {
        MyTools.h2("testDouble");
        var gr = new U54MyGenericRechner<Double>();
        gr.setOperands(22d, 7d);

        System.out.println(gr.rechne(Double::sum));
        System.out.println(gr.rechne((a, b) -> a - b));
        System.out.println(gr.rechne((a, b) -> a * b));
        System.out.println(gr.rechne((a, b) -> a / b));
    }

}
