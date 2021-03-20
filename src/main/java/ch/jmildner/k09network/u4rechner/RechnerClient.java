
package ch.jmildner.k09network.u4rechner;

import ch.jmildner.k09network.tools.NetTools;
import ch.jmildner.tools11.MyTools;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RechnerClient {

    public static void main(String[] args) throws Exception {
        MyTools.h2("RechnerClient");

        useRechner("add(15,7)");
        useRechner("sub(32,5)");
        useRechner("mult(3,6)");
        useRechner("div(50,2)");
        System.out.println();
        useRechner(getRequest("add"));
        useRechner(getRequest("sub"));
        useRechner(getRequest("mult"));
        useRechner(getRequest("div"));

    }

    private static String getRequest(String op) {
        return String.format("%s(%d,%d)",
                op,
                MyTools.getRandom(500, 900) * vz(),
                MyTools.getRandom(100, 900) * vz());
    }

    private static int vz() {
        return MyTools.getRandom(1, 4) == 1 ? -1 : 1;
    }

    private static void useRechner(String request) throws Exception {

        try (Socket socket = new Socket("localhost", 6000);
             BufferedReader br = NetTools.getBufferedReader(socket);
             PrintWriter pw = NetTools.getPrintWriter(socket)) {

            pw.println(request);
            pw.flush();
            String response = br.readLine();
            System.out.println(response);
        }
    }
}

