
package ch.jmildner.k09network.u4rechner;

import ch.jmildner.k09network.tools.NetTools;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RechnerService extends Thread {

    private final Socket socket;

    public RechnerService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (PrintWriter pw = NetTools.getPrintWriter(socket);
             BufferedReader br = NetTools.getBufferedReader(socket)) {

            String buffer = br.readLine();

            compute(buffer);
            pw.println(compute(buffer));
            pw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String compute(String buffer) {
        String op = "";
        String werte;

        if (buffer.startsWith("add(")) op = "add";
        else if (buffer.startsWith("sub(")) op = "sub";
        else if (buffer.startsWith("div(")) op = "div";
        else if (buffer.startsWith("mult(")) op = "mult";
        var i = buffer.indexOf('(') + 1;
        werte = buffer.substring(i, buffer.length() - 1);

        String[] w = werte.split(",");
        int a = Integer.parseInt(w[0]);
        int b = Integer.parseInt(w[1]);
        double erg = 0;

        switch (op) {
            case "add":
                erg = a + b;
                break;
            case "sub":
                erg = a - b;
                break;
            case "div":
                erg = (double) a / b;
                break;
            case "mult":
                erg = a * b;
                break;
        }

        return String.format("%5d  %s %5d = %,13.3f%n", a, getOp(op), b, erg);
    }

    private String getOp(String op) {
        if (op.equals("add")) return "+";
        if (op.equals("sub")) return "-";
        if (op.equals("div")) return "/";
        if (op.equals("mult")) return "*";
        return "nop";
    }

}

