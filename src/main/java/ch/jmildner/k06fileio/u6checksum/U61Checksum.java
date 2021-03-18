
package ch.jmildner.k06fileio.u6checksum;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;

public class U61Checksum {

    static final String dirName = "temp";
    static final String fileName = "checked_data.txt";
    static final String pathName = dirName + "/" + fileName;


    public static void main(String[] args) throws Exception {
        MyTools.h1("U61Checksum");
        FileTools.makeDirectory(dirName);
        long checksumOutput = checkedStreamWrite();
        long checksumInput = checkedStreamRead();
        checkChecksums(checksumOutput, checksumInput);
    }


    private static long checkedStreamWrite() throws Exception {
        MyTools.h2("checkedStreamWrite");

        try (CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(pathName), new Adler32());
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cos, StandardCharsets.UTF_8))) {

            String stringToWrite = String.format("i=%d, d=%f, c=%c, c=%c, %s %n", 111, 13.5, 64000, 63000,
                    "\nthis text contains special signs like \\r \\n  \r\n"
                            + "- the mutated vowels ä ö ü, the french signs è é à \r\n"
                            + "- the currency symbols € $ £  \r\n"
                            + "- and signs like © (Copyright) and ® (Registered Trade Mark).\r\n"
                            + "not all of the signs can always be mapped.");
            bw.write(stringToWrite);

            bw.flush();

            return cos.getChecksum().getValue();
        }
    }

    private static long checkedStreamRead() throws Exception {
        MyTools.h2("checkedStreamRead");

        long checksum;

        try (CheckedInputStream cis = new CheckedInputStream(new FileInputStream(pathName), new Adler32());
             BufferedReader br = new BufferedReader(new InputStreamReader(cis, StandardCharsets.UTF_8))) {

            String line = br.readLine();
            checksum = cis.getChecksum().getValue();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        }

        return checksum;
    }

    private static void checkChecksums(long checksumOutput, long checksumInput) {
        MyTools.h1("checkChecksums", 2);

        if (checksumOutput == checksumInput) {
            System.out.printf("checksums OK: %d %n",
                    checksumInput);
        } else {
            System.out.printf("checksums NOK %d != %d %n",
                    checksumInput, checksumOutput);
        }
    }

}
