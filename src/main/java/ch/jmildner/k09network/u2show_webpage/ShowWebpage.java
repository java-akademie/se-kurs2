
package ch.jmildner.k09network.u2show_webpage;

import ch.jmildner.k09network.tools.NetTools;
import ch.jmildner.tools11.MyTools;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

class ShowWebpage {

    public static void main(String[] args) throws Exception {
        MyTools.h1("ShowWebpage");

        showWebpage1("www.wikileaks.com");
        showWebpage1("www.google.com");
        showWebpage1("www.frnz.de");
        showWebpage2("www.ibm.com");
        showWebpage2("www.jmildner.ch");
        showWebpage2("www.java-akademie.ch");
        showWebpage2("www.frnz.de");
    }

    private static void showWebpage1(String url) throws Exception {
        MyTools.h2(url + " - HTTP1.0");

        try (
                Socket socket = new Socket(url, 80);
                PrintWriter pw = NetTools.getPrintWriter(socket);
                BufferedReader br = NetTools.getBufferedReader(socket)) {

            pw.println("GET /index.html HTTP/1.0");
            pw.println();
            pw.println("Host: " + url);
            pw.flush();
            String buffer;
            while ((buffer = br.readLine()) != null) {
                System.out.println(buffer);
            }
            System.out.println("$$$$$$$$$$");
        }
    }

    private static void showWebpage2(String url) throws Exception {
        MyTools.h2(url + " - HTTP1.1");

        try (Socket socket = new Socket(url, 80);
             PrintWriter pw = NetTools.getPrintWriter(socket);
             BufferedReader br = NetTools.getBufferedReader(socket)) {

            pw.println("GET / HTTP/1.1");
            pw.println("Host: " + url);
            // pw.println("Content-Length: 24");
            pw.println("Content-Type: application/x-www-form-urlencoded");
            pw.println();
            pw.println("");
            //pw.println("param1=wert1&param2=wert2");
            pw.flush();

            String buffer = br.readLine();
            while (buffer != null) {
                System.out.println(buffer);
                if (buffer.contains("</html>")) break;
                if (buffer.contains("_abck")) break;
                buffer = br.readLine();
            }
            System.out.println("$$$$$$$$$$");
        }
    }
}
