
package ch.jmildner.k06fileio.u7serialisierung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(value = {Fahrzeug.class, PKW.class, Velo.class, LKW.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class FahrzeugArray implements Serializable {

    private static final long serialVersionUID = 1;

    private final List<Fahrzeug> fahrzeuge = new ArrayList<>();

    public void add(Fahrzeug f) {
        fahrzeuge.add(f);
    }

    public void showAll() {
        System.out.println("Fahrzeuge:");

        for (Fahrzeug f : fahrzeuge) {
            System.out.println(f);
        }
    }
}

