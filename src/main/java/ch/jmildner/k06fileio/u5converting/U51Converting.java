
package ch.jmildner.k06fileio.u5converting;
import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class U51Converting {

    static final int MAX = 10;
    static final String dirName = "temp";
    static final String fileName = "convert.txt";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("U51Converting");
        FileTools.makeDirectory(dirName);
        convertOutputStreamToBufferedWriter();
        convertInputStreamToBufferedReader();
    }

    private static void convertOutputStreamToBufferedWriter() throws Exception {
        MyTools.h1("convertOutputStreamToWriter and write()");

        try (OutputStream fos = new FileOutputStream(pathName);
             Writer fw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (int i = 1; i <= MAX; i++) {
                bw.write(String.format("i = %3d %n", i));
            }
        }
    }

    private static void convertInputStreamToBufferedReader() throws Exception {
        MyTools.h1("convertInputStreamToBufferedReader and readLine()");

        try (InputStream fis = new FileInputStream(pathName);
             Reader fr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(fr)) {

            for (int i = 1; i <= MAX; i++) {
                String s = br.readLine();
                System.out.println(s);
            }
        }
    }

}

