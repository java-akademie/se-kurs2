
package ch.jmildner.k06fileio.u2random_access_files;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class U22RandomAccessFileAnyTypes {

    static final int MAX = 10;
    static final String dirName = "temp";
    static final String fileName = "raf.txt";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("U22RandomAccessFileAnyTypes");
        FileTools.makeDirectory(dirName);
        testDoubles();
        testStrings();
    }

    private static void testStrings() throws Exception {
        MyTools.h1("testStrings");
        writeStrings();
        readAllString();
        MyTools.h2("read a few Strings");
        readString(1);
        readString(7);
        readString(10);
        readString(20);
        readString(-21);
        readString(3);
    }

    private static void readString(long number) throws Exception {
        if (number < 1) {
            System.out.printf("number %5d is wrong. It must be greater or equal 1 %n", number);
            return;
        }
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "r")) {
            raf.seek(((number - 1) * 26));
            String value = raf.readLine();
            System.out.printf("double with number %5d is %5s %n", number, value);
        }
    }

    private static void readAllString() throws Exception {
        MyTools.h2("readAllStrings");
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "r")) {
            String value = raf.readLine();
            while (value != null) {
                System.out.println(value);
                value = raf.readLine();
            }
        }
    }

    private static void writeStrings() throws Exception {
        MyTools.h2("writeStrings");
        FileTools.deleteFile(new File(pathName));
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "rw")) {
            for (int i = 1; i <= MAX; i++) {
                String value = String.format("%02d-%s%n", // length of string = 25
                        i, MyTools.getRandomString(20) + "/");
                 raf.writeBytes(value);
            }
        }
    }

    private static void testDoubles() throws Exception {
        MyTools.h1("testDoubles");
        writeDoubles();
        readAllDoubles();
        MyTools.h2("read a few doubles");
        readDouble(5);
        readDouble(7);
        readDouble(12);
        readDouble(-10);
        readDouble(0);
        readDouble(3);
    }

    private static void readDouble(long number) throws IOException {
        if (number < 1) {
            System.out.printf("number %5d is wrong. It must be greater or equal 1 %n", number);
            return;
        }
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "r")) {
            raf.seek((number - 1) * 8);
            double value = raf.readDouble();
            System.out.printf("double with number %5d is %5f %n", number, value);
        } catch (EOFException e) {
            System.out.printf("double with number %5d is not available %n", number);
        }
    }

    private static void readAllDoubles() throws IOException {
        MyTools.h2("readAllDoubles");
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "r")) {
            double sum = 0;
            while (true) {
                try {
                    double value = raf.readDouble();
                    System.out.println(value);
                    sum += value;
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("sum: " + sum);
        }
    }

    private static void writeDoubles() throws IOException {
        MyTools.h2("writeDoubles");
        FileTools.deleteFile(new File(pathName));
        try (RandomAccessFile raf = new RandomAccessFile(pathName, "rw")) {
            for (int i = 1; i <= MAX; i++) {
                double value = i * 10;
                raf.writeDouble(value);
            }
        }
    }

}
