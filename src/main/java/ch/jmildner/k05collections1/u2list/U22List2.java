package ch.jmildner.k05collections1.u2list;
import ch.jmildner.tools11.MyTools;
import java.util.LinkedList;
import java.util.List;

public class U22List2 {

    public static void main(String[] args) {
        MyTools.h1("U22List2");

        firstAndLastMethods();
        listVariable();
    }

    private static void listVariable() {
        MyTools.h1("listVariable");

        var i1 = List.of(111, 222, 333);
        for (int i : i1) System.out.println(i);
        System.out.println();
        i1.forEach(System.out::println);
        System.out.println();
        var s1 = List.of("fritz", "franz");
        for (String s : s1) System.out.println(s);
        System.out.println();
        s1.forEach(System.out::println);
    }

    private static void firstAndLastMethods() {
        var list = new LinkedList<>();
        MyTools.h1("insert 8 people");
        for (int i = 1; i <= 8; i++) {
            list.add(new Person2());
        }
        show(list);
        MyTools.h2("show first and last Object");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        MyTools.h1("insert first and last String (xxxx, yyyy)");
        list.addFirst("xxxx");
        list.addLast("yyyy");
        show(list);
        MyTools.h2("show first and last Object");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }

    private static void show(List<Object> list) {
        MyTools.h2("showObjects");
        for (Object o : list) {
            System.out.println(o);
        }
    }

}

