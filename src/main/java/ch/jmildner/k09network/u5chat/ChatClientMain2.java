
package ch.jmildner.k09network.u5chat;

public class ChatClientMain2 {

    private static final String name = "Jim";
    private static final String url = "localhost";
    private static final int port = 5000;
    private static final int pos = 2;

    public static void main(String[] args) {
        Runnable r = new ChatClient(name, url, port, pos);
        Thread t = new Thread(r);
        t.start();
    }
    
}
