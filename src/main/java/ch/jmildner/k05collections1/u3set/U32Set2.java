package ch.jmildner.k05collections1.u3set;

import ch.jmildner.k05collections1.u2list.Person2;
import ch.jmildner.tools11.MyTools;
import java.util.Set;
import java.util.TreeSet;

public class U32Set2 {

    public static void main(String[] args) {
        MyTools.h1("U32Set2");

        setVariable();
        firstAndLastMethods();
    }

    private static void setVariable() {
        MyTools.h1("setVariable");

        MyTools.h2("Integers");
        {
            var set = Set.of(111, 222, 333);
            for (int s : set) {
                System.out.println(s);
            }
            System.out.println();
            set.forEach(System.out::println);
        }

        MyTools.h2("Strings");
        {
            var set = Set.of("fritz", "url", "franz", "albert");
            for (String s : set) {
                System.out.println(s);
            }
            System.out.println();
            set.forEach(System.out::println);
        }

        MyTools.h2("Person2");
        {
            var set = Set.of(
                    new Person2(), new Person2(), new Person2(),
                    new Person2(), new Person2(), new Person2());
            for (Person2 p : set) {
                System.out.println(p);
            }
            System.out.println();
            set.forEach(System.out::println);
        }
    }

    private static void firstAndLastMethods() {
        MyTools.h1("firstAndLastMethods");

        TreeSet<Person2> people = new TreeSet<>();

        Person2 p15 = null;
        Person2 p20 = null;
        Person2 p25 = null;

        MyTools.h2("insert 20 people (10-30)");
        {
            for (int i = 10; i <= 30; i++) {
                Person2 p = new Person2(i + "",
                        "name-" + MyTools.getRandom(10, 99));
                if (i == 15) p15 = p;
                else if (i == 20) p20 = p;
                else if (i == 25) p25 = p;
                people.add(p);
            }
            people.forEach(System.out::println);
        }

        MyTools.h2("show first and last person");
        {
            System.out.println(people.first());
            System.out.println(people.last());
        }

        MyTools.h2("show the headSet of the first people (begin to exclusive 20)");
        {
            Set<Person2> headSet = people.headSet(p20);
            headSet.forEach(System.out::println);
        }

        MyTools.h2("show the tailSet of the last people (20 to end)");
        {
            Set<Person2> tailSet = people.tailSet(p20);
            tailSet.forEach(System.out::println);
        }

        MyTools.h2("show the subSet of the middle people (from 15 to exclusive 25)");
        {
            Set<Person2> subSet = people.subSet(p15, p25);
            subSet.forEach(System.out::println);
        }
    }

}
