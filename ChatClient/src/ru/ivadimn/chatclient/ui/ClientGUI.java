package ru.ivadimn.chatclient.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vadim on 11.11.16.
 */
public class ClientGUI extends JFrame {

    private final String CHAT_CLIENT = "Chat Client";
    private final String BTN_LOGIN_CAPTION = "Login";
    private final String BTN_SEND_CAPTION = "Send";


    private final JPanel gridPanel = new JPanel(new GridLayout(2, 3));
    private final JPanel inputPanel = new JPanel(new BorderLayout());
    //поля ввода
    private final JTextField txtAddress = new JTextField();
    private final JTextField txtPort = new JTextField();
    private final JTextField txtLogin = new JTextField();
    private final JTextField txtPassword = new JTextField();
    private final JTextField txtInput = new JTextField();
    private final JTextArea areaInfo = new JTextArea();

    private final JButton btnLogin = new JButton(BTN_LOGIN_CAPTION);
    private final JButton btnSend = new JButton(BTN_SEND_CAPTION);

    public ClientGUI() {
        setTitle(CHAT_CLIENT);
        setPosition();
        initGridPanel();
        add(new JScrollPane(areaInfo), BorderLayout.CENTER);
        initInputPanel();
        setVisible(true);
    }
    //задать позицию и размеры окна
    private void setPosition() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setBounds((int) screenSize.getWidth() / 4, (int)screenSize.getHeight() /4,
                    (int) screenSize.getWidth() / 2, (int) screenSize.getHeight() / 2);
    }

    private void initGridPanel() {
        txtAddress.setToolTipText("IP - адрес сервера");
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
        add(inputPanel, BorderLayout.SOUTH);
    }

}
