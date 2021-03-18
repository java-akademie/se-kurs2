
package ch.jmildner.k06fileio.u4character_streams;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class U41CharacterStreams {

    static final String dirName = "temp";
    static final String fileName = "character_stream.txt";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("U41CharacterStreams (Reader/Writer)");
        FileTools.makeDirectory(dirName);
        writeAndReadCharacters();
        writeAndReadeCharacterArrays();
    }

    static void writeAndReadCharacters() throws Exception {
        MyTools.h1("writeAndReadCharacters");
        writeCharacters();
        readCharacters();
    }

    private static void readCharacters() throws Exception {
        MyTools.h2("readCharacters");

        try (Reader fr = new FileReader(pathName)) {
            int i = fr.read();
            while (i != -1) {
                if (i % 10 == 0)
                    System.out.println();
                System.out.printf("%5d =\t%3c, \t", i, i);
                i = fr.read();
            }
        }
        System.out.println();
    }

    private static void writeCharacters() throws Exception {
        MyTools.h2("writeCharacters");

        try (Writer fw = new FileWriter(pathName)) {
            fw.write(97); // 97=a
            for (int i = 0; i <= 66000; i++) {
                fw.write(i);
            }
        }
    }

    private static void writeAndReadeCharacterArrays() throws Exception {
        MyTools.h1("writeAndReadCharacterArrays");

        writeCharacterArray();
        readCharacterArray();
    }

    private static void readCharacterArray() throws Exception {
        MyTools.h2("readCharacterArray");

        char[] ca = new char[1000];
        int len;
        try (Reader fr = new FileReader(pathName)) {
            len = fr.read(ca);
        }
        System.out.println("len=" + len);
        for (int i = 0; i < len; i++) {
            System.out.printf("%c", ca[i]);
        }
        System.out.println();
    }

    private static void writeCharacterArray() throws Exception {
        MyTools.h2("writeCharacterArray");

        try (Writer fw = new FileWriter(pathName)) {
            char[] ca = {'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h',
                    'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o',
                    'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g',
                    'o', 'h', 'u', 'g', 'o', 'h', 'u', 'g', 'o'};
            fw.write(ca, 2, 32);
        }
    }

}
