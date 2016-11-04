package ru.ivadimn.lesson21.model;

import ru.ivadimn.lesson21.ui.GameCanvas;

import java.awt.*;

/**
 * Created by vadim on 02.11.2016.
 */
public class Ball extends Sprite {


    private float vx = SPEED + RANDOM.nextFloat() * 200f;
    private float vy = SPEED + RANDOM.nextFloat() * 200f ;
    private Color color = new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));

    public Ball(GameCanvas gameCanvas) {
        super(gameCanvas);
        halfHeight = HEIGHT + RANDOM.nextFloat() * 50f;
        halfWidth = halfHeight * 1f;
    }

    public Ball(float x, float y, GameCanvas gameCanvas) {
        super(x, y, gameCanvas);
        halfHeight = HEIGHT + RANDOM.nextFloat() * 50f;
        halfWidth = halfHeight * 1f;
    }

    @Override
    public void update(float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;
        if (getLeft() < gameCanvas.getLeft()) {
            setLeft(gameCanvas.getLeft());
            vx = -vx;
        }
        if (getRight() > gameCanvas.getRight()) {
            setRight(gameCanvas.getRight());
            vx = -vx;
        }

        if (getTop() < gameCanvas.getTop()) {
            setTop(gameCanvas.getTop());
            vy = -vy;
        }
        if (getBottom() > gameCanvas.getBottom()) {
            setBottom(gameCanvas.getBottom());
            vy = -vy;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
