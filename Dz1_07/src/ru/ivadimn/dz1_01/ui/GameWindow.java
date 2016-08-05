package ru.ivadimn.dz1_01.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vadim on 03.08.16.
 */
public class GameWindow extends JFrame {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 550;

    private final StartGameWindow paramWindows;
    private final Map map;

    public GameWindow() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize =  toolkit.getScreenSize();
        setLocation(screenSize.width / 2 - WINDOW_WIDTH / 2, screenSize.height / 2 - WINDOW_HEIGHT / 2);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Крестики-нолики");
        initButtons();

        map = new Map();
        add(map, BorderLayout.CENTER);
        setVisible(true);
        paramWindows = new StartGameWindow(this);
        paramWindows.setVisible(true);
        //startGame();
    }

    private void initButtons() {
        JButton btnStart = new JButton("Новая игра");
        JButton btnClose = new JButton("Выход");
        JPanel  pnlButton = new JPanel(new GridLayout(1, 2));

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paramWindows.setVisible(true);
            }
        });
        pnlButton.add(btnStart);
        pnlButton.add(btnClose);
        add(pnlButton, BorderLayout.SOUTH);

    }

    public void startGame(int sizeGame, int sizeWin, int mode) {
        map.startNewGame(sizeGame, sizeWin, mode);
        map.updateUI();
    }

}
