
package ch.jmildner.k07threads.u2;

import ch.jmildner.tools11.MyTools;

public class U22Runnables {

    private static final Runnable r1List = () -> {
        for (int i = 1; i <= 1000; i++)
            System.out.println(i);
    };

    private static final Runnable r2Count = () -> {
        long sum = 0;
        for (int i = 1; i <= 10_000; i++) {
            sum += i;
        }
        System.out.println("sum: " + sum);
    };

    public static void main(String[] args) {
        MyTools.h1("U22Runnables - List and Count");

        Thread th1 = new Thread(r1List);
        Thread th2 = new Thread(r2Count);

        th1.start();
        th2.start();
    }

}
