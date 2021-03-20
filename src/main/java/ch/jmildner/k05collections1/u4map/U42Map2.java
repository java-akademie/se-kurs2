package ch.jmildner.k05collections1.u4map;

import ch.jmildner.k05collections1.u2list.Person2;
import ch.jmildner.tools11.MyTools;
import java.util.Map;
import java.util.TreeMap;

public class U42Map2 {

    public static void main(String[] args) {
        MyTools.h1("U42Map2");
        setVariable();
        firstAndLastMethods();
    }

    private static void setVariable() {
        MyTools.h1("setVariable");

        var map = Map.of(
                "52", "39", "12", "91", "32", "63",
                "22", "12", "62", "48", "42", "54",
                "51", "39", "11", "91", "31", "63",
                "21", "12"
        );

        var set = map.keySet();
        System.out.println(set);
        for (String key : set) {
            System.out.printf("key: %s, value: %s %n", key, map.get(key));
        }
    }

    private static void firstAndLastMethods() {
        MyTools.h1("firstAndLastMethods");

        TreeMap<String, String> map = new TreeMap<>();

        var pBegin = "";
        var pMiddle = "";
        var pEnd = "";

        MyTools.h2("insert 20 people");
        {
            for (int i = 1; i <= 20; i++) {
                Person2 p = new Person2(
                        "" + MyTools.getRandom(100, 990),
                        String.format("n%02d", i));
                map.put(p.getId(), p.getName());

                if (i == 1) pBegin = p.getId();
                else if (i == 2) pMiddle = p.getId();
                else if (i == 3) pEnd = p.getId();
            }
            if (pBegin.compareTo(pEnd) > 0) {
                var zw = pBegin;
                pBegin = pEnd;
                pEnd = zw;
            }

            var set = map.keySet();
            System.out.println(set);
            System.out.printf("pBegin:%s, pMiddle:%s, pEnd:%s %n", pBegin, pMiddle, pEnd);
            for (String key : set) {
                System.out.printf("key: %s, value: %s %n", key, map.get(key));
            }
        }

        MyTools.h2("show first and last Entry");
        {
            System.out.println(map.firstEntry());
            System.out.println(map.lastEntry());
        }

        MyTools.h2(String.format("show the first Objects " +
                "(begin to exclusive %s)", pMiddle));
        {
            Map<String, String> headMap = map.headMap(pMiddle);
            System.out.println(headMap);
        }

        MyTools.h2(String.format("show the last Objects " +
                "(%s to end)", pMiddle));
        {
            Map<String, String> tailMap = map.tailMap(pMiddle);
            System.out.println(tailMap);
        }

        MyTools.h2(String.format("show the middle Objects " +
                "(from %s to exclusive %s)", pBegin, pEnd));
        {
            Map<String, String> subMap = map.subMap(pBegin, pEnd);
            System.out.println(subMap);
        }
    }

}
