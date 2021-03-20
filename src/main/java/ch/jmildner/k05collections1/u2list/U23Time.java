
package ch.jmildner.k05collections1.u2list;

import ch.jmildner.tools11.MyTools;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class U23Time {

    private static List<Integer> list;
    private static double sum;

    public static void main(String[] args) {
        MyTools.h1("U23Time - compare runtime ArrayList, LinkedList");

        insertNormal(); // 10_000_000
        insertFirst();  //    100_000

        getFirst();     // 10_000_000
        getMiddle();    //    100_000
        getLast();      // 10_000_000

        removeLast();   // 10_000_000
        removeFirst();  //    100_000

        MyTools.h2("End of U23Time");
        System.out.println(sum);
    }

    private static void insertNormal() {
        var max = 10_000_000;
        MyTools.h2(String.format("insertNormal max: %,d", max));
        var a = insertNormalArrayList(max);
        var l = insertNormalLinkedList(max);
        System.out.printf("arrayList * %3.2f = linkedList%n", (double) l / a);
        System.out.printf("linkedList * %3.2f = arrayList%n", (double) a / l);
    }

    private static long insertNormalLinkedList(int max) {
        list = new LinkedList<>();
        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            list.add(i);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("LinkedList add(i) %,7d ms %n", duration);
        return duration;
    }

    private static long insertNormalArrayList(int max) {
        list = new ArrayList<>();
        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            list.add(i);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf(" ArrayList add(i) %,7d ms %n", duration);
        return duration;
    }

    private static void insertFirst() {
        var max = 100000;
        MyTools.h2(String.format("insertFirst max: %,d %n", max));

        var a = insertFirstArrayList(max);
        var l = insertFirstLinkedList(max);
        System.out.printf("arrayList * %5.3f = linkedList%n", (double) l / a);
        System.out.printf("linkedList * %5.3f = arrayList%n", (double) a / l);

    }

    private static long insertFirstArrayList(int max) {
        list = new ArrayList<>();
        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            list.add(0, i);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf(" ArrayList add(0,i) %,7d ms %n", duration);
        return duration;
    }

    private static long insertFirstLinkedList(int max) {
        list = new LinkedList<>();
        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            list.add(0, i);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("LinkedList add(0,i) %,7d ms %n", duration);
        return duration;
    }

    private static void getFirst() {
        var max = 10_000_000;
        MyTools.h2(String.format("getFirst max: %,d", max));
        var a = getFirstArrayList(max);
        var l = getFirstLinkedList(max);
        System.out.printf("arrayList * %5.3f = linkedList%n", (double) l / a);
        System.out.printf("linkedList * %5.3f = arrayList%n", (double) a / l);
    }

    private static long getFirstLinkedList(int max) {
        list = new LinkedList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            var value = (int) list.get(0);
            sum += value;
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("LinkedList get(0) %,7d ms %n", duration);
        return duration;
    }

    private static long getFirstArrayList(int max) {
        list = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            sum += list.get(0);


        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf(" ArrayList get(0) %,7d ms %n", duration);
        return duration;
    }

    private static void getMiddle() {
        var max = 100000;
        MyTools.h2(String.format("getMiddle max: %,d", max));
        var a = getMiddleArrayList(max);
        var l = getMiddleLinkedList(max);
        System.out.printf("arrayList * %5.3f = linkedList%n", (double) l / a);
        System.out.printf("linkedList * %5.3f = arrayList%n", (double) a / l);
    }

    private static long getMiddleLinkedList(int max) {
        list = new LinkedList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            sum += list.get(max / 2);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("LinkedList get(max/2) %,7d ms %n", duration);
        return duration;
    }

    private static long getMiddleArrayList(int max) {
        list = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            sum += list.get(max / 2);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf(" ArrayList get(max/2) %,7d ms %n", duration);
        return duration;
    }

    private static void getLast() {
        var max = 10_000_000;
        MyTools.h2(String.format("getLast max: %,d", max));
        var a = getLastArrayList(max);
        var l = getLastLinkedList(max);
        System.out.printf("arrayList * %5.3f = linkedList%n", (double) l / a);
        System.out.printf("linkedList * %5.3f = arrayList%n", (double) a / l);
    }

    private static long getLastLinkedList(int max) {
        list = new LinkedList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            var value = (int) list.get(max - 1);
            sum += value;
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("LinkedList get(max-1) %,7d ms %n", duration);
        return duration;
    }

    private static long getLastArrayList(int max) {
        list = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            sum += list.get(max - 1);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf(" ArrayList get(max-1) %,7d ms %n", duration);
        return duration;
    }

    private static void removeLast() {
        var max = 10_000_000;
        MyTools.h2(String.format("removeLast max: %,d", max));
        var a = removeLastArrayList(max);
        var l = removeLastLinkedList(max);
        System.out.printf("arrayList * %5.3f = linkedList%n", (double) l / a);
        System.out.printf("linkedList * %5.3f = arrayList%n", (double) a / l);
    }

    private static long removeLastArrayList(int max) {
        list = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            list.remove(list.size() - 1);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf(" ArrayList remove(size-1) %,7d ms %n", duration);
        return duration;
    }

    private static long removeLastLinkedList(int max) {
        list = new LinkedList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            list.remove(list.size() - 1);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("LinkedList remove(size-1) %,7d ms %n", duration);
        return duration;
    }

    private static void removeFirst() {
        var max = 100000;
        MyTools.h2(String.format("removeFirst max: %,d", max));
        var a = removeFirstArrayList(max);
        var l = removeFirstLinkedList(max);
        System.out.printf("arrayList * %5.3f = linkedList%n", (double) l / a);
        System.out.printf("linkedList * %5.3f = arrayList%n", (double) a / l);
    }

    private static long removeFirstArrayList(int max) {
        list = new ArrayList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            list.remove(0);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf(" ArrayList remove(0) %,7d ms %n", duration);
        return duration;
    }

    private static long removeFirstLinkedList(int max) {
        list = new LinkedList<>();

        for (int i = 1; i <= max; i++) {
            list.add(i);
        }

        var start = System.currentTimeMillis();
        for (int i = 1; i <= max; i++) {
            list.remove(0);
        }
        var duration = System.currentTimeMillis() - start;
        System.out.printf("LinkedList remove(0) %,7d ms %n", duration);
        return duration;
    }

}
