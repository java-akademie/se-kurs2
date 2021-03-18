
package ch.jmildner.k06fileio.u7serialisierung;

import ch.jmildner.k06fileio.tools.FileTools;
import ch.jmildner.tools11.MyTools;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class FahrzeugeXmlWrite {

    static final String dirName = "temp";
    static final String fileName = "fahrzeuge.xml";
    static final String pathName = dirName + "/" + fileName;

    private static final FahrzeugArray fahrzeuge = new FahrzeugArray();

    public static void main(String[] args) throws Exception {

        MyTools.h1("FahrzeugeXmlWrite into " + pathName);

        makeData();

        System.out.println("data to save");
        fahrzeuge.showAll();
        FileTools.makeDirectory(dirName);

        try (OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream(pathName), StandardCharsets.UTF_8)) {
            // Binding-Context
            JAXBContext ctx = JAXBContext.newInstance(FahrzeugArray.class);

            // Serializer
            Marshaller m = ctx.createMarshaller();

            // save data
            m.marshal(fahrzeuge, osw);
        }
    }

    private static void makeData() {
        fahrzeuge.add(new PKW("Mercedes",
                30000, 110, "Silver"));
        fahrzeuge.add(new LKW("MAN",
                150000, 320, "Rot",
                8000, 100, 3));
        fahrzeuge.add(new Velo("KTM",
                2000, 27, "Mountain-Bike"));
    }

}
