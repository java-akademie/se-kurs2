
package ch.jmildner.k08gui.u7personenverwaltung;

import ch.jmildner.tools11.MyPanel;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonenVerwaltungPanel extends JPanel {

    private final boolean test;

    private final JButton erfassenBtn = new JButton("ERFASSEN");
    private final JButton anzeigenBtn = new JButton("ANZEIGEN");
    private final JButton massinsertBtn = new JButton("MASSINSERT");
    private final JButton sortierenBtn = new JButton("SORTIEREN");
    private final JButton loeschenBtn = new JButton("LOESCHEN");
    private final JButton speichernBtn = new JButton("SPEICHERN");
    private final JButton clearBtn = new JButton("CLEAR");
    private final JButton quitBtn = new JButton("QUIT");

    private final JTextField idTf = new JTextField("", 30);
    private final JTextField nameTf = new JTextField("", 30);
    private final JTextField addrTf = new JTextField("", 30);
    private final JTextArea ergTa = new JTextArea(20, 50);
    private final JScrollPane ergSp = new JScrollPane(ergTa);
    private final PersonenArray pa;

    public PersonenVerwaltungPanel(boolean test) {
        this.test = test;
        makeTheLayout();
        addTheListener();
        pa = new PersonenArray();
        pa.readAddresses();
    }

    private void makeTheLayout() {

        int lineNumber = test ? 1 : 0;

        MyPanel mp = new MyPanel(4, 18, test);

        mp.addCaptionCenter("PERSONENVERWALTUNG", ++lineNumber, 1, 4);

        mp.addLabel("ID", ++lineNumber, 1, 1);
        mp.add(idTf, lineNumber, 2, 3, 1);

        mp.addLabel("Name", ++lineNumber, 1, 1);
        mp.add(nameTf, lineNumber, 2, 3, 1);

        mp.addLabel("Addr", ++lineNumber, 1, 1);
        mp.add(addrTf, lineNumber, 2, 3, 1);

        lineNumber++;
        mp.add(erfassenBtn, lineNumber, 2, 1, 1);
        mp.add(anzeigenBtn, lineNumber, 3, 1, 1);
        mp.add(massinsertBtn, lineNumber, 4, 1, 1);

        lineNumber++;
        mp.add(sortierenBtn, lineNumber, 2, 1, 1);
        mp.add(loeschenBtn, lineNumber, 3, 1, 1);
        mp.add(speichernBtn, lineNumber, 4, 1, 1);

        lineNumber++;
        mp.add(clearBtn, lineNumber, 3, 1, 1);
        mp.add(quitBtn, lineNumber, 4, 1, 1);

        mp.addLabel("Ergebnis:", ++lineNumber, 1, 1);
        mp.add(ergSp, ++lineNumber, 1, 4, 30);

        this.add(mp);
    }

    private void addTheListener() {

        erfassenBtn.addActionListener(e -> erfassen());
        anzeigenBtn.addActionListener(e -> anzeigen());
        massinsertBtn.addActionListener(e -> massinsert());
        sortierenBtn.addActionListener(e -> sortieren());
        loeschenBtn.addActionListener(e -> loeschen());
        speichernBtn.addActionListener(e -> speichern());

        clearBtn.addActionListener(e -> clear());
        quitBtn.addActionListener(e -> quit());
    }

    private void erfassen() {

        try {
            int id = Integer.parseInt(idTf.getText());
            pa.inputAddress(id, nameTf.getText(),addrTf.getText());
            ergTa.setText(id + " inserted");
        } catch (Exception e) {
            ergTa.setText("id not numeric");
        }

    }

    private void anzeigen() {
        ergTa.setText(pa.getAddresses());
    }

    private void massinsert() {
        ergTa.setText("massinsert ");
        pa.insert10People();
    }

    private void sortieren() {
        ergTa.setText("addresses sorted");
        pa.sortAddresses();
    }

    private void loeschen() {
        try {
            int id = Integer.parseInt(idTf.getText());
            ergTa.setText(pa.deleteAddress(id));
        } catch (Exception e) {
            ergTa.setText("id not numeric");
        }
    }

    private void speichern() {
        ergTa.setText("speichern ");
        try {
            pa.saveAddresses();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        idTf.setText("");
        nameTf.setText("");
        addrTf.setText("");
        ergTa.setText("");
    }

    private void quit() {
        System.exit(0);
    }

}
