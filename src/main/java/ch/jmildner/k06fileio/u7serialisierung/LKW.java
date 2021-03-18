
package ch.jmildner.k06fileio.u7serialisierung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso(value = { Fahrzeug.class, PKW.class, Velo.class, LKW.class })
@XmlAccessorType(XmlAccessType.FIELD)
public class LKW extends PKW {

    private static final long serialVersionUID = 1L;

    private int maximalGewicht;
    private double ladeflaeche;
    private int achsen;

    public LKW() {
    }

    public LKW(String marke,
               double preis,
               int leistung,
               String farbe,
               int maxGewicht,
               double ladeflaeche,
               int achsen) {

        super(marke, preis, leistung, farbe);
        this.maximalGewicht = maxGewicht;
        this.ladeflaeche = ladeflaeche;
        this.achsen = achsen;
    }



    @Override
    public String toString() {
        return super.toString()
                + String.format("%n\t%d Achsen; max. Gewicht: %d kg; Ladeflaeche: %.2f m2",
                achsen, maximalGewicht, ladeflaeche);
    }
}
