
package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class U711Creates {

    private static final Person6[] pArray;
    private static final List<Person6> pList;

    static {
        pArray = new Person6[12];
        for (var i = 0; i < 12; i++) {
            pArray[i] = new Person6();
        }
        pList = Arrays.asList(pArray);
    }

    public static void main(String[] args) {
        MyTools.h1("U711Creates");

        streamAusArray();
        streamAusList();
    }

    private static void streamAusArray() {
        MyTools.h1("streamAusArray");

        MyTools.h2("unsorted");
        {
            Stream<Person6> p = Arrays.stream(pArray);
            p.forEach(Person6::show);
        }

        MyTools.h2("sorted");
        {
            Stream<Person6> p = Arrays.stream(pArray)
                    .sorted();
            p.forEach(System.out::println);
        }

        MyTools.h2("sorted");
        {
            Arrays.stream(pArray).sorted().forEach(Person6::show);
        }

        MyTools.h2("distinct/sorted");
        {
            Stream<Person6> p = Arrays.stream(pArray)
                    .distinct()
                    .sorted();
            p.forEach(Person6::show);
        }

        MyTools.h2("adult/sorted");
        {
            Arrays.stream(pArray)
                    .filter(Person6::isAdult)
                    .sorted().forEach(System.out::println);
        }

        MyTools.h2("adult/distinct/sorted", 1);
        {
            Stream<Person6> p = Arrays.stream(pArray)
                    .filter(Person6::isAdult)
                    .distinct()
                    .sorted();
            p.forEach(System.out::println);
        }

        MyTools.h2("adult/distinct/sorted/limit(3)");
        {
            Arrays.stream(pArray)
                    .filter(Person6::isAdult)
                    .distinct()
                    .sorted()
                    .limit(3)
                    .forEach(System.out::println);
        }
    }

    private static void streamAusList() {
        MyTools.h1("streamAusList");

        MyTools.h2("unsorted");
        {
            Stream<Person6> p = pList.stream();
            p.forEach(System.out::println);
        }
        MyTools.h2("sorted");
        {
            pList.stream()
                    .sorted()
                    .forEach(System.out::println);
        }

        MyTools.h2("distinct/sorted");
        {
            Stream<Person6> p = pList.stream()
                    .distinct()
                    .sorted();
            p.forEach(System.out::println);
        }

        MyTools.h2("adult/sorted");
        {
            pList.stream()
                    .filter(Person6::isAdult)
                    .sorted()
                    .forEach(System.out::println);
        }

        MyTools.h2("adult/distinct/sorted");
        {
            Stream<Person6> p = pList.stream()
                    .filter(Person6::isAdult)
                    .distinct()
                    .sorted();
            p.forEach(Person6::show);
        }

        MyTools.h2("distinct/sorted/limit(3)");
        {
            Stream<Person6> p = pList.stream();

            p = p.distinct();
            p = p.sorted();
            p = p.limit(3);

            p.forEach(Person6::show);
        }

        MyTools.h2("distinct/limit(3)/sorted");
        {
            Stream<Person6> p = pList.stream();

            p = p.distinct();
            p = p.limit(3);
            p = p.sorted();

            p.forEach(Person6::show);
        }

        MyTools.h2("limit(3)/sorted");
        {
            Stream<Person6> p = pList.stream();

            p = p.limit(3);
            p = p.sorted();

            p.forEach(Person6::show);
        }
    }

}
