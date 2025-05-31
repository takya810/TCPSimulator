package app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TCPClientPanel extends JPanel {
    private JTextField ipField;
    private JTextField portField;
    private JButton connectButton;
    private JLabel statusLabel;
    private Socket socket;

    public TCPClientPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel ipLabel = new JLabel("IPアドレス:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(ipLabel, gbc);
        ipField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(ipField, gbc);

        JLabel portLabel = new JLabel("ポート番号:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(portLabel, gbc);
        portField = new JTextField(6);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(portField, gbc);

        connectButton = new JButton("接続");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(connectButton, gbc);

        statusLabel = new JLabel("未接続");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(statusLabel, gbc);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = ipField.getText();
                int port;
                try {
                    port = Integer.parseInt(portField.getText());
                    socket = new Socket(ip, port);
                    statusLabel.setText("接続成功: " + ip + ":" + port);
                } catch (Exception ex) {
                    statusLabel.setText("接続失敗: " + ex.getMessage());
                }
            }
        });
    }

    public Socket getSocket() {
        return socket;
    }
}
