package ch.jmildner.k08gui.u5rechner1jpanel;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Rechner1Frame extends JFrame {

    public Rechner1Frame() {
        super("Rechner1Frame");
        add(new Rechner1Panel());
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
