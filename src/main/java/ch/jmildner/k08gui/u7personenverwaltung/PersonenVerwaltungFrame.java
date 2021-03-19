
package ch.jmildner.k08gui.u7personenverwaltung;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class PersonenVerwaltungFrame extends JFrame {

    public PersonenVerwaltungFrame(boolean test) {
        super("PersonenVerwaltung");
        add(new PersonenVerwaltungPanel(test));
        showTheFrame();
    }

    private void showTheFrame() {
        this.setLocation(200, 100);
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
