
package ch.jmildner.k05collections1.u3set;

import ch.jmildner.tools11.MyTools;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class U33Time {

    private static Set<Integer> set;

    public static void main(String[] args) {
        MyTools.h1("U23Time - compare runtime HashSet, TreeSet");
        insert();       // 10_000_000
        findNumber();   // 10_000_000
    }

    private static void insert() {
        var max = 10_000_000;
        MyTools.h2(String.format("insert max: %,d", max));
        insertHashSet(max);
        insertTreeSet(max);
    }

    private static void insertTreeSet(int max) {
        set = new TreeSet<>();

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            set.add(MyTools.getRandom(1, max));
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("TreeSet add(random) %,7d ms, counter=%,d %n", duration, set.size());
    }

    private static void insertHashSet(int max) {
        set = new HashSet<>();

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            set.add(MyTools.getRandom(1, max));
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("HashSet add(random) %,7d ms, counter=%,d %n", duration, set.size());
    }

    private static void findNumber() {
        var max = 10_000_000;
        MyTools.h2(String.format("getNumber max: %,d", max));
        findNumberHashSet(max);
        findNumberTreeSet(max);

    }

    private static void findNumberHashSet(int max) {
        set = new HashSet<>();

        for (int i = 1; i <= max; i++) {
            set.add(MyTools.getRandom(1, max));
        }

        var found = 0;
        var notFound = 0;
        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            if (set.contains(MyTools.getRandom(1, max)))
                found += 1;
            else
                notFound += 1;
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("HashSet contains() %,7d ms %n", duration);
        System.out.printf("found %,d, notFound %,d %n", found, notFound);
    }

    private static void findNumberTreeSet(int max) {
        set = new TreeSet<>();

        for (int i = 1; i <= max; i++) {
            set.add(MyTools.getRandom(1, max));
        }

        var found = 0;
        var notFound = 0;
        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            if (set.contains(MyTools.getRandom(1, max)))
                found += 1;
            else
                notFound += 1;
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("TreeSet contains() %,7d ms %n", duration);
        System.out.printf("found %,d, notFound %,d %n", found, notFound);
    }

}
