
package ch.jmildner.k07threads.u3endless;

import ch.jmildner.tools11.MyTools;

public class U31Endless {

    public static void main(String[] args) {
        MyTools.h1("U31Endless");
        Thread th1 = new EndlessThread();
        Thread th2 = new EndlessThread();
        th1.start();
        th2.start();
        System.out.println("end of program reached ...");
    }

    // static inner class
    private static class EndlessThread extends Thread {
        @Override
        public void run() {
            long sum = 0;
            while (true) {
                System.out.println(this.getName() + " " + ++sum);
            }
        }
    }

}
