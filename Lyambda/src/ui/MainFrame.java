package ui;

import javax.swing.*;

public class MainFrame extends JFrame {

    public static final int WIDTH = 1200;
    public static final int HEGHT = 800;

    private JButton btnLogin;

    public MainFrame() {
        super("Лямбда выражения");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEGHT);
        setVisible(true);
    }

    public void addComponent() {
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(event -> System.out.println(event.getActionCommand()));
        add(btnLogin);
    }


}
