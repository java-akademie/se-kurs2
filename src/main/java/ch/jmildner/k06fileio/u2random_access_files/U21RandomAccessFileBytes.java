
package ch.jmildner.k06fileio.u2random_access_files;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.File;
import java.io.RandomAccessFile;

public class U21RandomAccessFileBytes {

    static final int MAX = 260;
    static String dirName = "temp";
    static String fileName = "raf.txt";
    static String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {

        MyTools.h1("U21RandomAccessFile - read and write bytes");

        FileTools.makeDirectory(dirName);

        write();
        read();

        MyTools.h2("read single bytes");
        read(100);
        read(0);
        read(-3);
        read(255);
        read(256);
        read(257);
        read(1000);
    }

    private static void write() throws Exception {

        MyTools.h2(String.format("write %d bytes into file", MAX));

        FileTools.deleteFile(new File(pathName));

        try (RandomAccessFile raf = new RandomAccessFile(pathName, "rw")) {
            for (int i = 0; i <= MAX; i++) {
                raf.write(i); // writes the right 8 bits of the int
            }
        }
    }

    private static void read() throws Exception {

        MyTools.h2("read all bytes from file");

        try (RandomAccessFile raf = new RandomAccessFile(pathName, "r")) {
            int b = raf.read();
            while (b != -1) {
                System.out.println(b);
                b = raf.read();
            }
        }

    }

    private static void read(long n) throws Exception {

        if (n < 0) {
            System.out.printf("byte number %6d   negative seek offset not allowed %n", n);
            return;
        }

        try (RandomAccessFile raf = new RandomAccessFile(pathName, "r")) {
            raf.seek(n);
            int b = raf.read();
            if (b == -1)
                System.out.printf("byte number %6d   byte not available %n", n);
            else
                System.out.printf("byte number %6d = %d %n", n, b);
        }
    }

}
