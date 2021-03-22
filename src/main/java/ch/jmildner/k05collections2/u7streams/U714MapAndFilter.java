package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTestDatenTools;
import ch.jmildner.tools11.MyTools;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class U714MapAndFilter {

    private static final List<Person6> pList;

    static {
        pList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            pList.add(new Person6());
        }
    }

    public static void main(String[] args) {
        MyTools.h1("U714MapAndFilter", 2);

        printAllUnsorted();
        printAllSorted();

        t1_printAll();
        t2_printAdults();
        t3_printNotAdults();
        t4_printLadies();
        t5_printWithLastName();
    }

    private static void printAllUnsorted() {
        MyTools.h2("printAllUnsorted");
        Stream<Person6> all = pList.stream();
        all.forEach(System.out::println);
    }

    private static void printAllSorted() {
        MyTools.h2("printAllSorted");
        Stream<Person6> all = pList.stream().sorted();
        all.forEach(System.out::println);
    }

    private static void t1_printAll() {
        MyTools.h2("t1_printAll - id/name/addr");
        Stream<String> all = pList.stream()
                .sorted()
                .map(p -> p.getId() + "/" + p.getName() + "/" + p.getAddr());
        all.forEach(System.out::println);
    }

    private static void t2_printAdults() {
        MyTools.h2("t2_printAdults - id/name/age");

        Stream<String> adults = pList.stream()
                .filter(Person6::isAdult)
                .sorted()
                .map(p -> p.getId() + "/" + p.getName() + "/" + p.getAge());

        adults.forEach(System.out::println);
    }

    private static void t3_printNotAdults() {
        MyTools.h2("t3_printNotAdults id/name/age");

        Stream<String> notAdults = pList.stream()
                .filter(p -> p.getAge() < 18)
                .map(p -> p.getId() + "/" + p.getName() + "/" + p.getAge());

        notAdults.forEach(System.out::println);
    }

    private static void t4_printLadies() {
        MyTools.h2("t4_printLadies name/addr/age");

        Stream<String> ladies = pList.stream()
                .filter(Person6::isAdult)
                .filter(p -> p.getGender() == 1)
                .map(p -> p.getName()
                        + "/" + p.getAddr()
                        + "/" + p.getAge());

        ladies.forEach(System.out::println);
    }

    private static void t5_printWithLastName() {
        MyTools.h2("t5_printWithLastName distinct, id/name/lastName");
        Stream<String> all = pList.stream()
                .distinct()
                .sorted()
                .map(p -> p.getId()
                        + "/" + p.getName()
                        + " " + MyTestDatenTools.getLastName());
        all.forEach(System.out::println);
    }

}
