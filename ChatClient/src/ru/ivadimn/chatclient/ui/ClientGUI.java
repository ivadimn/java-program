package ru.ivadimn.chatclient.ui;

import ru.ivadimn.chatclient.common.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vadim on 11.11.16.
 */
public class ClientGUI extends JFrame implements ActionListener{
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
        //setBounds((int) screenSize.getWidth() / 4, (int)screenSize.getHeight() / 4,
        //            (int) screenSize.getWidth() / 2, (int) screenSize.getHeight() / 2);
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
        txtInput.addActionListener(this);
        btnSend.addActionListener(this);
        add(inputPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source =  e.getSource();
        if ((source == btnSend || source == txtInput)) {
            String message = txtInput.getText();
            if (message.length() > 0)
                log.append(message + "\n");
        }

    }
}
