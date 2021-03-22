package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.List;

public class U723EndProcessing3 {

    private static final List<Person6> pList;

    static {
        pList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            pList.add(new Person6());
        }
    }

    public static void main(String[] args) {
        MyTools.h1("U723EndProcessing3 (anyMatch, noneMatch, allMatch)");

        MyTools.h2("all people");
        pList.forEach(Person6::show);

        MyTools.comment("anyMatch");
        anyMatch("karin");
        anyMatch("moritz");

        MyTools.comment("noneMatch");
        noneMatch("albert");
       noneMatch("fritz");

        MyTools.comment("allMatch");
        allMatch();
    }

    private static void anyMatch(String name) {
        boolean found = pList.stream()
                .anyMatch(p -> p.getName().equals(name));
        System.out.printf("%s found: %b %n", name, found);
    }

    private static void noneMatch(String name) {
        boolean notFound = pList.stream()
                .noneMatch(p -> p.getName().equals(name));
        System.out.printf("%s not found: %b %n", name, notFound);
    }

    private static void allMatch() {
        boolean allFound = pList.stream()
                .allMatch(Person6::isAdult);
        System.out.println("there are only adults: " + allFound);
    }

}
