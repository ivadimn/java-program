package ru.ivadimn.lesson21.games;

import ru.ivadimn.lesson21.model.Background;
import ru.ivadimn.lesson21.model.Rect;
import ru.ivadimn.lesson21.common_game_classes.GameField;

/**
 * Created by vadim on 04.11.2016.
 */
public class GameRect extends GameField {

    public static void main(String[] args) {
        new GameRect();
    }

    private int countRect = 3;

    public GameRect() {
        super();
        setTitle("Прямоугольники");
        initGameObjects();
    }

    private void initGameObjects() {
        sprites.add(new Background());
        for (int i = 0; i < countRect; i++) {
            sprites.add(new Rect());
        }
    }

    public void addSprite(float x, float y) {
        sprites.add(new Rect(x, y));
    }
}
