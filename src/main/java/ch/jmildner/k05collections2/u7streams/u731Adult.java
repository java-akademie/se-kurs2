package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.LinkedList;
import java.util.List;

public class u731Adult {
    private static final List<Person6> pList;

    static {
        pList = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            pList.add(new Person6());
        }
    }

    public static void main(String[] args) {
        MyTools.h2("Adult", 1);

        pList.forEach(Person6::show);

        System.out.println();

        pList.stream().filter(p -> p.getAge() >= 18)
                .forEach(System.out::println);

        System.out.println();

        pList.stream().filter(Person6::isAdult)
                .forEach(System.out::println);

        System.out.println();

        pList.stream().filter(Person6::isAdult)
                .forEach(System.out::println);
    }

}
