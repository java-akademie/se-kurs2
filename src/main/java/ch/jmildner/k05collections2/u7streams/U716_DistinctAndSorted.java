package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class U716_DistinctAndSorted {

    private static List<Person6> pList;

    private static void initPersonen(final int MAX) {
        pList = new LinkedList<>();
        for (int i = 0; i < MAX; i++) {
            pList.add(new Person6());
        }
    }

    public static void main(String[] args) {
        MyTools.h1("DistinctAndSorted", 2);

        t1_print(3_000_000);
        t1_print(20);

        t2_print(30);
        t2_print(15);
    }

    private static void t1_print(final int MAX) {
        MyTools.h1(String.format("t1_print nax: %,d", MAX));

        initPersonen(MAX);

        Stream<Person6> stream1 = pList.stream();

        // there are only 20 ids from 1001-1020 available

        Stream<Person6> stream21 = pList.stream().distinct(); // for count iteration
        Stream<Person6> stream22 = pList.stream().distinct(); // for show  iteration
        Stream<Person6> stream3 = pList.stream().distinct().sorted();

        System.out.printf("all      count: %,d%n", stream1.count());
        System.out.printf("distinct count: %,d%n", stream21.count());

        MyTools.h2("distinct");
        stream22.forEach(Person6::show);

        MyTools.h2("distinct/sort");
        stream3.forEach(Person6::show);
    }

    private static void t2_print(final int MAX) {
        initPersonen(MAX);
        MyTools.h1(String.format("t2_print max: %,d", MAX));

        Stream<Person6> stream1 = pList.stream();
        Stream<Person6> stream2 = pList.stream().distinct();

        Stream<Person6> stream3 = pList.stream().distinct();
        Stream<Person6> stream4 = pList.stream().distinct().sorted();

        var comparatorNameId = new Comparator<Person6>() {
            @Override
            public int compare(Person6 o1, Person6 o2) {
                String s1 = String.format("%-50s %d",
                        o1.getName(), o1.getId());
                String s2 = String.format("%-50s %d",
                        o2.getName(), o2.getId());
                return s1.compareTo(s2);
            }
        };

        var comparatorAgeId = new Comparator<Person6>() {
            @Override
            public int compare(Person6 o1, Person6 o2) {
                String s1 = String.format("%3d %10d",
                        o1.getAge(), o1.getId());
                String s2 = String.format("%3d %10d",
                        o2.getAge(), o2.getId());
                return s1.compareTo(s2);
            }
        };

        var comparatorGenderAgeId = new Comparator<Person6>() {
            @Override
            public int compare(Person6 o1, Person6 o2) {
                String s1 = String.format("%d %3d %10d",
                        o1.getGender(), o1.getAge(), o1.getId());
                String s2 = String.format("%d %3d %10d",
                        o2.getGender(), o2.getAge(), o2.getId());
                return s1.compareTo(s2);
            }
        };

        Stream<Person6> stream5 = pList.stream().distinct().sorted(comparatorNameId);
        Stream<Person6> stream6 = pList.stream().distinct().sorted(comparatorAgeId);
        Stream<Person6> stream7 = pList.stream().distinct().sorted(comparatorGenderAgeId);

        System.out.printf("all      count: %,d%n", stream1.count());
        System.out.printf("distinct count: %,d%n", stream2.count());

        MyTools.h2("distinct");
        stream3.forEach(Person6::show);

        MyTools.h2("distinct/sort");
        stream4.forEach(Person6::show);

        MyTools.h2("distinct/sort by name,id");
        stream5.forEach(Person6::show);

        MyTools.h2("distinct/sort by age,id");
        stream6.forEach(Person6::show);

        MyTools.h2("distinct/sort by gender,age,id");
        stream7.forEach(Person6::show);
    }

}
