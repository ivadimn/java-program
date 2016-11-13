package ru.ivadimn.chatclient.ui;

import ru.ivadimn.chatclient.common.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vadim on 11.11.16.
 */
public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    private final JPanel gridPanel = new JPanel(new GridLayout(2, 3));
    private final JPanel inputPanel = new JPanel(new BorderLayout());
    //поля ввода
    private final JTextField txtAddress = new JTextField();
    private final JTextField txtPort = new JTextField();
    private final JTextField txtLogin = new JTextField();
    private final JTextField txtPassword = new JTextField();
    private final JTextField txtInput = new JTextField();
    private final JTextArea log = new JTextArea();

    private final JButton btnLogin = new JButton(Utils.BTN_LOGIN_CAPTION);
    private final JButton btnSend = new JButton(Utils.BTN_SEND_CAPTION);

    public ClientGUI() {
        setTitle(Utils.CHAT_CLIENT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPosition();
        initGridPanel();
        add(new JScrollPane(log), BorderLayout.CENTER);
        initInputPanel();

        setVisible(true);
    }
    //задать позицию и размеры окна
    private void setPosition() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize((int) screenSize.getWidth() / 2, (int) screenSize.getHeight() / 2);
        setLocationRelativeTo(null);
    }

    private void initGridPanel() {
        txtAddress.setToolTipText(Utils.ADDRESS_TOOLTIP);
        gridPanel.add(txtAddress);
        gridPanel.add(txtPort);
        gridPanel.add(new JPanel());
        gridPanel.add(txtLogin);
        gridPanel.add(txtPassword);
        gridPanel.add(btnLogin);
        add(gridPanel, BorderLayout.NORTH);
    }
    private void initInputPanel() {
        inputPanel.add(txtInput, BorderLayout.CENTER);
        inputPanel.add(btnSend, BorderLayout.EAST);
        txtInput.addActionListener(this);
        btnSend.addActionListener(this);
        add(inputPanel, BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source =  e.getSource();
        if ((source == btnSend || source == txtInput)) {
            String message = txtInput.getText();
            if (message.length() > 0) {
                log.append(message + "\n");
                txtInput.setText("");
                Utils.writeLog(message);
            }
        }
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        String msg;
        if (stackTraceElements.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stackTraceElements.length; i++) {
                sb.append(stackTraceElements[i].toString() + "\n");
            }
            msg = sb.toString();
        }
        else {
            msg = "Сообщений нет";
        }
        JOptionPane.showMessageDialog(null, msg, "Exception : ", JOptionPane.ERROR_MESSAGE);
    }
}
