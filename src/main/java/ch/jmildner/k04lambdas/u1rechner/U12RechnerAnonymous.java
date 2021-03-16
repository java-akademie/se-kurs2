
package ch.jmildner.k04lambdas.u1rechner;

import ch.jmildner.tools11.MyTools;

public class U12RechnerAnonymous {

    public static void main(String[] args) {
        MyTools.h1("U12RechnerAnonymous");

        System.out.println(add.rechne(5.0, 7.0));
        System.out.println(sub.rechne(5.0, 7.0));
        System.out.println(mult.rechne(5.0, 7.0));
        System.out.println(div.rechne(5.0, 7.0));
    }

    // anonymous inner classes

    static IRechner1<Double> add = new IRechner1<>() {
        @Override
        public Double rechne(Double a, Double b) {
            return a + b;
        }
    };

    static IRechner1<Double> sub = new IRechner1<>() {
        @Override
        public Double rechne(Double a, Double b) {
            return a - b;
        }
    };

    static IRechner1<Double> mult = new IRechner1<>() {
        @Override
        public Double rechne(Double a, Double b) {
            return a * b;
        }
    };

    static IRechner1<Double> div = new IRechner1<>() {
        @Override
        public Double rechne(Double a, Double b) {
            return a / b;
        }
    };

}
