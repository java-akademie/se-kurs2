
package ch.jmildner.k04lambdas.u3weitere_techniken;

import ch.jmildner.tools11.MyTools;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class U33StringSort {

    public static void main(String[] args) {

        MyTools.h1("U33StringSort");

        final List<String> names = Arrays.asList
                ("michael", "johann-wolfgang", "stefan", "michael", "andy", "max");
        System.out.println(names.toString());

        MyTools.h2("Collection.sort(names)");
        Collections.sort(names);
        System.out.println(names.toString());

        MyTools.h2("names sort by length");
        names.sort((s1, s2) -> (Integer.compare(s2.length(), s1.length())));
        System.out.println(names.toString());

        MyTools.h2("names sort by compareTo() descending");
        names.sort(Comparator.reverseOrder());
        System.out.println(names.toString());
    }

}
