
package ch.jmildner.k05collections1.u3set;

import ch.jmildner.k05collections1.u2list.Person2;
import ch.jmildner.tools11.MyTools;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class U34Comparator {

    public static void main(String[] args) {
        MyTools.h1("U34Comparator People ordered by name (asc/desc)");
        innerClass();
        anonymousInnerClass();
        lambda();
    }

    private static void innerClass() {
        MyTools.h1("innerClass", 2);

        class NameComparatorAscending implements Comparator<Person2> {
            @Override
            public int compare(Person2 first, Person2 second) {
                return first.getName().compareTo(second.getName());
            }
        }

        class NameComparatorDescending implements Comparator<Person2> {
            @Override
            public int compare(Person2 first, Person2 second) {
                return second.getName().compareTo(first.getName());
            }
        }

        var nca = new NameComparatorAscending();
        var ncd = new NameComparatorDescending();

        Set<Person2> pa = new TreeSet<>(nca);
        Set<Person2> pd = new TreeSet<>(ncd);

        for (int i = 100; i < 110; i++) {
            Person2 person = new Person2(
                    i + "",
                    "name-" + MyTools.getRandom(100, 999));

            pa.add(person);
            pd.add(person);
        }

        MyTools.h2("ascending");
        pa.forEach(System.out::println);

        MyTools.h2("descending");
        pd.forEach(System.out::println);
    }

    private static void anonymousInnerClass() {
        MyTools.h1("anonymousInnerClass", 2);

        Comparator<Person2> nca = new Comparator<>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Comparator<Person2> ncd = new Comparator<>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };


        var pa = new TreeSet<>(nca);
        var pd = new TreeSet<>(ncd);

        for (int i = 100; i < 110; i++) {
            Person2 person = new Person2(
                    i + "",
                    "name-" + MyTools.getRandom(100, 999));

            pa.add(person);
            pd.add(person);
        }

        MyTools.h2("ascending");
        pa.forEach(System.out::println);

        MyTools.h2("descending");
        pd.forEach(System.out::println);
    }

    private static void lambda() {
        MyTools.h1("lambda", 2);

        Comparator<Person2> nca = Comparator.comparing(Person2::getName);
        Comparator<Person2> ncd = (a, b) -> b.getName().compareTo(a.getName());

        Set<Person2> pa = new TreeSet<>(nca);
        Set<Person2> pd = new TreeSet<>(ncd);

        for (int i = 100; i < 110; i++) {
            Person2 person = new Person2(
                    i + "",
                    "name-" + MyTools.getRandom(100, 999));

            pa.add(person);
            pd.add(person);
        }

        MyTools.h2("ascending");
        pa.forEach(System.out::println);

        MyTools.h2("descending");
        pd.forEach(System.out::println);
    }

}
