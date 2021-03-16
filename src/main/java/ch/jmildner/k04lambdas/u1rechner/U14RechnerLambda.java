
package ch.jmildner.k04lambdas.u1rechner;

import ch.jmildner.tools11.MyTools;

public class U14RechnerLambda {

    public static void main(String[] args) {
        MyTools.h1("U14RechnerLambda");

        System.out.println(r.rechne(5.0, 7.0, '+'));
        System.out.println(r.rechne(5.0, 7.0, '-'));
        System.out.println(r.rechne(5.0, 7.0, '*'));
        System.out.println(r.rechne(5.0, 7.0, '/'));
        System.out.println(r.rechne(5.0, 7.0, 'x'));
    }

    // lambda

    private static final IRechner2<Double> r = ( Double a,  Double b, char op) -> {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '%':
                return a % b;
        }
        return 0.0;
    };
}
