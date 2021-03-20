
package ch.jmildner.k05collections1.u3set;

import ch.jmildner.k05collections1.u2list.Person2;
import ch.jmildner.tools11.MyTools;
import java.util.HashSet;
import java.util.Set;

public class U31Set1HashSet {

    private static final Set<Object> hashSet = new HashSet<>();

    public static void main(String[] args) {
        MyTools.h1("U31Set1HashSet");

        var set = hashSet;

        MyTools.h1("insert 8 people");
        for (int i = 1; i <= 8; i++) {
            System.out.println(set.add(new Person2(i + "", "name-" + i)));
        }
        showObjects(set);

        MyTools.h1("insert 3 Strings (maximilian,albert,fritz)");
        System.out.println(set.add("maximilian"));
        System.out.println(set.add("albert"));
        System.out.println(set.add("fritz"));
        System.out.println(set.add("maximilian"));
        System.out.println(set.add("albert"));
        System.out.println(set.add("fritz"));
        showObjects(set);

        MyTools.h1("insert 3 Integers (4711,42,1024)");
        System.out.println(set.add(4711));
        System.out.println(set.add(42));
        System.out.println(set.add(1024));
        System.out.println(set.add(4711));
        System.out.println(set.add(42));
        System.out.println(set.add(1024));
        showObjects(set);

        MyTools.h1("insert 2 people (51,52)");
        System.out.println(set.add(new Person2(51 + "", "dup-51")));
        System.out.println(set.add(new Person2(52 + "", "dup-52")));
        System.out.println(set.add(new Person2(51 + "", "dup-51")));
        System.out.println(set.add(new Person2(52 + "", "dup-52")));
        showObjects(set);

        MyTools.h1("remove  2 Integers (4711,1024)");
        System.out.println(set.remove(4711));
        System.out.println(set.remove(1024));
        System.out.println(set.remove(4711));
        System.out.println(set.remove(1024));

        showObjects(set);

        MyTools.h1("remove 2 Person2 (5,7)");
        System.out.println(set.remove(new Person2(5 + "", "xxx")));
        System.out.println(set.remove(new Person2(7 + "", "xxx")));
        System.out.println(set.remove(new Person2(5 + "", "xxx")));
        System.out.println(set.remove(new Person2(7 + "", "xxx")));
        showObjects(set);

        MyTools.h1("remove 2 String (albert,fritz)");
        System.out.println(set.remove("albert"));
        System.out.println(set.remove("fritz"));
        System.out.println(set.remove("albert"));
        System.out.println(set.remove("fritz"));
        showObjects(set);
    }

    private static void showObjects(Set<Object> set) {
        for (Object o : set) {
            System.out.printf("%20s, %s %n", o, o.getClass());
        }
    }

}
