
package ch.jmildner.k06fileio.u4character_streams;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class U43PrintStream {

    static final int MAX = 10;
    static final String dirName = "temp";
    static final String fileName = "print_stream.txt";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("U43PrintStream (Writer)");
        FileTools.makeDirectory(dirName);
        writePrintStream();
    }

    private static void writePrintStream() throws Exception {
        MyTools.h2("writePrintStream");

        try (Writer fw = new FileWriter(pathName);
             PrintWriter pw1 = new PrintWriter(fw);
             PrintWriter pw2 = new PrintWriter(System.out)) {
            for (int i = 1; i <= MAX; i++) {
                pw1.println("file - i=" + i);
                pw2.println("system.out - i=" + i);
            }
        }
    }
}

