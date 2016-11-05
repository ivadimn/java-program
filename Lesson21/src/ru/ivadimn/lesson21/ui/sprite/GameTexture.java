package ru.ivadimn.lesson21.ui.sprite;

import ru.ivadimn.lesson21.model.Texture;
import ru.ivadimn.lesson21.ui.common.GameField;

/**
 * Created by vadim on 05.11.2016.
 */
public class GameTexture extends GameField {

    public static void main(String[] args) {
        new GameTexture();
    }

    GameTexture() {
        super();
        setTitle("Дуги");
        initGameObjects();
    }
    private int countBall = 3;


    public void initGameObjects() {
        for (int i = 0; i < countBall; i++) {
            sprites.add(new Texture(gameCanvas));
        }
    }

    @Override
    public void addSprite(float x, float y) {
        sprites.add(new Texture(x, y, gameCanvas));
    }
}
