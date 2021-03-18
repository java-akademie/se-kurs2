
package ch.jmildner.k07threads.u6mailbox;

import ch.jmildner.tools11.MyTools;

public class U62TestMailbox1 {

    static U61Mailbox mailbox = new U61Mailbox();

    public static void main(String[] args) {

        MyTools.h1("Test Mailbox not Synchronized");
        for (int i = 1; i <= 3; i++) {
            new Thread(new U62Consumer1(mailbox)).start();
            new Thread(new U62Producer1(mailbox, i)).start();
        }
    }
}
