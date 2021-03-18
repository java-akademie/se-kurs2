
package ch.jmildner.k07threads.u5daemon;

import ch.jmildner.tools11.MyTools;

public class U50Daemon {

    public static void main(String[] args) {

        MyTools.h1("U50Daemon");

        Thread th1 = new Thread(() -> {

            Thread th2 = new Thread(() -> {
                while (true) {
                    System.out.println("Message aus Thread2 xxxxx");
                }
            });

            th2.setDaemon(true);
            th2.start();

            while (true) {
                System.out.println("Message aus Thread1 ooooo");
            }
        });

        th1.setDaemon(true);
        th1.start();

        MyTools.sleep(50);
        MyTools.h2("end of program");
    }
}

