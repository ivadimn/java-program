package ru.ivadimn.lesson21.games;

import ru.ivadimn.lesson21.model.Background;
import ru.ivadimn.lesson21.model.Texture;
import ru.ivadimn.lesson21.common_game_classes.GameField;

/**
 * Created by vadim on 05.11.2016.
 */
public class GameTexture extends GameField {

    public static void main(String[] args) {
        new GameTexture();
    }

    GameTexture() {
        super();
        setTitle("Фигуры");
        initGameObjects();
    }
    private int countBall = 3;


    public void initGameObjects() {
        sprites.add(new Background());
        for (int i = 0; i < countBall; i++) {
            sprites.add(new Texture());
        }
    }

    @Override
    public void addSprite(float x, float y) {
        sprites.add(new Texture(x, y));
    }
}
