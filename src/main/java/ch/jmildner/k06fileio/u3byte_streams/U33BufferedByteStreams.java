package ch.jmildner.k06fileio.u3byte_streams;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class U33BufferedByteStreams {

    static final int MAX = 10;
    static final String dirName = "temp";
    static final String fileName = "buffered_stream.txt";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("U33BufferedByteStreams");
        FileTools.makeDirectory(dirName);
        writeBufferedStream();
        readBufferedStream1();
        readBufferedStream2();
    }

    private static void readBufferedStream2() throws Exception {
        MyTools.h2("readBufferedStream - while(true) - EOFException");

        try (FileInputStream fis = new FileInputStream(pathName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataInputStream dis = new DataInputStream(bis)) {

            while (true) {
                try {
                    int iValue = dis.readInt();
                    double dValue = dis.readDouble();
                    String sValue = dis.readUTF();
                    System.out.printf("i=%3d, d=%5.1f, s=%s %n",
                            iValue, dValue, sValue);
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }

    private static void readBufferedStream1() throws Exception {
        MyTools.h2("readBufferedStream1 - for(i=1 to MAX)");

        try (FileInputStream fis = new FileInputStream(pathName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataInputStream dis = new DataInputStream(bis)) {

            for (int i = 1; i <= MAX; i++) {
                int iValue = dis.readInt();
                double dValue = dis.readDouble();
                String sValue = dis.readUTF();
                System.out.printf("i=%3d, d=%5.1f, s=%s %n",
                        iValue, dValue, sValue);
            }
        }
    }

    private static void writeBufferedStream() throws Exception {
        MyTools.h2("writeBufferedStream");

        try (FileOutputStream fos = new FileOutputStream(pathName);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             DataOutputStream dos = new DataOutputStream(bos)) {

            for (int i = 1; i <= MAX; i++) {
                String sValue = String.format("%03d-%s", i,
                        MyTools.getRandomString(MyTools.getRandom(5, 20)) + "/");
                dos.writeInt(i);
                dos.writeDouble(i);
                dos.writeUTF(sValue);
            }
        }
    }
}

