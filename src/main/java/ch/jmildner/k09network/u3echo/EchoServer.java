
package ch.jmildner.k09network.u3echo;

import ch.jmildner.tools11.MyTools;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws Exception {
        MyTools.h1("RechnerServer started");

        try (ServerSocket serverSocket = new ServerSocket(7000)) {
            int counter = 0;
            do {
                Socket socket = serverSocket.accept();
                new EchoService(socket, ++counter).start();
            } while (counter < 100); // to prevent warning from IntelliJ
        }

        MyTools.h1("RechnerServer stopped");
    }
}
