
package ch.jmildner.k05collections1.u2list;

import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class U21List1 {

    private static final List<Object> arrayList = new ArrayList<>();
    private static final List<Object> linkedList = new LinkedList<>();

    public static void main(String[] args) {

        show(arrayList);
        show(linkedList);

        var list = linkedList;
        MyTools.h1(String.format("U21List1 (%s)",list.getClass()));

        MyTools.h1("insert 8 people (0-7)");
        for (int i = 1; i <= 8; i++) {
            list.add(new Person2());
        }
        show(list);

        MyTools.h1("insert 3 Strings (8-10)");
        for (int i = 1; i <= 3; i++) {
            list.add("xxx-" + i);
        }
        show(list);

        MyTools.h1("insert 4 people (5,5,7,7)");
        list.add(new Person2(5 + "", "dup-51"));
        list.add(new Person2(5 + "", "dup-52"));
        list.add(new Person2(7 + "", "dup-71"));
        list.add(new Person2(7 + "", "dup-72"));
        show(list);

        MyTools.h1("remove  2 times index 5");
        list.remove(5);
        list.remove(5);
        show(list);

        MyTools.h1("remove 2 times id 5 und 7");
        System.out.println(list.remove(new Person2(5 + "", "xxx")));
        System.out.println(list.remove(new Person2(7 + "", "xxx")));
        show(list);

        MyTools.h1("remove 2 times index 5");
        System.out.println(list.remove(5));
        System.out.println(list.remove(5));
        show(list);
    }

    private static void show(List<Object> list) {
        if (list.size() == 0)
            return;

        showObjects(list);
        showStrings(list);
        showPeople(list);
    }

    private static void showObjects(List<Object> list) {
        if(list.size()==0)
            return;

        MyTools.h2("showObjects");
        for (Object o : list) {
            System.out.println(o);
        }
    }

    private static void showStrings(List<Object> list) {
        if(list.size()==0)
            return;

        MyTools.h2("showStrings");
        var found=false;
        for (Object o : list) {
            if (o.getClass() == String.class) {
                System.out.println(o);
                found = true;
            }
        }
        if(!found)
            System.out.println("no Strings in list");
    }

    private static void showPeople(List<Object> list) {
        if(list.size()==0)
            return;

        MyTools.h2("showPeople");
        var found=false;
        for (Object o : list) {
            if (o.getClass() == Person2.class) {
                Person2 p = (Person2) o;
                System.out.printf("id: %s, name: %s %n", p.getId(), p.getName());
                found=true;
            }
        }
        if(!found)
            System.out.println("no People in list");
    }

}
