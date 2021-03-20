
package ch.jmildner.k09network.u5chat;

import ch.jmildner.tools11.MyPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable {
    private static final long serialVersionUID = 1L;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    JTextArea output = new JTextArea(20, 50);
    JTextField input = new JTextField(50);

    String name;
    String url;
    int port;
    int pos;

    public ChatClient(String name, String url, int port, int pos) {
        super(name + "'s Chat");
        this.name = name;
        this.url = url;
        this.port = port;
        this.pos = pos;
    }

    @Override
    public void run() {

        MyPanel mp = new MyPanel(1, 50, false);

        mp.addTextArea(output, 10, 1, 1, 1);
        mp.add(input, 20, 1, 1);
        add(mp);
        pack();
        switch (pos) {
            case 1:
                setLocation(0, 0);
                break;
            case 2:
                setLocation(400, 0);
                break;
            case 3:
                setLocation(0, 300);
                break;
            default:
                setLocation(400, 300);
                break;
        }

        setVisible(true);
        output.setEditable(false);
        input.requestFocus();

        input.addKeyListener(new MyKeyListener(this));
        addWindowListener(new MyWindowListener());

        try {
            socket = new Socket(url, port);
            System.out.println(socket.getLocalPort());
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(name);

            int c = 0;
            while (++c < 1_000_000) {
                output.setText(in.readUTF() + "\n" + output.getText());
            }
        } catch (Exception e) {
            System.out.println("Server not (yet) available\n" + e);
        }

    }

    private void sendTextToChat(String text) {
        try {
            out.writeUTF(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MyKeyListener extends KeyAdapter {
        ChatClient client;

        MyKeyListener(ChatClient client) {
            this.client = client;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String text = input.getText();
                text = text.trim();

                if (text.length() > 0) {
                    sendTextToChat(text);
                    input.setText("");
                }
            }
        }
    }

    static class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
