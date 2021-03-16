
package ch.jmildner.k03auffrischung.u3;

public class U33TestGenericList {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test3() {
        U31GenericList<Double> gc = new U31GenericList<>();

        gc.add(1000d);
        gc.add(2000d);

        System.out.println(gc.get());
    }

    private static void test2() {
        U31GenericList<U32Person> gc = new U31GenericList<>();

        gc.add(new U32Person("hugo"));
        gc.add(new U32Person("max"));

        System.out.println(gc.get());
    }

    private static void test1() {
        U31GenericList<String> gc = new U31GenericList<>();

        gc.add("hugo");
        gc.add("max");

        System.out.println(gc.get());
    }

}
