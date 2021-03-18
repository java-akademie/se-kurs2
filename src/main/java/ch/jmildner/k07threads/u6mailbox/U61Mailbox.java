
package ch.jmildner.k07threads.u6mailbox;

public class U61Mailbox {

    private String message = "noMessage";
    private boolean messageVorhanden = false;

    String getMessage() {
        messageVorhanden = false;
        return message;
    }

    void setMessage(String message) {
        this.message = message;
        messageVorhanden = true;
    }

    boolean isMessageVorhanden() {
        return messageVorhanden;
    }
}
