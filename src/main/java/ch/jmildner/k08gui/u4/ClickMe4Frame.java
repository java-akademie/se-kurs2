
package ch.jmildner.k08gui.u4;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class ClickMe4Frame extends JFrame {

    public ClickMe4Frame() {
        super("ClickMe4Frame");
        add(new ClickMe4Panel());
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
