package ru.ivadimn.lesson21.common_game_classes;

import java.awt.*;

/**
 * Created by vadim on 06.11.2016.
 */
public interface GameObject  {

    void update(GameCanvas gameCanvas, float deltaTime);
    void render(GameCanvas gameCanvas, Graphics g);
}
