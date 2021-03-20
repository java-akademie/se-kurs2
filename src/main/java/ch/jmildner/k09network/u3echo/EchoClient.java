
package ch.jmildner.k09network.u3echo;

import ch.jmildner.k09network.tools.NetTools;
import ch.jmildner.tools11.MyTools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) throws Exception {
        MyTools.h2("RechnerClient");

        try (Socket socket = new Socket("localhost", 7000);
             BufferedReader br = NetTools.getBufferedReader(socket);
             PrintWriter pw = NetTools.getPrintWriter(socket)) {

            for (int i = 1; i <= 5; i++) {
                sendTheRequest(pw, "request-" + i);
                System.out.println(readTheResponse(br));
            }

            sendTheEndOfRequests(pw);
        }
    }

    private static void sendTheRequest(PrintWriter pw, String request) {
        pw.println(request);
        pw.flush();
    }

    private static void sendTheEndOfRequests(PrintWriter pw) {
        pw.println("end-of-requests");
        pw.flush();
    }

    private static String readTheResponse(BufferedReader br) throws IOException {
        return br.readLine();
    }

}
