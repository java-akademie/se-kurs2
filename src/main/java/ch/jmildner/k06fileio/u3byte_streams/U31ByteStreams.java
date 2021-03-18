
package ch.jmildner.k06fileio.u3byte_streams;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class U31ByteStreams {
    
    static final String dirName = "temp";
    static final String fileName = "stream.txt";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("U31ByteStreams");
        FileTools.makeDirectory(dirName);
        writeAndReadBytes();
        writeAndReadByteArrays();
    }

    static void writeAndReadBytes() throws Exception {
        MyTools.h1("writeAndReadBytes");
        writeBytes();
        readBytes();
    }

    private static void readBytes() throws Exception {
        MyTools.h2("readBytes");
        try (FileInputStream fis = new FileInputStream(pathName)) {
            int i = fis.read();
            while (i != -1) {
                if (i % 16 == 0) {
                    System.out.println();
                }
                System.out.printf("%3d=%c, ", i, i);
                i = fis.read();
            }
            System.out.println();
        }
    }

    private static void writeBytes() throws Exception {
        MyTools.h2("writeBytes");
        try (FileOutputStream fos = new FileOutputStream(pathName)) {
            fos.write(97); // 97=a
            for (int i = 0; i <= 260; i++) {
                fos.write(i);
            }
        }
    }

    private static void writeAndReadByteArrays() throws Exception {
        MyTools.h1("writeAndReadByteArrays");
        writeByteArray();
        readByteArray();
    }

    private static void readByteArray() throws Exception {
        MyTools.h2("readByteArray");
        byte[] ba = new byte[1000];
        int len;
        try (FileInputStream fis = new FileInputStream(pathName)) {
            len = fis.read(ba);
        }
        System.out.println("len=" + len);
        for (int i = 0; i < len; i++) {
            System.out.printf("%c", ba[i]);
        }
    }

    private static void writeByteArray() throws Exception {
        MyTools.h2("writeByteArray");
        byte[] ba1 = {'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h',
                'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o',
                'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g',
                'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o'};
        try (FileOutputStream fos = new FileOutputStream(pathName)) {
            fos.write(ba1, 2, 32);
        }
    }

}
