
package ch.jmildner.k07threads.u3endless;

import ch.jmildner.tools11.MyTools;

public class U32Endless {

    public static void main(String[] args) throws InterruptedException {
        MyTools.h1("U32Endless");

        int ms = 500;

        Thread th1 = new EndlessThread();
        Thread th2 = new EndlessThread();
        Thread th3 = new EndlessThread();

        th1.start();
        MyTools.sleep(ms);
        th1.interrupt();

        th2.start();
        MyTools.sleep(ms);
        th2.interrupt();

        th3.start();
        MyTools.sleep(ms);
        th3.interrupt();

        th1.join();
        th2.join();
        th3.join();

        System.out.println("end of program reached ...");
    }

    // static inner class
    private static class EndlessThread extends Thread {
        @Override
        public void run() {
            long sum = 0;
            while (true) {
                if (isInterrupted()) {
                    System.out.println(this.getName() + " interrupted ...");
                    break;
                }
                System.out.printf("%9d, %s %n", ++sum,this.getName());
            }
        }
    }

}
