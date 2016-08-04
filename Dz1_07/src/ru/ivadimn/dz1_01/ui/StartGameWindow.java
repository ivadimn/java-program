package ru.ivadimn.dz1_01.ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by vadim on 03.08.16.
 */
public class StartGameWindow extends JFrame {

    public static final int WINDOW_WIDTH = 350;
    public static final int WINDOW_HEIGHT = 350;
    public static final int MIN_FIELD_SIZE = 3;
    public static final int MAX_FIELD_SIZE = 10;


    private int sizeField = 3;
    private int sizeWin = 3;

    public static final String LABEL_MODE = "Выберите режим игры:";
    public static final String LABEL_PLAYER_COMP = "Игрок против коипьютера";
    public static final String LABEL_PLAYER_PLAYER = "Игрок против игрока";
    public static final String LABEL_SIZE_FIELD = "Выберите размер поля";
    public static final String LABEL_SIZE_VIC = "Выберите длину выигрышной последовательности:";

    private GameWindow gameWindow;
    private JRadioButton rbMode1;
    private JRadioButton rbMode2;

    private JLabel lblSizeField;
    private JSlider jsSizeFiled;
    private JLabel lblSizeWin;
    private JSlider jsSizeWin;

    public StartGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Создание новой игры");
        Rectangle bounds = gameWindow.getBounds();
        int posX = (int) bounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) bounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setLayout(new GridLayout(10, 1));
        setResizable(false);

        initGameModeComponents();
        initGameSizeComponents();

    }

    private void initGameModeComponents() {
        add(new JLabel("Выберите режим игры:"));
        rbMode1 = new JRadioButton("Игрок против коипьютера");
        rbMode1.setSelected(true);
        rbMode2 = new JRadioButton("Игрок против игрока");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMode1);
        bg.add(rbMode2);
        add(rbMode1);
        add(rbMode2);
    }

    private void initGameSizeComponents() {
        add(new JLabel("Выберите размер поля"));
        lblSizeField = new JLabel("Field size: " + sizeField);
        add(lblSizeField);
        jsSizeFiled = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, 3);
        jsSizeFiled.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sizeField = jsSizeFiled.getValue();
                lblSizeField.setText("Field size: " + sizeField);
                if (sizeField < sizeWin) {
                    sizeWin = sizeField;
                    jsSizeWin.setValue(sizeWin);
                }
            }
        });
        add(jsSizeFiled);
        add(new JLabel("Выберите длину выигрышной последовательности:"));
        lblSizeWin = new JLabel("Win size: " + sizeWin);
        add(lblSizeWin);
        jsSizeWin = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, 3);
        jsSizeWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sizeWin = jsSizeWin.getValue();
                if (sizeField < sizeWin) {
                    sizeWin = sizeField;
                 }
                jsSizeWin.setValue(sizeWin);
                lblSizeWin.setText("Win size: " + sizeWin);
            }
        });
        add(jsSizeWin);
    }

};

