package ru.ivadimn.lesson21.common_game_classes;

import java.awt.*;

/**
 * Created by vadim on 06.11.2016.
 */
public interface CanvasPaintListener {
    void onRepaint(GameCanvas gameCanvas, Graphics g, float deltaTime);
    void addSprite(float x, float y);
}
