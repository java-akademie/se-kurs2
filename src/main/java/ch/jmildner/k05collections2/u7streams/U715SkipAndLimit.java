package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class U715SkipAndLimit {

    private static List<Integer> intList;

    private static void initIntList(final int MAX) {
        intList = new ArrayList<>();
        for (int i = 1; i <= MAX; i++) {
            intList.add(i);
        }
    }

    public static void main(String[] args) {
        MyTools.h1("U715SkipAndLimit - Integer");

        t1_print(5_000, 2_300, 20);
        t1_print(50, 5, 12);
        t1_print(33_000_000, 5_000_000, 12);
    }

    private static void t1_print(int max, int skip, int limit) {
        MyTools.h2(String.format(
                "print max: %,d, skip: %,d, limit: %,d",
                max, skip, limit));

        initIntList(max);

        var list = intList.stream()
                //.filter(i -> i % 2 == 0)
                .skip(skip)
                .limit(limit)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList())
                ;

        list.forEach(i -> System.out.printf("%,d %n", i));

        long counter = list.size();

        System.out.println("Counter: " + counter);
    }

}
