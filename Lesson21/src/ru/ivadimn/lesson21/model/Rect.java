package ru.ivadimn.lesson21.model;

import ru.ivadimn.lesson21.ui.common.GameCanvas;

import java.awt.*;

/**
 * Created by vadim on 03.11.2016.
 */
public class Rect extends Sprite {

    private float vx = SPEED + RANDOM.nextFloat() * SPEED_DELTA;
    private float vy = SPEED + RANDOM.nextFloat() * SPEED_DELTA ;
    private Color color = new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));

    public Rect(GameCanvas gameCanvas) {
        super(gameCanvas);
        halfHeight = HEIGHT + RANDOM.nextFloat() * DELTA;
        halfWidth = WIDTH  + RANDOM.nextFloat() * DELTA;
    }

    public Rect(float x, float y, GameCanvas gameCanvas) {
        super(x, y, gameCanvas);
        halfHeight = HEIGHT + RANDOM.nextFloat() * DELTA;
        halfWidth = WIDTH  + RANDOM.nextFloat() * DELTA;
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
        g.fillRect((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
