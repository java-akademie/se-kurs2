package ch.jmildner.k05collections2.u6bulks;

import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class U631Remove1 {

    public static void main(String[] args) {
        MyTools.h1("U631Remove1 - first variant with iterator");

        final List<Person6> people = initPeople();


        removeNulls(people);
        removeYoungsters(people);
    }

    private static void removeYoungsters(List<Person6> people) {

        MyTools.h1("remove youngster");

        final Predicate<Person6> isYoung = p -> p.getAge() < 18;

        final Iterator<Person6> it = people.iterator();

        while (it.hasNext()) {
            Person6 p = it.next();

            if (isYoung.test(p)) {
                p.show();
                it.remove();
            }
        }

        showPeople(people);
    }

    private static void removeNulls(List<Person6> people) {
        MyTools.h1("removeNulls");

        final Predicate<Person6> isNull = Objects::isNull;

        final Iterator<Person6> it = people.iterator();

        while (it.hasNext()) {
            if (isNull.test(it.next())) {
                System.out.println("remove null Person");
                it.remove();
            }
        }

        showPeople(people);
    }

    private static List<Person6> initPeople() {
        MyTools.h1("initPeople");
        List<Person6> people = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            people.add(new Person6());
        }
        people.add(null);
        people.add(null);
        for (int i = 0; i < 6; i++) {
            people.add(new Person6());
        }

        showPeople(people);
        return people;
    }

    private static void showPeople(List<Person6> people) {
        MyTools.h2("showPeople");
        for (Person6 p : people) {
            if (p == null)
                System.out.println("null person");
            else
                p.show();
        }
    }

}
