package ru.ivadimn.lesson21.common_game_classes;

import java.awt.*;
import java.util.Random;

/**
 * Created by vadim on 02.11.2016.
 */
public abstract class Sprite implements GameObject {

    public static final float SPEED = 150f;
    public static final float SPEED_DELTA = 200f;
    public static final float HEIGHT = 20f;
    public static final float WIDTH = 20f;
    public static final float DELTA = 20f;

    public static final Random RANDOM = new Random();

    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;


    public float getLeft() {
        return x - halfWidth;
    }
    public void setLeft(float left) {
        x = left + halfWidth;
    }

    public float getRight() {
        return x + halfWidth;
    }
    public void setRight(float right) {
        x = right - halfWidth;
    }

    public float getTop() {
        return y - halfHeight;
    }
    public void setTop(float top) {
        y = top + halfHeight;
    }
    public float getBottom() {
        return y + halfHeight;
    }
    public void setBottom(float bottom) {
        y = bottom - halfHeight;
    }
    public float getWidth() {
        return 2f * halfWidth;
    }

    public float getHeight() {
        return 2f * halfHeight;
    }

    public abstract void update(GameCanvas gameCanvas, float deltaTime);
    public abstract void render(GameCanvas gameCanvas, Graphics g);

}
