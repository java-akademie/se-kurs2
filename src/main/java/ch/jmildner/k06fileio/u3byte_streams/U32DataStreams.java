
package ch.jmildner.k06fileio.u3byte_streams;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class U32DataStreams {

    static final int MAX = 10;
    static final String dirName = "temp";
    static final String fileName = "data_stream.txt";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("U32DataStreams");
        FileTools.makeDirectory(dirName);
        writeDataStream();
        readDataStream1();
        readDataStream2();
    }

    private static void readDataStream2() throws Exception {
        MyTools.h2("readDataStream2 - while(true) - EOFException");

        try (FileInputStream fis = new FileInputStream(pathName);
             DataInputStream dis = new DataInputStream(fis)) {

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

    private static void readDataStream1() throws Exception {
        MyTools.h2("readDataStream1 - for(i=1 to MAX)");

        try (FileInputStream fis = new FileInputStream(pathName);
             DataInputStream dis = new DataInputStream(fis)) {

            for (int i = 1; i <= MAX; i++) {
                int iValue = dis.readInt();
                double dValue = dis.readDouble();
                String sValue = dis.readUTF();

                System.out.printf("i=%3d, d=%5.1f, s=%s %n",
                        iValue, dValue, sValue);
            }
        }
    }

    private static void writeDataStream() throws Exception {
        MyTools.h2("write DataStream");

        try (FileOutputStream fos = new FileOutputStream(pathName);
             DataOutputStream dos = new DataOutputStream(fos)) {

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
