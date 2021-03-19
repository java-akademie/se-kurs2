
package ch.jmildner.k08gui.u2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClickMe2 extends Frame {

    public static void main(String[] args) {
        new ClickMe2(Layout.flow);
        new ClickMe2(Layout.grid);
        new ClickMe2(Layout.border);
    }

    enum Layout {
        flow, grid, border;

        public int getOrdinal() {
            return this.ordinal();
        }
    }

    private final Layout layout;
    private final Button b = new Button("ClickMe");
    private final TextField tf1 = new TextField("", 40);
    private final TextField tf2 = new TextField("", 40);

    public ClickMe2(Layout layout) {
        super("ClickMe2-" + layout);
        this.layout = layout;
        makeTheLayout();
        addTheListener();
        showTheFrame();
    }

    private void makeTheLayout() {
        switch (layout) {
            case flow:
                this.setLayout(new FlowLayout());
                add(b);
                add(tf1);
                add(tf2);
                break;
            case grid:
                this.setLayout(new GridLayout(3,1));
                add(b);
                add(tf1);
                add(tf2);
                break;
            case border:
            default:
                this.setLayout(new BorderLayout());

                JPanel np=new JPanel();
                np.setBackground(Color.CYAN);
                np.setLayout(new FlowLayout());
                np.add(new JLabel("North"));
                add(BorderLayout.NORTH, np);

                JPanel cp=new JPanel();
                cp.setLayout(new GridLayout(3,1));
                cp.setBackground(Color.CYAN);
                add(b);
                add(tf1);
                add(tf2);
                cp.add(b);
                cp.add(tf1);
                cp.add(tf2);
                add(cp,BorderLayout.CENTER);

                JPanel sp=new JPanel();
                sp.setBackground(Color.CYAN);
                sp.setLayout(new FlowLayout());
                sp.add(new JLabel("South"));
                add(BorderLayout.SOUTH, sp);

                add(BorderLayout.EAST, new JLabel("East"));
                add(BorderLayout.WEST, new JLabel("West"));
        }
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

    private void showTheFrame() {
        this.setLocation(100 * (1 + layout.getOrdinal()),
                100 * (1 + layout.getOrdinal()));
        this.setBackground(Color.CYAN);
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
