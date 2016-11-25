package ru.ivadimn.chatclient.ui;

import ru.ivadimn.chatclient.ChatClient;
import ru.ivadimn.chatclient.common.Utils;
import ru.ivadimn.chatclient.network.SocketThread;
import ru.ivadimn.chatclient.network.SocketThreadListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by vadim on 11.11.16.
 */
public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler, SocketThreadListener {
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

        Thread.setDefaultUncaughtExceptionHandler(this);

        setAlwaysOnTop(true);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == btnSend || source == fieldInput){
            String msg = fieldInput.getText();
            socketThread.sendMsg(msg);
            fieldInput.setText(null);
            fieldInput.grabFocus();
        } else if(source == btnLogin || source == fieldPass){
            connect();
            fieldInput.grabFocus();
        } else if(source == btnDisconnect){
            socketThread.close();
        } else {
            throw new RuntimeException("Неизвестный source = " + source);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        StackTraceElement [] stackTraceElements = e.getStackTrace();
        String msg;
        if(stackTraceElements.length != 0){
            msg = stackTraceElements[0].toString() + ": " + e.getMessage();
        } else {
            msg = "StackTrace пустой";
        }
        JOptionPane.showMessageDialog(null, msg, "Exception: ", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private SocketThread socketThread;

    private void connect(){
        try {
            Socket socket = new Socket(fieldIPAddr.getText(), Integer.parseInt(fieldPort.getText()));
            socketThread = new SocketThread("SocketThread", this, socket);
        } catch (IOException e){
            log.append("Exception: " + e.getMessage() + "\n");
        }
    }

    //События сокета
    @Override
    public void onStartSocketThread(SocketThread thread, Socket socket) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append("SocketThread started.\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }

    @Override
    public void onStopSocketThread(SocketThread thread, Socket socket) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append("Connection lost.\n");
                log.setCaretPosition(log.getDocument().getLength());
                upperPanel.setVisible(true);
                bottomPanel.setVisible(false);
            }
        });
    }

    @Override
    public void onSocketIsReady(SocketThread thread, Socket socket) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append("Connection established.\n");
                log.setCaretPosition(log.getDocument().getLength());
                upperPanel.setVisible(false);
                bottomPanel.setVisible(true);
                String request = "/auth " + fieldLogin.getText() + " " + new String(fieldPass.getPassword());
                socketThread.sendMsg(request);
            }
        });
    }

    @Override
    public void onReceivedString(SocketThread thread, Socket socket, String value) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(value + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }
}
