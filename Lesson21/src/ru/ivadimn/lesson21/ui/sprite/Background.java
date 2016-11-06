package ru.ivadimn.lesson21.ui.sprite;

import ru.ivadimn.lesson21.model.Sprite;
import ru.ivadimn.lesson21.ui.common.GameCanvas;
import ru.ivadimn.lesson21.ui.common.GameObject;

import java.awt.*;

/**
 * Created by vadim on 06.11.2016.
 */
public class Background  implements GameObject {

    private Color color;
    private float time;
    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
        time += deltaTime;
        int red = (int) (Math.abs(Math.sin(time / 2f)) * 150f);
        int green = (int) (Math.abs(Math.sin(time)) * 150f);
        color = new Color(red, green, 100);
    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        gameCanvas.setBackground(color);

    }
}
