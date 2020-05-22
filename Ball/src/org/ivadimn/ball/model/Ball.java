package org.ivadimn.ball.model;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Created by vadim on 10.07.16.
 */
public class Ball  {

    private static final int SIZE = 10;
    private Ellipse2D ell;
    private double x, dx;
    private double y, dy;


    public Ball() {
        x = 0;
        y = 0;
        ell = new Ellipse2D.Double(x, y, SIZE, SIZE);
        dx = 1;
        dy = 1;
     }



    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;

        if (x + SIZE >= bounds.getMaxX()) {
            dx = -dx;
            x = bounds.getMaxX() - SIZE;
        }
        if (x < bounds.getMinX()) {
            dx = -dx;
            x = bounds.getMinX();
        }
        if (y + dy >= bounds.getMaxY()) {
            dy = -dy;
            y = bounds.getMaxY() - SIZE;
        }
        if (y < bounds.getMinY()) {
            dy = -dy;
            y = bounds.getMinY();
        }

        ell.setFrame(x, y, SIZE, SIZE);
    }

    public Shape getShape() {
        return  ell;
    }

}
