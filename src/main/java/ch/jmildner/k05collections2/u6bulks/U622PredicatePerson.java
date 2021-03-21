
package ch.jmildner.k05collections2.u6bulks;

import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class U622PredicatePerson {


    private static final Predicate<Person6> isAdult1 = p -> p.getAge() >= 18;
    private static final Predicate<Person6> isAdult2 = Person6::isAdult;
    private static final Predicate<Person6> isMale = p -> p.getGender() == 2;
    private static final Predicate<Person6> isYoung = isAdult2.negate();
    private static final Predicate<Person6> isFemale = isMale.negate();

    public static void main(String[] args) {
        MyTools.h1("Ue622PredicatePerson", 1);

        final List<Person6> people = initPeople();
        testSimple(people);
        testComplex(people);
    }

    private static void testSimple(List<Person6> people) {
        MyTools.h1("simple", 1);

        for (Person6 p : people) {
            System.out.println();
            p.show();
            test(p, isAdult1, "isAdult1");
            test(p, isAdult2, "isAdult2");
            test(p, isYoung, "isYoung");
            test(p, isMale, "isMale");
            test(p, isFemale, "isFemale");
        }
    }

    private static void testComplex(List<Person6> people) {
        MyTools.h1("complex", 1);

        for (Person6 p : people) {
            System.out.println();
            p.show();
            test(p, isAdult1.and(isMale), "adult1-man");
            test(p, isAdult1.and(isFemale), "adult1-female");
            test(p, isAdult2.and(isMale), "adult2-man");
            test(p, isAdult2.and(isFemale), "adult2-female");
            test(p, isYoung.and(isMale), "young-male");
            test(p, isYoung.and(isMale.negate()), "young-male-negate");
        }
    }

    private static void test(Person6 person,
                             Predicate<Person6> p,
                             String predicateName) {
        System.out.printf(
                "%33s.test(person) : %b %n",
                predicateName, p.test(person));
    }

    private static List<Person6> initPeople() {

        List<Person6> people = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            people.add(new Person6());
        }
        return people;
    }

}
