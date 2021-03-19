
package ch.jmildner.k08gui.u4;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class ClickMe4Panel extends JPanel {

    private final JButton b = new JButton("ClickMe");
    private final JTextField tf1 = new JTextField("", 30);
    private final JTextField tf2 = new JTextField("", 30);

    public ClickMe4Panel() {
        makeTheLayout();
        addTheListener();
    }

    private void makeTheLayout() {
        setLayout(new FlowLayout());
        add(b);
        add(tf1);
        add(tf2);
    }

    private void addTheListener() {
        b.addActionListener(
                e -> {
                    if (e.getSource() == b) {
                        if (tf1.getText().equals("")) {
                            tf1.setText("thank’s for clicking");
                            tf2.setText("");
                        } else {
                            tf1.setText("");
                            tf2.setText("thank’s for clicking");
                        }
                    }
                }
        );
    }

}
