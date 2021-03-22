
package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class U712PrintStreams {

    private static final Person6[] pArray;
    private static final List<Person6> pList;

    static {
        pArray = new Person6[6];
        for (int i = 0; i < 6; i++) {
            pArray[i] = new Person6();
        }
        pList=Arrays.asList(pArray);
    }

    public static void main(String[] args) {
        MyTools.h1("U712PrintStreams");

        printStreamFromArrayAll();
        printStreamFromArrayDistinct();
        printStreamFromListAll();
        printStreamFromListDistinct1();
        printStreamFromListDistinct2();
        printStreamFromListDistinct3();
    }

    private static void printStreamFromArrayAll() {
        MyTools.h2("printStreamFromArrayAll");
        Consumer<Person6> action = Person6::show;
        var stream = Arrays.stream(pArray);
        stream.forEach(action);
    }

    private static void printStreamFromArrayDistinct() {
        MyTools.h2("printStreamFromArrayDistinct");
        Arrays.stream(pArray).distinct().forEach(Person6::show);
    }

    private static void printStreamFromListAll() {
        MyTools.h2("printStreamFromListAll");
        var stream = pList.stream();
        stream.forEach(System.out::println);
    }

    private static void printStreamFromListDistinct1() {
        MyTools.h2("printStreamFromListDistinct1");
        pList.stream().distinct().forEach(Person6::show);
    }

    private static void printStreamFromListDistinct2() {
        MyTools.h2("printStreamFromListDistinct2");
        var stream = pList.stream().distinct();
        stream.forEach(Person6::show);
    }

    private static void printStreamFromListDistinct3() {
        MyTools.h2("printStreamFromListDistinct2");
        var stream = pList.stream();
        stream = stream.distinct();
        stream = stream.filter(Person6::isAdult);
        stream.forEach(Person6::show);
    }

}
