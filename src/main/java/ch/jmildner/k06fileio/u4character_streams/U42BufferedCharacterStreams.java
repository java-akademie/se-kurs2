package ch.jmildner.k06fileio.u4character_streams;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class U42BufferedCharacterStreams {
    static final int MAX = 10;
    static final String dirName = "temp";
    static final String fileName = "buffered_stream.txt";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("U42BufferedCharacterStreams (Reader/Writer)");
        FileTools.makeDirectory(dirName);
        writeBufferedData();
        readBufferedData();
    }

    private static void writeBufferedData() throws Exception {
        MyTools.h2("writeBufferedData");

        try (Writer fw = new FileWriter(pathName);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (int i = 1; i <= MAX; i++) {
                bw.write("i=" + i + "\n");
            }
        }
    }

    private static void readBufferedData() throws Exception {
        MyTools.h2("readBufferedData");

        try (Reader fr = new FileReader(pathName);
             BufferedReader br = new BufferedReader(fr)) {

            for (int i = 1; i <= MAX; i++) {
                String s = br.readLine();
                System.out.println(s);
            }
        }
    }
}
