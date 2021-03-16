
package ch.jmildner.k04lambdas.u3weitere_techniken;
import ch.jmildner.tools11.MyTools;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class U32Out {

    public static void main(String[] args) {
        MyTools.h1("U32Out");
        testList();
        testSet1();
        testSet2();
    }

    private static void testList() {
        MyTools.h2("testList - duplicates allowed");
        List<Integer> i = List.of(111, 234, 942, 111, 687);
        List<String> s = List.of("mike", "bill", "mike", "jack");
        i.forEach(System.out::println);
        System.out.println();
        s.forEach(System.out::println);
    }

    private static void testSet1() {
        MyTools.h2("testSet1 - duplicates not allowed");
        Set<Integer> is = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            is.add(MyTools.getRandom(1, 9));
        }
        Set<String> ss = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            ss.add("x-" + MyTools.getRandom(1, 9));
        }
        System.out.println("size of is: " + is.size());
        is.forEach(System.out::println);
        System.out.println();
        System.out.println("size of ss: " + ss.size());
        ss.forEach(System.out::println);
    }

    private static void testSet2() {
        MyTools.h2("testSet2 - Immutable");
        Set<Integer> i = Set.of(111, 234, 942, 687);
        Set<String> s = Set.of("mike", "bill", "jack");
        i.forEach(System.out::println);
        System.out.println();
        s.forEach(System.out::println);
    }

}
