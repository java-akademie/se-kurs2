
package ch.jmildner.k09network.u4rechner;

import ch.jmildner.tools11.MyTools;
import java.net.ServerSocket;
import java.net.Socket;

public class RechnerServer {

    public static void main(String[] args) throws Exception {
        MyTools.h1("RechnerServer started");

        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            int counter = 0;
            while (++counter < 1000) {
                Socket socket = serverSocket.accept();
                new RechnerService(socket).start();
            }
        }

        MyTools.h1("RechnerServer stopped");
    }

}
