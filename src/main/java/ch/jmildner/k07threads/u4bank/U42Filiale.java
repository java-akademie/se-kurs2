
package ch.jmildner.k07threads.u4bank;

public class U42Filiale extends Thread {

    private int z1;
    private final String name;
    private final U41Konto konto1;
    private final U41Konto konto2;
    private final boolean sync;


    public U42Filiale(
            String name,
            U41Konto konto1,
            U41Konto konto2,
            boolean sync) {

        this.name = name;
        this.konto1 = konto1;
        this.konto2 = konto2;
        this.sync = sync;
    }


    public void run() {
        while (!isInterrupted()) {
            if (sync)
                buchenSynchronized();
            else
                buchen();
        }
    }

    private void buchenSynchronized() {
        synchronized (konto1) {
            synchronized (konto2) {
                buchen();
            }
        }
    }

    private void buchen() {
        z1++;

        int betrag = (int) (Math.random() * 1000);

        konto1.abheben(betrag);
        konto2.einzahlen(betrag);
    }

    public void statistik() {
        System.out.println();
        System.out.printf("Filiale %s:%n", name);
        System.out.printf("Buchungen:    %,10d %n", z1);
    }
}
