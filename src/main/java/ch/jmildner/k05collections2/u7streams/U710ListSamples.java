
package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.Arrays;
import java.util.stream.Collectors;

public class U710ListSamples {
    private static final Person6[] pArray;

    static {
        final int MAX = 120;
        pArray = new Person6[MAX];
        for (var i = 0; i < MAX; i++) {
            pArray[i] = new Person6();
        }
    }

    public static void main(String[] args) {
        MyTools.h1("U710ListSamples - more than one iteration possible");
        listSampleDistinct();
        listSampleLadies();
        listSampleBoys();
    }

    private static void listSampleDistinct() {
        MyTools.h2("listSampleDistinct, sorted");

        var pList = Arrays.asList(pArray);

        // create operation
        var stream = pList.stream();

        // intermediate operation(s)
        stream = stream.distinct();
        stream = stream.sorted();

        // terminal operation
        var list = stream.collect(Collectors.toList());

        MyTools.comment("1st iteration");
        list.forEach(System.out::println);

        MyTools.comment("2nd iteration");
        list.forEach(Person6::show);

        MyTools.comment("3rd iteration");
        for (Person6 p : list) {
            p.show();
        }
    }

    private static void listSampleLadies() {
        MyTools.h2("listSampleLadies");

        var pList = Arrays.asList(pArray);

        // create operation
        var stream = pList.stream();

        // intermediate operation(s)
        stream = stream.distinct();
        stream = stream.sorted();
        stream = stream.filter(Person6::isAdult);
        stream = stream.filter(p -> p.getGender() == 1);

        // terminal operation
        var list = stream.collect(Collectors.toList());

        MyTools.comment("1st iteration");
        list.forEach(System.out::println);

        MyTools.comment("2nd iteration");
        list.forEach(Person6::show);

        MyTools.comment("3rd iteration");
        for (Person6 p : list) {
            p.show();
        }
    }

    private static void listSampleBoys() {
        MyTools.h2("listSampleBoys");

        var pList = Arrays.asList(pArray);

        var stream = pList.stream()
                .distinct()
                .sorted()
                .filter(p -> p.getAge() < 18)
                .filter(p -> p.getGender() == 2);

        // terminal operation
        var list = stream.collect(Collectors.toList());

        MyTools.comment("1st iteration");
        list.forEach(System.out::println);

        MyTools.comment("2nd iteration");
        list.forEach(Person6::show);

        MyTools.comment("3rd iteration");
        for (Person6 p : list) {
            p.show();
        }
    }

}
