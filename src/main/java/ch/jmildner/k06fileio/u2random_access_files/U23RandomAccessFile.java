
package ch.jmildner.k06fileio.u2random_access_files;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;

public class U23RandomAccessFile {
    static final int MAX = 10;
    static final String dirName = "temp";
    static final String fileName = "raf.txt";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("u23RandomAccessFile");
        FileTools.makeDirectory(dirName);
        writeValues();
        readAllValues();
        MyTools.h2("read a view values");
        readValue(4);
        readValue(9);
        readValue(15);
        readValue(-1);
        readValue(0);
    }

    private static void writeValues() throws Exception {
        MyTools.h2(String.format("write %d Values into file %n", MAX));
        FileTools.deleteFile(new File(pathName));
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "rw")) {
            for (int i = 1; i <= MAX; i++) {
                raf.writeInt(i);
                raf.writeDouble(i * 100);
            }
        }
    }

    private static void readAllValues() throws Exception {
        MyTools.h2(String.format("read all Values %n"));
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "r")) {
            int id;
            double wert;
            while (true) {
                try {
                    id = raf.readInt();
                    wert = raf.readDouble();
                    System.out.println(id + "/" + wert);
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }

    private static void readValue(long n) throws Exception {
        if (n < 1) {
            System.out.printf("number %5d is wrong. It must be greater or equal 1 %n", n);
            return;
        }
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "r")) {
            raf.seek((n - 1) * 12); // int = 4 bytes, double = 8 bytes
            int id = raf.readInt();
            double wert = raf.readDouble();
            System.out.println(id + "/" + wert);
        } catch (EOFException e) {
            System.out.printf("double with number %5d is not available %n", n);
        }
    }

}
