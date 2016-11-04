package ru.ivadimn.lesson21.ui;

import ru.ivadimn.lesson21.model.Ball;
import ru.ivadimn.lesson21.model.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by vadim on 01.11.16.
 */
public class GameCircle extends GameField {

    public static void main(String[] args) {
        new GameCircle();
    }

    GameCircle() {
        super();
        setTitle("Кружки");
        initGameObjects();
    }
    private int countBall = 2;


    public void initGameObjects() {
        for (int i = 0; i < countBall; i++) {
            sprites.add(new Ball(gameCanvas));
        }
    }

}
