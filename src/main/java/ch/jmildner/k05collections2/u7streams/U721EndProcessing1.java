package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class U721EndProcessing1 {

    private static List<Person6> pList;

    private static void initPersonen(final int MAX) {
        MyTools.comment(String.format("makes an ArrayList of %d people",MAX));
        pList = new ArrayList<>();

        for (int i = 1; i <= MAX; i++) {
            pList.add(new Person6());
        }
    }

    public static void main(String[] args) {
        MyTools.h2("U721EndProcessing1 (toArray, toList, toSet)");
        toObjectArray();
        toList();
        toArrayList();
        toLinkedList();
        toSet();
        toHashSet();
        toTreeSet();
    }

    private static void toObjectArray() {
        MyTools.h2("toObjectArray");

        initPersonen(2000);

        var v =  pList.stream()
                .distinct()
                .sorted()
                .toArray();

        System.out.printf("count: %d%n", v.length);

        for (Object o : v) {
            Person6 p = (Person6) o;
            p.show();
        }
    }

    private static void toList() {
        MyTools.h2("toList");

        initPersonen(100);

        var v = pList.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.printf("count: %d%n", v.size());

        v.forEach(Person6::show);
    }

    private static void toArrayList() {
        MyTools.h2("toArrayList");

        initPersonen(1000);

        var v = pList.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.printf("count: %d%n", v.size());

        v.forEach(Person6::show);
    }

    private static void toLinkedList() {
        MyTools.h2("toLinkedList");

        initPersonen(1000);

        var v = pList.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.printf("count: %d%n", v.size());

        v.forEach(Person6::show);
    }

    private static void toSet() {
        MyTools.h2("toSet all", 2);

        initPersonen(10);

        var v = pList.stream()
                .filter(Person6::isAdult)
                .collect(Collectors.toSet());

        System.out.printf("count: %d%n", v.size());
        v.forEach(Person6::show);
    }

    private static void toHashSet() {
        MyTools.h2("toHashSet females", 2);

        initPersonen(10);

        var v = pList.stream()
                .filter(p->p.getGender()==1)
                .collect(Collectors.toCollection(HashSet::new));

        System.out.printf("count: %d%n", v.size());

        v.forEach(Person6::show);
    }

    private static void toTreeSet() {
        MyTools.h2("toTreeSet males", 2);

        initPersonen(10);

        var v = pList.stream()
                .filter(p->p.getGender()==2)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.printf("count: %d%n", v.size());

        v.forEach(Person6::show);
    }

}
