
package ch.jmildner.k08gui.u3;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextField;

public class ClickMe3Panel extends Panel {

    private final Button b = new Button("ClickMe");
    private final TextField tf1 = new TextField("", 30);
    private final TextField tf2 = new TextField("", 30);

    public ClickMe3Panel() {
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
