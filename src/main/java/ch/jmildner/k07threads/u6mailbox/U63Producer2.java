
package ch.jmildner.k07threads.u6mailbox;

public class U63Producer2 implements Runnable {
    final U61Mailbox mailbox;
    int nummernKreis;

    U63Producer2(U61Mailbox mailbox, int nummernKreis) {
        this.mailbox = mailbox;
        this.nummernKreis = nummernKreis;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            setMessage("message_" + nummernKreis + "/" + i);
        }
        setMessage("end-of-message " + nummernKreis);
    }

    private void setMessage(String s) {
        synchronized (mailbox) {
            while (mailbox.isMessageVorhanden()) {
                try {
                    mailbox.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mailbox.setMessage(s);
            mailbox.notifyAll();
        }
    }
}
