package ch.jmildner.k05collections2.u7streams;

import ch.jmildner.k05collections2.u6bulks.Person6;
import ch.jmildner.tools11.MyTools;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class U724EndProcessing4 {

    private static final List<Person6> pList;

    static {
        pList = new LinkedList<>();
        for (int i = 1; i <= 30; i++) {
            pList.add(new Person6());
        }
    }

    public static void main(String[] args) {
        MyTools.h1("U724EndProcessing4 (findFirst, findAny)");

       // pList.stream().limit(30).forEach(Person6::show);

        Optional<Person6> p11 = pList.stream().findFirst();
        Optional<Person6> p12 = pList.stream().parallel().findFirst();
        Optional<Person6> p13 = pList.stream().parallel().findFirst();

        Optional<Person6> p21 = pList.stream().findAny();
        Optional<Person6> p22 = pList.stream().parallel().findAny();
        Optional<Person6> p23 = pList.stream().parallel().findAny();

        System.out.println();
        System.out.println("         First : " + p11);
        System.out.println("parallel First : " + p12);
        System.out.println("parallel First : " + p13);
        System.out.println();
        System.out.println("         Any   : " + p21);
        System.out.println("parallel Any   : " + p22);
        System.out.println("parallel Any   : " + p23);
    }

}
