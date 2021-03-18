
package ch.jmildner.k06fileio.u7serialisierung;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(value = { Fahrzeug.class, PKW.class, Velo.class, LKW.class })
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Fahrzeug implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int nextNr = 1;
    private int nr;
    private String marke;
    private double preis;

    public Fahrzeug() {
    }

    public Fahrzeug(String marke, double preis) {
        this.marke = marke;
        this.preis = preis;
        nr = nextNr++;
    }

    @Override
    public String toString() {
        return String.format("Nr=%d; Marke=%s; Preis=%.2f",
                nr, marke, preis);
    }

}
