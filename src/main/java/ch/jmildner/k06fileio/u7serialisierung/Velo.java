
package ch.jmildner.k06fileio.u7serialisierung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(value = { Fahrzeug.class, PKW.class, Velo.class, LKW.class })
@XmlAccessorType(XmlAccessType.FIELD)
public class Velo extends Fahrzeug {

    private static final long serialVersionUID = 1L;

    private   double rahmengroesse;
    private   String typ;

    public Velo() {
    }

    public Velo(String marke, double preis, double rahmengroesse, String typ) {
        super(marke, preis);
        this.rahmengroesse = rahmengroesse;
        this.typ = typ;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("%n\tRahmengroesse: %.2f Zoll (%.2f cm); Typ: %s",
                rahmengroesse, rahmengroesse * 2.54, typ);
    }
}
