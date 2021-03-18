
package ch.jmildner.k07threads.u1;

import ch.jmildner.tools11.MyTools;

public class U12Runnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(
                    "Message-" + i + " from " + this);
        }
    }

    public static void main(String[] args) {
        MyTools.h1("U12Runnable");
        Runnable r1 = new U12Runnable();
        Runnable r2 = new U12Runnable();
        Runnable r3 = new U12Runnable();
        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
    }
}
