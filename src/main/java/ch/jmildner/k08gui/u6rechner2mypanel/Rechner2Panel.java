
package ch.jmildner.k08gui.u6rechner2mypanel;

import ch.jmildner.tools11.MyPanel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Rechner2Panel extends JPanel {

    private final boolean test;

    private final JButton addButton = new JButton("+");
    private final JButton subButton = new JButton("-");
    private final JButton multButton = new JButton("*");
    private final JButton divButton = new JButton("/");

    private final JButton clearButton = new JButton("CLEAR");

    private final JButton endButton = new JButton("END");

    private final JTextField w1 = new JTextField("", 30);
    private final JTextField w2 = new JTextField("", 30);
    private final JTextField erg = new JTextField("", 30);

    public Rechner2Panel(boolean test) {

        this.test=test;
        makeTheLayout();
        addTheListener();
    }

    private void makeTheLayout() {

        int lineNumber = test ? 1 : 0;

        MyPanel mp = new MyPanel(5, 12, test);

        lineNumber++;
        mp.addCaptionCenter("RECHNER 2", lineNumber, 1, 5);

        lineNumber++;
        mp.addLabel("Wert1:", lineNumber, 1, 1);
        mp.add(w1, lineNumber, 2, 4, 1);

        lineNumber++;
        mp.addLabel("Wert2:", lineNumber, 1, 1);
        mp.add(w2, lineNumber, 2, 4, 1);

        lineNumber++;
        mp.add(addButton, lineNumber, 2, 1, 1);
        mp.add(subButton, lineNumber, 3, 1, 1);
        mp.add(multButton, lineNumber, 4, 1, 1);
        mp.add(divButton, lineNumber, 5, 1, 1);

        lineNumber++;
        mp.addLabel("Ergebnis:", lineNumber, 1, 1);
        mp.add(erg, lineNumber, 2, 4, 1);

        lineNumber++;
        mp.add(clearButton, lineNumber, 4, 1, 1);
        mp.add(endButton, lineNumber, 5, 1, 1);

        this.add(mp);
    }

    private void addTheListener() {

        addButton.addActionListener(e -> add());
        subButton.addActionListener(e -> sub());
        multButton.addActionListener(e -> mult());
        divButton.addActionListener(e -> div());

        clearButton.addActionListener(e -> clear());
        endButton.addActionListener(e -> end());
    }

    private void add() {
        try {
            double a = Double.parseDouble(w1.getText());
            double b = Double.parseDouble(w2.getText());
            erg.setText("" + (a + b));
        } catch (Exception e) {
            erg.setText("input must be numeric");
        }
    }

    private void sub() {
        try {
            double a = Double.parseDouble(w1.getText());
            double b = Double.parseDouble(w2.getText());
            erg.setText("" + (a - b));
        } catch (Exception e) {
            erg.setText("input must be numeric");
        }
    }

    private void mult() {
        try {
            double a = Double.parseDouble(w1.getText());
            double b = Double.parseDouble(w2.getText());
            erg.setText("" + (a * b));
        } catch (Exception e) {
            erg.setText("input must be numeric");
        }
    }

    private void div() {
        try {
            double a = Double.parseDouble(w1.getText());
            double b = Double.parseDouble(w2.getText());
            erg.setText("" + (a / b));
        } catch (Exception e) {
            erg.setText("input must be numeric");
        }
    }

    private void clear() {
        w1.setText("");
        w2.setText("");
        erg.setText("");
    }

    private void end() {
        System.exit(0);
    }

}
