
package ch.jmildner.k04lambdas.u1rechner;

import ch.jmildner.tools11.MyTools;

public class U13RechnerLambda {

    public static void main(String[] args) {
        MyTools.h1("U13RechnerLambda");

        System.out.println(add1.rechne(8.0, 7.0));
        System.out.println(add2.rechne(9.0, 7.0));
        System.out.println();
        System.out.println(add.rechne(5.0, 7.0));
        System.out.println(sub.rechne(5.0, 7.0));
        System.out.println(mult.rechne(5.0, 7.0));
        System.out.println(div.rechne(5.0, 7.0));
        System.out.println();
        fkt(add, 14.0, 7.0);
        fkt(sub, 12.0, 6.0);
        fkt(mult, 12.0, 6.0);
        fkt(div, 11.0, 6.0);
    }

    private static void fkt(IRechner1<Double> r, Double a, Double b) {
        System.out.println(r.rechne(a, b));
    }

    // lamdas

    private static final IRechner1<Double> add = (a, b) -> a + b;
    private static final IRechner1<Double> sub = (a, b) -> a - b;
    private static final IRechner1<Double> mult = (a, b) -> a * b;
    private static final IRechner1<Double> div = (a, b) -> a / b;

    private static final IRechner1<Double> add1 = (a, b) -> Double.sum(a, b);
    private static final IRechner1<Double> add2 = Double::sum;

}
