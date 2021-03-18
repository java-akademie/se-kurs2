
package ch.jmildner.k06fileio.u7serialisierung;

import ch.jmildner.tools11.MyTools;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FahrzeugeRead {

    static final String dirName = "temp";
    static final String fileName = "fahrzeuge.dat";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("FahrzeugeRead from " + pathName );

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathName)))
        {
            FahrzeugArray fahrzeuge = (FahrzeugArray) ois.readObject();
            System.out.println("data read");
            fahrzeuge.showAll();
        }
    }
}
