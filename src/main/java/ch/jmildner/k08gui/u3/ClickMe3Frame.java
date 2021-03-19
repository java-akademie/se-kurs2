
package ch.jmildner.k08gui.u3;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClickMe3Frame extends Frame {

    public ClickMe3Frame() {
        super("ClickMe3Frame");
        add(new ClickMe3Panel());
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
