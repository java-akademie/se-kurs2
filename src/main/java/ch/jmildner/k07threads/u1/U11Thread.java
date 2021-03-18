package ch.jmildner.k07threads.u1;

import ch.jmildner.tools11.MyTools;

public class U11Thread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(
                    "Message-" + i + " from " + this.getName());
        }
    }

    public static void main(String[] args) {
        MyTools.h1("U11Thread");
        Thread th1 = new U11Thread();
        Thread th2 = new U11Thread();
        Thread th3 = new U11Thread();
        th1.start();
        th2.start();
        th3.start();
    }
}
