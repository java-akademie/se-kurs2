
package ch.jmildner.k07threads.u4bank;
import ch.jmildner.tools11.MyTools;
import java.util.Locale;

public class U44BankMain {
    private static final boolean sync = true;

    public static void main(String[] args) throws InterruptedException {
        MyTools.h1("Bank");
        Locale.setDefault(new Locale("de", "CH"));

        U41Konto konto1 = new U41Konto();
        U41Konto konto2 = new U41Konto();

        U42Filiale be = new U42Filiale("BE", konto1, konto2, sync);
        U42Filiale ge = new U42Filiale("GE", konto1, konto2, sync);
        U42Filiale zh = new U42Filiale("ZH", konto1, konto2, sync);

        U43Revision rev = new U43Revision(konto1, konto2, sync);

        MyTools.h2("open bank counter");
        be.start();
        ge.start();
        zh.start();
        rev.start();

        MyTools.sleep(4_000);

        be.interrupt();
        ge.interrupt();
        zh.interrupt();
        rev.interrupt();

        be.join();
        ge.join();
        zh.join();
        rev.join();

        MyTools.h2("close bank counter");

        be.statistik();
        ge.statistik();
        zh.statistik();
        rev.statistik();

        System.out.println();

        System.out.printf("Kontostand konto1: %+,d %n", konto1.getSaldo());
        System.out.printf("Kontostand konto2: %+,d %n", konto2.getSaldo());
    }
}
