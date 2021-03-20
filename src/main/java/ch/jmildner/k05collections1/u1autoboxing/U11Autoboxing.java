
package ch.jmildner.k05collections1.u1autoboxing;
import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.List;

public class U11Autoboxing {

    private Integer integerObj;
    private Long longObj;
    private Float floatObj;
    private Double doubleObj;

    private int i;
    private long l;
    private float f;
    private double d;

    public static void main(String[] args) {
        new U11Autoboxing().doIt();
    }

    private void doIt() {
        boxing();
        unboxing();
        testList();
    }

    private void boxing() {
        MyTools.h1("boxing");

        integerObj = 555;
        longObj = (long) 5; // boxing doesn't convert
        longObj = 15312L;
        floatObj = 15.0F;
        doubleObj = 335.0D;

        System.out.println(integerObj);
        System.out.println(longObj);
        System.out.println(floatObj);
        System.out.println(doubleObj);
    }

    private void unboxing() {
        MyTools.h1("unboxing");

        i = integerObj;
        l = longObj;
        f = floatObj;
        d = doubleObj;

        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
    }

    private void testList() {
        MyTools.h1("testList");

        List<Integer> intList = new ArrayList<>();

        MyTools.h2("boxing/unboxing from Integer to int and v.v.");
        intList.add(42);
        intList.add(i);
        intList.add((int) l);
        intList.add((int) f);
        intList.add((int) d);
        intList.add((int) (long) longObj);
        intList.add((int) (float) floatObj);
        intList.add((int) (double) doubleObj);
        for (int i : intList) {
            System.out.println(i);
        }

        MyTools.h2("no boxing/unboxing necessary");
        intList.add(integerObj);
        for (Integer i : intList) {
            System.out.println(i);
        }
    }

}
