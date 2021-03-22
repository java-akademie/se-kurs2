
package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.Arrays;
import java.util.stream.Collectors;

public class U710StreamSamples {
    private static final Person6[] pArray;

    static {
        pArray = new Person6[12];
        for (var i = 0; i < 12; i++) {
            pArray[i] = new Person6();
        }
    }

    public static void main(String[] args) {
        MyTools.h1("U710StreamSamples");
        streamSample1();
        streamSample2();
        streamSample3();
        streamSample4();
    }

    private static void streamSample1() {
        MyTools.h2("streamSample1");

        var pList = Arrays.asList(pArray);

        var stream = pList.stream();

        stream = stream.filter(Person6::isAdult);
        stream = stream.sorted();

        stream.forEach(Person6::show);
    }

    private static void streamSample2() {
        MyTools.h2("streamSample2 adults");

        var pList = Arrays.asList(pArray);

        var stream = pList.stream()
                .filter(Person6::isAdult)
                .sorted();

        MyTools.comment("1st iteration");
        stream.forEach(Person6::show);

        MyTools.comment("2nd iteration - shouldn't be ok");
        try {
            stream.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void streamSample3() {
        MyTools.h2("streamSample3 all sorted");

        var pList = Arrays.asList(pArray);

        pList.stream()
                .sorted()
                .forEach(Person6::show);
    }

    private static void streamSample4() {
        MyTools.h2("streamSample4 girls - more iterations possible");

        var pList = Arrays.asList(pArray);

        var stream = pList.stream()
                .filter(p -> p.getAge() < 18)
                .filter(p -> p.getGender() == 1)
                .sorted();

        MyTools.comment("the only iteration girls makes a girlsList");
        var list = stream.collect(Collectors.toList());

        MyTools.comment("1st iteration girlsList");
        list.forEach(System.out::println);

        MyTools.comment("2nd iteration girlsList");
        list.forEach(Person6::show);
    }

}
