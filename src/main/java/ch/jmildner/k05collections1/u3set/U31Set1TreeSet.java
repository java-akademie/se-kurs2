
package ch.jmildner.k05collections1.u3set;

import ch.jmildner.k05collections1.u2list.Person2;
import ch.jmildner.tools11.MyTools;
import java.util.Set;
import java.util.TreeSet;

public class U31Set1TreeSet {

    private static final Set<Person2> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        MyTools.h1("U31Set1TreeSet");

        var set = U31Set1TreeSet.treeSet;

        {
            MyTools.h2("insert 12 people");
            for (int i = 1; i <= 4; i++) {
                String id2 = makeId(i * 2);
                String id3 = makeId(i * 3);
                String id4 = makeId(i * 4);
                System.out.println(id3 + " " + set.add(new Person2(id3, "name-" + i)));
                System.out.println(id2 + " " + set.add(new Person2(id2, "name-" + i)));
                System.out.println(id4 + " " + set.add(new Person2(id4, "name-" + i)));
            }
            showObjects(set);
        }

        {
            String id;
            MyTools.h2("insert 2 people (51,52)");
            id = "51";
            System.out.println(id + " " + set.add(new Person2(id, "dup-" + id)));
            System.out.println(id + " " + set.add(new Person2(id, "dup-" + id)));
            id = "52";
            System.out.println(id + " " + set.add(new Person2(id, "dup-" + id)));
            System.out.println(id + " " + set.add(new Person2(id, "dup-" + id)));
            showObjects(set);
        }

        {
            String id;
            MyTools.h2("remove 2 Person2 (4,6)");
            id = "04";
            System.out.println(id + " " + set.remove(new Person2(id, "xxx-" + id)));
            System.out.println(id + " " + set.remove(new Person2(id, "xxx-" + id)));
            id = "06";
            System.out.println(id + " " + set.remove(new Person2(id, "xxx-" + id)));
            System.out.println(id + " " + set.remove(new Person2(id, "xxx-" + id)));
            showObjects(set);
        }
    }

    private static void showObjects(Set<Person2> set) {
        for (Person2 p : set) {
            System.out.printf("    %-20s %n", p);
        }
    }

    private static String makeId(int id) {
        return String.format("%02d", id);
    }

}
