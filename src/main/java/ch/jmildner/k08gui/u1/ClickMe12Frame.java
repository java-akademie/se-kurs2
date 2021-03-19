
package ch.jmildner.k08gui.u1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClickMe12Frame extends Frame {
    private final Button b = new Button("ClickMe");
    private final TextField tf1 = new TextField("", 30);
    private final TextField tf2 = new TextField("", 30);

    public ClickMe12Frame() {
        super("ClickMe12Frame");
        makeTheLayout();
        addTheListener();
        showTheFrame();
    }
    private void makeTheLayout() {
        setLayout(new FlowLayout());
        add(b);
        add(tf1);
        add(tf2);
    }
    private void addTheListener() {
        b.addActionListener  (
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
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
                }
        );
    }
    private void showTheFrame() {
        this.setLocation(300, 300);
        this.pack();
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
