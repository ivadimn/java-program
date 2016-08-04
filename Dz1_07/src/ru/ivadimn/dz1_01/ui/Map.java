package ru.ivadimn.dz1_01.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by vadim on 04.08.16.
 */
public class Map extends JPanel {

    public static final int PLAYER_VS_COMP = 0;
    public static final int PLAYER_VS_PLAYER = 1;

    private int size;
    private int winLen;
    private int mode;
    private int[][] field;

    private int width;
    private int height;

    public Map() {
        super();
    }

    public void initMap(int sizeGame, int sizeWin, int mode) {
        this.mode = mode;
        this.size = sizeGame;
        this.winLen = sizeWin;

    }

    private void clearField() {
        field = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = 0;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle bounds = getBounds();
        int deltaX = bounds.width / size;
        int deltaY = bounds.height / size;
        g2.drawLine(x1, y1, x2, y2);

    }
}
