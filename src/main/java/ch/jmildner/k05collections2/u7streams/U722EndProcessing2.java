package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class U722EndProcessing2 {

    private static final List<Person6> pList;

    static {
        pList = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            pList.add(new Person6());
        }
    }

    public static void main(String[] args) {
        MyTools.h1("U722EndProcessing2 (min, max, count)");
        count();
        minMax();
    }

    private static void count() {
        MyTools.h2("count");

        long count1 = pList.stream()
                .count();

        long count2 = pList.stream()
                .distinct()
                .count();

        System.out.printf("adults: %d, adult/distinct: %d %n",
                count1, count2);
    }

    private static void minMax() {
        MyTools.h2("min/max (age, gender, name, id)", 2);

        final Comparator<Person6> comparator = (p1, p2) -> {

            String s1 = String.format("%d%d%-30s%-30s",
                    p1.getAge(), p1.getGender(), p1.getName(), p1.getId());

            String s2 = String.format("%d%d%-30s%-30s",
                    p2.getAge(), p2.getGender(), p2.getName(), p2.getId());

            return s1.compareTo(s2);
        };

        pList.stream()
                .distinct()
                .sorted(comparator)
                .forEach(Person6::show);

        Optional<Person6> personMin = pList.stream()
                .distinct()
                .min(comparator);

        Optional<Person6> personMax = pList.stream()
                .distinct()
                .max(comparator);

        System.out.println();
        System.out.println("Min: " + personMin);
        System.out.println("Max: " + personMax);
    }

}
