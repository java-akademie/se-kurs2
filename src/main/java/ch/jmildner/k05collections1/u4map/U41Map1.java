
package ch.jmildner.k05collections1.u4map;

import ch.jmildner.k05collections1.u2list.Person2;
import ch.jmildner.tools11.MyTools;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class U41Map1 {

    public static void main(String[] args) {
        MyTools.h1("U41Map1");

        final Map<Object, Object> hashMap = new HashMap<>();
        final Map<Object, Object> treeMap = new TreeMap<>();

        MyTools.h1("insert 8 people (0-7)");
        for (int i = 1; i <= 8; i++) {
            Person2 p = new Person2();
            hashMap.put(p.getId(), p.getName());
            treeMap.put(p.getId(), p.getName());
        }

        show1(hashMap);
        show1(treeMap);

        show2(hashMap);
        show2(treeMap);

        show3(hashMap);
        show3(treeMap);

    }

    private static void show1(Map<Object, Object> map) {
        if (map.size() == 0)
            return;
        MyTools.h2("keys " + map.getClass());
        var keys = map.keySet();
        System.out.println(keys);
        for (Object key : keys) {
            Object value = map.get(key);
            System.out.printf("key: %s, value: %s %n", key, value);
        }
    }

    private static void show2(Map<Object, Object> map) {
        if (map.size() == 0)
            return;
        MyTools.h2("entrySet " + map.getClass());
        var entrySet = map.entrySet();
        System.out.println(entrySet);
        entrySet.forEach(System.out::println);
        for (Map.Entry<Object, Object> entry : entrySet) {
            System.out.printf("key: %s, value: %s %n",
                    entry.getKey(), entry.getValue());
        }
    }

    private static void show3(Map<Object, Object> map) {
        if (map.size() == 0)
            return;
        MyTools.h2("values " + map.getClass());
        var values = map.values();
        System.out.println(values);
        values.forEach(System.out::println);
    }

}
