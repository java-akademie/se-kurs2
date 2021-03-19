
package ch.jmildner.k08gui.u5rechner1jpanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Rechner1Panel extends JPanel {

    private final JButton addButton = new JButton("+");
    private final JButton subButton = new JButton("-");
    private final JButton multButton = new JButton("*");
    private final JButton divButton = new JButton("/");

    private final JButton clearButton = new JButton("CLEAR");

    private final JButton endButton = new JButton("END");

    private final JTextField w1 = new JTextField("", 30);
    private final JTextField w2 = new JTextField("", 30);
    private final JTextField erg = new JTextField("", 30);

    public Rechner1Panel() {
        makeTheLayout();
        addTheListener();
    }

    private void makeTheLayout() {
        setLayout(new BorderLayout());
        add(north(), BorderLayout.NORTH);
        add(center(), BorderLayout.CENTER);
        add(south(), BorderLayout.SOUTH);
    }

    private JPanel north() {
        JPanel pn = new JPanel();
        pn.add(new JLabel("RECHNER1"));
        return pn;
    }

    private JPanel center() {
        JPanel pc = new JPanel();
        pc.setLayout(new GridLayout(4, 1));

        JPanel pw1 = new JPanel();
        pw1.add(new JLabel("Wert1:"));
        pw1.add(w1);
        pc.add(pw1);

        JPanel pw2 = new JPanel();
        pw2.add(new JLabel("Wert1:"));
        pw2.add(w2);
        pc.add(pw2);

        JPanel pbs = new JPanel();
        pbs.add(addButton);
        pbs.add(subButton);
        pbs.add(multButton);
        pbs.add(divButton);
        pc.add(pbs);

        JPanel pe = new JPanel();
        pe.add(new JLabel("Ergebnis:"));
        pe.add(erg);
        pc.add(pe);

        return pc;
    }

    private Component south() {
        JPanel p = new JPanel();
        p.add(clearButton);
        p.add(endButton);
        return p;
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
