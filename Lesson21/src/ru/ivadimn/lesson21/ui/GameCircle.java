package ru.ivadimn.lesson21.ui;

import javax.swing.*;

/**
 * Created by vadim on 01.11.16.
 */
public class GameCircle extends JFrame {

    public static void main(String[] args) {
        new GameCircle();
    }

    public GameCircle() {
        setTitle("Кружки");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200,  200);
        setSize(800, 600);
        setResizable(false);
        GameCanvas gameCanvas = new GameCanvas();
        gameCanvas.setLayout(Border);
        setVisible(true);
    }
}
