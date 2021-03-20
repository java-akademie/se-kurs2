
package ch.jmildner.k09network.u5chat;

import ch.jmildner.tools11.MyTools;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) throws Exception {

        final int PORT = 5000;
        MyTools.h1("Start Chat Server on port " + PORT);

        ServerSocket serverSocket = new ServerSocket(PORT);

        // use counter instead of true in while()
        // to avoid a warning in INTELLIJ
        int counter = 0;
        while (++counter < 1_000_000) {
            Socket socket = serverSocket.accept();
            new ChatHandler(socket).start();
        }
    }
}
