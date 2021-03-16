
package ch.jmildner.k04lambdas.u3weitere_techniken;

import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class U34PersonSort {

    public static void main(String[] args) {

        MyTools.h1("U34PersonSort");

        List<U34Person> people = new ArrayList<>();

        people.add(new U34Person(4, "doubleMax2"));
        people.add(new U34Person(3, "michael"));
        people.add(new U34Person(4, "doubleMax1"));
        people.add(new U34Person(5, "johann-wolfgang"));
        people.add(new U34Person(2, "andy"));
        people.add(new U34Person(4, "doubleMax3"));
        people.add(new U34Person(1, "stefan"));

        System.out.println(people.toString());

        MyTools.h2("people.sort by id descending");
        // people.sort((p2, p1) -> Integer.compare(p2.getId(), p1.getId()));
        people.sort(Comparator.comparingInt(U34Person::getId));
        System.out.println(people.toString());

        MyTools.h2("people.sort by id ascending");
        people.sort(Comparator.comparingInt(U34Person::getId));
        System.out.println(people.toString());

        MyTools.h2("people.sort by name descending");
        people.sort((p1, p2) -> (p2.getName().compareTo(p1.getName())));
        System.out.println(people.toString());

        MyTools.h2("people.sort by name ascending");
        people.sort(Comparator.comparing(U34Person::getName));
        System.out.println(people.toString());

        MyTools.h2("people.sort by length of name ascending");
        people.sort(Comparator.comparingInt(s -> s.getName().length()));
        System.out.println(people.toString());
    }
}
