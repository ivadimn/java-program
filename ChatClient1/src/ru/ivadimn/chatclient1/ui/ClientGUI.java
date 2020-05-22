package ru.ivadimn.chatclient1.ui;

import ru.ivadimn.chatclient1.ChatClient;
import ru.ivadimn.chatclient1.network.SocketThread;
import ru.ivadimn.chatclient1.network.SocketThreadListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by vadim on 26.11.2016.
 */
public class ClientGUI extends JFrame implements ActionListener,  Information {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }

    private static final String BTN_SEND_TEXT = "Send";
    private final JTextArea log = new JTextArea();
    private final JTextField fieldInput = new JTextField();
    private final JTextField fieldIPAddr = new JTextField("127.0.0.1");
    private final JTextField fieldPort = new JTextField("8189");
    private final JTextField fieldLogin = new JTextField("root");
    private final JPasswordField fieldPass = new JPasswordField("root_pass");
    private final JButton btnSend = new JButton(BTN_SEND_TEXT);
    private final JButton btnLogin = new JButton("Login");
    private final JButton btnDisconnect = new JButton("Disconnect");
    private final JPanel bottomPanel = new JPanel(new BorderLayout());;
    private final JPanel upperPanel = new JPanel(new GridLayout(2, 3));
    private ChatClient client;

    private ClientGUI(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Chat client");
        setLocationRelativeTo(null);
        setResizable(false);

        log.setEditable(false);
        log.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane, BorderLayout.CENTER);

        fieldInput.addActionListener(this);
        btnSend.addActionListener(this);
        btnDisconnect.addActionListener(this);
        bottomPanel.add(fieldInput, BorderLayout.CENTER);
        bottomPanel.add(btnSend, BorderLayout.EAST);
        bottomPanel.add(btnDisconnect, BorderLayout.WEST);
        bottomPanel.setVisible(false);
        add(bottomPanel, BorderLayout.SOUTH);

        btnLogin.addActionListener(this);
        fieldPass.addActionListener(this);
        upperPanel.add(fieldIPAddr);
        upperPanel.add(fieldPort);
        upperPanel.add(new JPanel());
        upperPanel.add(fieldLogin);
        upperPanel.add(fieldPass);
        upperPanel.add(btnLogin);
        add(upperPanel, BorderLayout.NORTH);
        setAlwaysOnTop(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == btnSend || source == fieldInput){
            client.sendMsg(fieldInput.getText());
            fieldInput.setText(null);
            fieldInput.grabFocus();
        } else if(source == btnLogin || source == fieldPass){
            client = new ChatClient(fieldIPAddr.getText(), Integer.parseInt(fieldPort.getText()), this);
            client.connect();
            fieldInput.grabFocus();
        } else if(source == btnDisconnect){
            client.disconnect();
        } else {
            throw new RuntimeException("Неизвестный source = " + source);
        }
    }

    @Override
    public void printMessage(String msg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(msg + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }

    @Override
    public void updateUI(boolean param) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (param) {
                    upperPanel.setVisible(false);
                    bottomPanel.setVisible(true);
                }
                else {
                    upperPanel.setVisible(true);
                    bottomPanel.setVisible(false);
                }
            }
        });
    }

    @Override
    public String getLogin() {
        return fieldLogin.getText();
    }

    @Override
    public String getPassword() {
        return new String(fieldPass.getPassword());
    }
}
