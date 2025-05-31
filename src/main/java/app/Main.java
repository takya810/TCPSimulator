package app;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("TCPSimulator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            TCPClientPanel tcpPanel = new TCPClientPanel();
            frame.add(tcpPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
