package ru.ivadimn.dz1_01.ui;

import sun.security.provider.SHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

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

    private int widthCell;
    private int heightCell;
    private final Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, 0, 0);

    public Map() {
        super();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int i = e.getY() / heightCell;
                int j = e.getX() / widthCell;
                field[i][j] = 1;
                updateUI();
            }
        });
    }

    public void startNewGame(int sizeGame, int sizeWin, int mode) {
        this.mode = mode;
        this.size = sizeGame;
        this.winLen = sizeWin;
        Rectangle bounds = getBounds();
        widthCell = bounds.width / size;
        heightCell = bounds.height / size;
        field = new int[size][size];
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Rectangle2D.Double rd = new Rectangle2D.Double();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        Rectangle bounds = getBounds();

        int cl = heightCell;
        for (int i = 0; i < size - 1; i++) {
            g2.drawLine(0, cl, bounds.width, cl);
            cl += heightCell;
        }
        cl = widthCell;
        for (int i = 0; i < size - 1; i++) {
            g2.drawLine(cl, 0, cl, bounds.height);
            cl += heightCell;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 1) {

                    shape.setFrame(new Rectangle2D.Double(j * widthCell + 10, i * heightCell + 10,
                                                          heightCell - 20, widthCell - 20));
                    g2.fill(shape);
                }

            }
        }

    }

}
