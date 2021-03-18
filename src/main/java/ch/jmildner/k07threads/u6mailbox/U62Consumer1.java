package ch.jmildner.k07threads.u6mailbox;

public class U62Consumer1 implements Runnable {

    U61Mailbox mailbox;

    U62Consumer1(U61Mailbox mailbox) {
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
        return mailbox.getMessage();
    }
}
