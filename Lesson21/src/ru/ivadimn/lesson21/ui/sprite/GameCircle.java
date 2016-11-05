package ru.ivadimn.lesson21.ui.sprite;

import ru.ivadimn.lesson21.model.Ball;
import ru.ivadimn.lesson21.ui.common.GameField;

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

    public void addSprite(float x, float y) {
        sprites.add(new Ball(x, y, gameCanvas));
    }

}
