
package ch.jmildner.k09network.u5chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatHandler extends Thread {

    static int i;

    int counter = 0;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    String name;
    
    final static  List<ChatHandler> handlers = new ArrayList<>();


    ChatHandler(Socket socket) throws Exception {
        System.out.println(socket.getPort());
        this.socket = socket;
        in = new DataInputStream(new BufferedInputStream(
                socket.getInputStream()));
        out = new DataOutputStream(new BufferedOutputStream(
                socket.getOutputStream()));

        this.name = in.readUTF() + "-" + ++i;
        System.out.println("" + "new client '" + name + "' from '"
                + socket.getInetAddress() + "'");
    }


    void broadcast(String message) {
        synchronized (handlers) {
            System.out.println(message);

            for (ChatHandler handler : handlers) {
                try {
                    handler.out.writeUTF(message);
                    handler.out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void run() {
        try {
           whoIsThere(this);
            handlers.add(this);

            broadcast(name + " entered ");
            // use c instead of true in while()
            // to avoid a warning in INTELLIJ
            int c = 0;
            while (++c < 1_000_000) {
                String message = in.readUTF();
                counter++;
                broadcast(name + ": " + counter + ". " + message);
            }
        } catch (Exception e) {
            System.out.println("Connection to user '"
                    + name + "' lost");
        } finally {
            handlers.remove(this);

            broadcast("user '" + name + "' left");

            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("--Socket to user already closed ?");
                e.printStackTrace();
            }
        }
    }


    void whoIsThere(ChatHandler h) {
        synchronized (handlers) {
            if (handlers.size() > 0) {

                for (ChatHandler handler : handlers) {
                    try {
                        h.out.writeUTF(handler.name
                                + " is in Chat-Room");
                        h.out.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    h.out.writeUTF("nobody is in the Chat-Room");
                    h.out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
