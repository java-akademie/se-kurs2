
package ch.jmildner.k09network.u3echo;

import ch.jmildner.k09network.tools.NetTools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoService extends Thread {

    private final Socket socket;
    private final int counter;

    public EchoService(Socket socket, int counter) {
        this.socket = socket;
        this.counter = counter;
    }

    @Override
    public void run() {
        try (PrintWriter pw = NetTools.getPrintWriter(socket);
             BufferedReader br = NetTools.getBufferedReader(socket)) {

            StringBuilder protocol = new StringBuilder();
            protocol.append(counter).append(". Requests\n");

            while (true) {
                String buffer = br.readLine();

                if (buffer.equals("end-of-requests")) {
                    printProtocol(protocol);
                    break;
                }

                protocol.append(buffer).append("\n");

                pw.println(counter + "..." + buffer);
                pw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printProtocol(StringBuilder protocol) {
        System.out.println(protocol.toString());
    }

}
