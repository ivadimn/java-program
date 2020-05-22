package ru.ivadimn.dz1_01;

import ru.ivadimn.dz1_01.ui.GameWindow;

import java.awt.*;

/**
 * Created by vadim on 03.08.16.
 */
public class MainWindow {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }
}
