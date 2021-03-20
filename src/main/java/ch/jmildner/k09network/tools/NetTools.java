
package ch.jmildner.k09network.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class NetTools {

    public static PrintWriter getPrintWriter(Socket s) throws IOException {
        return new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
    }

    public static BufferedReader getBufferedReader(Socket s) throws IOException {
        return new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

}
