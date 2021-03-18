
package ch.jmildner.k06fileio.u7serialisierung;

import ch.jmildner.tools11.MyTools;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class FahrzeugeXmlRead {

    static final String dirName = "temp";
    static final String fileName = "fahrzeuge.xml";
    static final String pathName = dirName + "/" + fileName;

    public static void main(String[] args) throws Exception {
        MyTools.h1("FahrzeugeXmlRead from " + pathName );

        try (InputStreamReader isr = new InputStreamReader(
                new FileInputStream(pathName),
                StandardCharsets.UTF_8))
        {
            JAXBContext ctx = JAXBContext.newInstance(FahrzeugArray.class);
            Unmarshaller u = ctx.createUnmarshaller();
            FahrzeugArray fahrzeuge = (FahrzeugArray) u.unmarshal(isr);
            System.out.println("data read");
            fahrzeuge.showAll();
        }
    }

}
