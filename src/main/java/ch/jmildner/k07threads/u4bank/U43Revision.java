
package ch.jmildner.k07threads.u4bank;

public class U43Revision extends Thread {

    private int z1, z2;
    private final U41Konto konto1;
    private final U41Konto konto2;
    private final boolean sync;
    
    public U43Revision(
            U41Konto konto1, U41Konto konto2, boolean sync) {
        this.konto1 = konto1;
        this.konto2 = konto2;
        this.sync = sync;
    }

    public void run() {
        while (!isInterrupted()) {
            if (sync)
                pruefenSynchronized();
            else
                pruefen();
        }
    }

    private void pruefenSynchronized() {
        synchronized (konto1) {
            synchronized (konto2) {
                pruefen();
            }
        }
    }

    private void pruefen() {
        if (konto1.getSaldo() + konto2.getSaldo() == 0) {
            z1++;
        } else {
            z2++;
            konto1.setSaldo(0);
            konto2.setSaldo(0);
            if (z2 % 1_000_000 == 0) {
                System.out.printf("%,10d %n", z2);
            }
        }
    }

    public void statistik() {
        System.out.println();
        System.out.println("Revision: ");
        System.out.printf("Pruefung OK:  %,10d %n", z1);
        System.out.printf("Pruefung NOK: %,10d %n", z2);
    }
}
