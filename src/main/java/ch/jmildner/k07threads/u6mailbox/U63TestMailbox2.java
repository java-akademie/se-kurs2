
package ch.jmildner.k07threads.u6mailbox;
import ch.jmildner.tools11.MyTools;

public class U63TestMailbox2 {

    static U61Mailbox mailbox = new U61Mailbox();

    public static void main(String[] args) {

        MyTools.h1("Test Mailbox Synchronized");

        for (int i = 1; i <= 2000; i++) {
               new Thread(new U63Consumer2(mailbox)).start();
              new Thread(new U63Producer2(mailbox, i)).start();
        }
    }
}
