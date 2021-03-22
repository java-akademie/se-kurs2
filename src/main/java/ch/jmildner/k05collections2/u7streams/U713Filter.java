package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class U713Filter {

    private static final List<Person6> pList;

    static {
        pList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            pList.add(new Person6());
        }
    }

    public static void main(String[] args) {
        MyTools.h2("U713Filter");

        testPredicate();

        t1_printAll();
        t2_printAdults();
        t3_printNotAdults();
        t4_printLadies();
        t5_printBoys();
    }

    private static void testPredicate() {
        MyTools.h2("testPredicate");

        var adult1 = new Predicate<Person6>() {
            @Override
            public boolean test(Person6 p) {
                return p.getAge() >= 18;
            }
        };

        Predicate<Person6> adult2 = Person6::isAdult;
        Predicate<Person6> adult3 = p -> p.getAge() >= 18;
        Predicate<Person6> woman = p -> p.getGender() == 1;
        Predicate<Person6> adultWoman = adult3.and(woman);

        Person6 person1 = new Person6();
        Person6 person2 = new Person6();
        Person6 person3 = new Person6();

        person1.show();
        testPredicate("isAdult", Person6::isAdult, person1);
        testPredicate("adult1", adult1, person1);
        testPredicate("woman", woman, person1);
        testPredicate("adult/woman", adultWoman, person1);

        person2.show();
        testPredicate("adult2", adult2, person2);
        testPredicate("woman", woman, person2);
        testPredicate("adult/woman", adultWoman, person2);

        person3.show();
        testPredicate("adult2", adult2, person3);
        testPredicate("woman", woman, person3);
        testPredicate("adult/woman", adultWoman, person3);
    }

    private static void testPredicate(String tpp, Predicate<Person6> pp, Person6 p) {
        System.out.printf("%20s - %s %n", tpp, pp.test(p));
    }

    private static void t1_printAll() {
        MyTools.h2("t1_printAll");
        Stream<Person6> all = pList.stream();
        all.forEach(Person6::show);
    }

    private static void t2_printAdults() {
        MyTools.h2("t2_printAdults");
        Stream<Person6> adults = pList.stream()
                .filter(Person6::isAdult);
        adults.forEach(Person6::show);
    }

    private static void t3_printNotAdults() {
        MyTools.h2("t3_printNotAdults");
        Stream<Person6> notAdults = pList.stream()
                .filter(p -> p.getAge() < 18);
        notAdults.forEach(Person6::show);
    }

    private static void t4_printLadies() {
        MyTools.h2("t4_printAdultWomen");
        Stream<Person6> women = pList.stream()
                .filter(Person6::isAdult)
                .filter(p -> p.getGender() == 1);
        women.forEach(Person6::show);
    }

    private static void t5_printBoys() {
        MyTools.h2("t5_printBoys");
        Stream<Person6> men = pList.stream()
                .filter(p -> p.getAge() < 18)
                .filter(p -> p.getGender() == 2);
        men.forEach(Person6::show);
    }

}
