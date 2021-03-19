
package ch.jmildner.k08gui.u6rechner2mypanel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Rechner2Frame extends JFrame {

    public Rechner2Frame(boolean test) {
        super("Rechner2Frame");
        add(new Rechner2Panel(test));
        showTheFrame();
    }

    private void showTheFrame() {
        this.setLocation(200, 200);
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
