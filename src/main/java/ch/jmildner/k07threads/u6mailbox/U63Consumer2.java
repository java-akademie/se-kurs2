
package ch.jmildner.k07threads.u6mailbox;

public class U63Consumer2 implements Runnable {

    final U61Mailbox mailbox;

    U63Consumer2(U61Mailbox mailbox) {
        this.mailbox = mailbox;
    }

    @Override
    public void run() {
        String message;
        do {
            message = getMessage();
            System.out.println(message);
        }
        while (!message.startsWith("end-of-message"));
    }
    
    private String getMessage(){

        String message;

        synchronized (mailbox)
        {
            while (!mailbox.isMessageVorhanden())
            {
                try
                {
                    mailbox.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            message = mailbox.getMessage();
            mailbox.notifyAll();
        }
        return message;
    }
}
