
package ch.jmildner.k05collections2.u6bulks;

import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class U613SeparateTestAndLogic {

    public static void main(String[] args) {
        MyTools.h1("U613SeparateTestAndLogic");

        List<Person6> people = initPeople();

        test(people, false);
        people.add(3, null); // force an error
        test(people, true);
    }

    private static void test(List<Person6> people, boolean errorShouldOccur) {
        if (errorShouldOccur)
            MyTools.h1("test with an error", 2);
        else
            MyTools.h1("test without error", 2);

        separated(people);
        notSeparated(people);
    }

    public static void notSeparated(final List<Person6> people) {
        MyTools.h2("notSeparated");

        // test of state and logic is not separated
        // advantage:
        // --- faster
        // disadvantage:
        // --- there can be an interruption in the middle of the process

        if (people == null) {
            System.out.println("list of people is null");
            return;
        }
        for (Person6 p : people) {
            if (p == null) {
                System.out.println("Person ist null");
                return;
            } else
                p.show();
        }
    }

    public static void separated(final List<Person6> people) {
        MyTools.h2("separated");

        // test of state and logic is separated
        // advantage:
        // --- there is no interruption in the middle of the process
        // disadvantage:
        // --- slower because there are two iterations

        // test of state
        MyTools.comment("test of state");
        try {
            Objects.requireNonNull(people);
            people.forEach(Objects::requireNonNull);
            System.out.println("test OK");
        } catch (Exception e) {
            System.out.println("test Not OK, people or person is null");
            System.out.println("logic won't be started");
            return;
        }

        // logic
        MyTools.comment("logic");
        people.forEach(Person6::show);
    }

    private static List<Person6> initPeople() {
        List<Person6> people = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            people.add(new Person6());
        }
        return people;
    }

}
