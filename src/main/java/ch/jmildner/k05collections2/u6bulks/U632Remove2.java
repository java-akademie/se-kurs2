
package ch.jmildner.k05collections2.u6bulks;
import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class U632Remove2 {

    public static void main(String[] args) {
        MyTools.h1("U632Remove2 - second variant with removeIf()");

        final List<Person6> people = initPeople();

        Predicate<Person6> isNull = Objects::isNull;
        Predicate<Person6> isYoung = p -> p.getAge() < 18;
        Predicate<Person6> toDelete = isYoung.or(p -> p.getGender() == 2);

        MyTools.h1("remove nulls");
        people.removeIf(isNull);
        showPeople(people);

        MyTools.h1("remove people youngster or male - rest are adult females");
        people.removeIf(toDelete);
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
