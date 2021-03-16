
package ch.jmildner.k04lambdas.u1rechner;

import ch.jmildner.tools11.MyTools;

public class U11RechnerClasses {

    public static void main(String[] args) {

        MyTools.h1("U11RechnerClasses()");

        Add add = new Add();
        Sub sub = new Sub();
        Mult mult = new Mult();
        Div div = new Div();

        System.out.println(add.rechne(5.0, 7.0));
        System.out.println(sub.rechne(5.0, 7.0));
        System.out.println(mult.rechne(5.0, 7.0));
        System.out.println(div.rechne(5.0, 7.0));
    }

    // static inner classes - not anonymous
    // could also be outer classes

    static class Add implements IRechner1<Double> {
        @Override
        public Double rechne(Double a, Double b) {
            return a + b;
        }
    }

    static class Sub implements IRechner1<Double> {
        @Override
        public Double rechne(Double a, Double b) {
            return a - b;
        }
    }

    static class Mult implements IRechner1<Double> {
        @Override
        public Double rechne(Double a, Double b) {
            return a * b;
        }
    }

    static class Div implements IRechner1<Double> {
        @Override
        public Double rechne(Double a, Double b) {
            return a / b;
        }
    }
}
