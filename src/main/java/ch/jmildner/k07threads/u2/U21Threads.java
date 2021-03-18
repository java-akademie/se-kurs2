
package ch.jmildner.k07threads.u2;

import ch.jmildner.tools11.MyTools;

public class U21Threads {

    private static final Thread listThread = new Thread() {
        @Override
        public void run() {
            for (int i = 1; i <= 1000; i++) {
                System.out.println(i);
            }
        }
    };

    private static final Thread countThread = new Thread() {
        @Override
        public void run() {
            long sum = 0;

            for (int i = 1; i <= 10_000; i++) {
                sum += i;
            }

            System.out.println("sum: " + sum);
        }
    };

    public static void main(String[] args) {
        MyTools.h1("U21Threads - List and Count");
        listThread.start();
        countThread.start();
    }
}
