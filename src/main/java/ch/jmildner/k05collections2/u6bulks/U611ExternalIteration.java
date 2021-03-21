
package ch.jmildner.k05collections2.u6bulks;

import ch.jmildner.tools11.MyTools;
import java.util.Arrays;
import java.util.Iterator;

public final class U611ExternalIteration {

    private static final String[] names = {"hans", "dampf", "in", "allen", "gassen"};

    public static void main(String[] args) {
        MyTools.h1("U611$ExternalIteration");

        testArray();
        testList();
    }

    private static void testArray() {
        MyTools.h2("testArray", 3);

        MyTools.comment("index", 0);
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }

        MyTools.comment("for(String s : ar)", 2);
        for (String s : names) {
            System.out.print(s + " ");
        }
    }

    private static void testList() {
        MyTools.h2("testList", 3);

        var list = Arrays.asList(names);

        MyTools.comment("index", 0);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        MyTools.comment("for(String s : list)", 2);
        for (String s : list) {
            System.out.print(s + " ");
        }

        MyTools.comment("iterator - for", 2);
        for (Iterator<String> it1 = list.iterator(); it1.hasNext(); ) {
            System.out.print(it1.next() + " ");
        }

        MyTools.comment("iterator - while", 2);
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }
    }

}
