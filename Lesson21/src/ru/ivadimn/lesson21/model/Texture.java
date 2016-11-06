package ru.ivadimn.lesson21.model;

import ru.ivadimn.lesson21.ui.common.GameCanvas;
import ru.ivadimn.lesson21.ui.common.GameObject;

import java.awt.*;
import java.awt.geom.*;

/**
 * Created by vadim on 05.11.2016.
 */
public class Texture extends Sprite implements GameObject {

    private int numPoints = 10;
    private float vx = SPEED + RANDOM.nextFloat() * SPEED_DELTA;
    private float vy = SPEED + RANDOM.nextFloat() * SPEED_DELTA;
    private Color color1 = new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));
    private Color color2 = new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));
    private Color color3 = new Color(RANDOM.nextInt(255), RANDOM.nextInt(255), RANDOM.nextInt(255));
    int[] xpoints = new int[numPoints];
    int[] ypoints = new int[numPoints];

    public Texture() {
        halfHeight = HEIGHT + RANDOM.nextFloat() * DELTA;
        halfWidth = WIDTH  + RANDOM.nextFloat() * DELTA;
    }

    public Texture(float x, float y) {
        this.x = x;
        this.y = y;
        halfHeight = HEIGHT + RANDOM.nextFloat() * DELTA;
        halfWidth = WIDTH  + RANDOM.nextFloat() * DELTA;

    }

    private void initPoints() {
        updatePoints();
    }

    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
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
        updatePoints();
    }

    private void updatePoints() {
        xpoints[0] = (int) x;
        ypoints[0] = (int) getTop();

        xpoints[1] = (int) (getRight() - getWidth() / 3);
        ypoints[1] = (int) (getTop() + getHeight() / 3);

        xpoints[2] = (int) getRight();
        ypoints[2] = (int) (getTop() + getHeight() / 3);

        xpoints[3] = (int) (getRight() - getWidth() / 4);
        ypoints[3] = (int) (getTop() + halfHeight);

        xpoints[4] = (int) getRight();
        ypoints[4] = (int) getBottom();

        xpoints[5] = (int) x;
        ypoints[5] = (int) (getBottom() - getHeight() / 3);

        xpoints[6] = (int) getLeft();
        ypoints[6] = (int) getBottom();

        xpoints[7] = (int) (getLeft() + getWidth() / 4);
        ypoints[7] = (int) (getTop() + halfHeight);

        xpoints[8] = (int) getLeft();
        ypoints[8] = (int) (getTop() + getHeight() / 3);

        xpoints[9] = (int) (getLeft() + getWidth() / 3);
        ypoints[9] = (int) (getTop() + getHeight() / 3);

    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color1);
        g.fill3DRect((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight(), false);
        g.setColor(color2);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
        g.setColor(color3);
        g.fillPolygon(xpoints, ypoints, numPoints);

    }
}
