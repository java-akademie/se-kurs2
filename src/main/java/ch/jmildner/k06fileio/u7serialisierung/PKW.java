
package ch.jmildner.k06fileio.u7serialisierung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(value = {Fahrzeug.class, PKW.class, Velo.class, LKW.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class PKW extends Fahrzeug {

    private static final long serialVersionUID = 1L;

    private int leistung;
    private String farbe;

    public PKW() {
    }

    public PKW(String marke, double preis, int leistung, String farbe) {
        super(marke, preis);
        this.leistung = leistung;
        this.farbe = farbe;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n\tLeistung: %d kW; Farbe: %s", leistung, farbe);
    }
}
