package ru.ivadimn.dz1_01.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vadim on 03.08.16.
 */
public class GameWindow extends JFrame {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 550;

    public GameWindow() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize =  toolkit.getScreenSize();
        setLocation(screenSize.width / 2 - WINDOW_WIDTH / 2, screenSize.height / 2 - WINDOW_HEIGHT / 2);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Крестики-нолики");
        setVisible(true);
    }

    private void initButtons() {
        JButton buttonStart = new JButton("Новая игра");
        JButton buttonClose = new JButton("ВЫход");
    }

}
