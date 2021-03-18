
package ch.jmildner.k07threads.u4bank;

public class U41Konto {

    private int saldo;

    public void abheben(int betrag) {
        saldo -= betrag;
    }

    public void einzahlen(int betrag) { saldo += betrag;  }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int betrag ) {
        this.saldo = betrag;
    }
}
