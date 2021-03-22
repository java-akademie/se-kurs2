package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class U725Time {

    private static long start;

    private static final List<Integer> integerList = new ArrayList<>();

    static {
        MyTools.h1("U725Time");
        final int MAX = 25_000_000;
        timingStart();
        for (int i = 1; i <= MAX; i++)
            integerList.add(MyTools.getRandom());
        timingStop(String.format("Init an IntegerList with %,d Integers", MAX));
    }

    public static void main(String[] args) {


        sortAfterLimit();
        sortBeforeLimit();
    }

    private static void sortBeforeLimit() {
        MyTools.h2("sortVorLimit", 2);

        timingStart();
        Stream<Integer> s1 = integerList.stream();
        timingStop(".stream()");

        timingStart();
        Stream<Integer> s2 = s1.filter(i -> i % 2 == 0);
        timingStop(".filter()");

        timingStart();
        Stream<Integer> s3 = s2.sorted();
        timingStop(".sorted()");

        timingStart();
        Stream<Integer> s4 = s3.limit(5);
        timingStop(".limit()");

        timingStart();
        s4.forEach(System.out::println);
        timingStop(".forEach()");
    }

    private static void sortAfterLimit() {
        MyTools.h2("test2 sort after limit", 2);

        timingStart();
        Stream<Integer> s1 = integerList.stream();
        timingStop(".stream()");

        timingStart();
        Stream<Integer> s2 = s1.filter(i -> i % 2 == 0);
        timingStop(".filter()");

        timingStart();
        Stream<Integer> s3 = s2.limit(5);
        timingStop(".limit()");

        timingStart();
        Stream<Integer> s4 = s3.sorted();
        timingStop(".sorted()");

        timingStart();
        s4.forEach(System.out::println);
        timingStop(".forEach()");
    }

    private static void timingStop(String s) {
        System.out.printf("%s - Duration: %.6f seconds %n",
                s, (System.nanoTime() - start) / 1_000_000_000.0);
    }

    private static void timingStart() {
        start = System.nanoTime();
    }

}
