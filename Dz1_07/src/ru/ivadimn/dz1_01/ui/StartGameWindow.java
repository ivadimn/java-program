package ru.ivadimn.dz1_01.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vadim on 03.08.16.
 */
public class StartGameWindow extends JFrame {

    public static final int WIDTH = 350;
    public static final int HEGHT = 250;
    public static final int MIN_FIELD_SIZE = 3;
    public static final int MAX_FIELD_SIZE = 10;
    public static final int MIN_WIN_LEN = 3;


    public static final String LABEL_MODE = "Выберите режим игры:";
    public static final String LABEL_PLAYER_COMP = "Игрок против коипьютера";
    public static final String LABEL_PLAYER_PLAYER = "Игрок против игрока";
    public static final String LABEL_SIZE_FIELD = "Выберите размер поля";
    public static final String LABEL_SIZE_VIC = "Выберите длину выигрышной последовательности:";

    private GameWindow gameWindow;
    private JLabel lblChooseMode;
    private JRadioButton rbMode1;
    private JRadioButton rbMode2;



    public StartGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WIDTH, HEIGHT);
        setTitle("Создание новой игры");
        Rectangle bounds = gameWindow.getBounds();
        int posX = (int) bounds.getCenterX() - WIDTH / 2;
        int posY = (int) bounds.getCenterY() - HEGHT / 2;
        setLocation(posX, posY);
        setLayout(new GridLayout(10, 1));
        setResizable(false);

    }

};

