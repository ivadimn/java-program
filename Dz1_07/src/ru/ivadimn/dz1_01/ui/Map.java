package ru.ivadimn.dz1_01.ui;

import sun.security.provider.SHA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Created by vadim on 04.08.16.
 * примерно в первом приближении, к сожалению на большее не хватило времени
 */
public class Map extends JPanel {

    public static final int EMPTY_CELL = 0;
    public static final int COMPUTER_CELL = 1;
    public static final int PLAYER_CELL = -1;

    public static final int PLAYER_VS_COMP = 0;
    public static final int PLAYER_VS_PLAYER = 1;
    public final static Random RANDOM = new Random();

    private int size;
    private int winLen;
    private int mode;
    private int[][] field;
    private boolean playerStep;
    private boolean finish;

    private int widthCell;
    private int heightCell;
    private final Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, 0, 0);

    public Map() {
        super();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (finish) return;
                int y = e.getY() / heightCell;
                int x = e.getX() / widthCell;
                if (!isEmptyCell(y, x)) return;
                step(y, x);
                updateUI();
            }
        });
    }

    public void startNewGame(int sizeGame, int sizeWin, int mode) {
        this.mode = mode;
        this.playerStep = true;
        this.finish = false;
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
                if (field[i][j] == COMPUTER_CELL) {
                    g2.setColor(Color.BLUE);
                    shape.setFrame(new Rectangle2D.Double(j * widthCell + 10, i * heightCell + 10,
                            heightCell - 20, widthCell - 20));
                    g2.fill(shape);
                }
                else if (field[i][j] == PLAYER_CELL) {
                    g2.setColor(Color.RED);
                    shape.setFrame(new Rectangle2D.Double(j * widthCell + 10, i * heightCell + 10,
                            heightCell - 20, widthCell - 20));
                    g2.fill(shape);
                }


            }
        }

    }

    private boolean isFieldFull() {
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[i].length; j++)
                if (field[i][j] == EMPTY_CELL) return false;

        return true;
    }

    private boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_CELL;
    }

    private boolean isValidCell(int y, int x) {
        return y >= 0 && y < size && x >= 0 && x < size;
    }

    private boolean isWin(int y, int x, int val) {
        return check(y, x, val) >= winLen;
    }

    private int check(int y, int x, int val) {
        int count = 0;
        int maxCount = 0;
        count = checkLine(y, x, 1, 1, val);
        if (count > maxCount) maxCount = count;
        count = checkLine(y, x, 1, 0, val);
        if (count > maxCount) maxCount = count;
        count = checkLine(y, x, 0, 1, val);
        if (count > maxCount) maxCount = count;
        count = checkLine(y, x, 1, -1, val);
        if (count > maxCount) maxCount = count;
        return maxCount;
    }


    private int checkLine(int y, int x, int dy, int dx, int val) {
        int maxCount = 0;
        int count = 0;
        int sy = y;
        int sx = x;
        while(isValidCell(sy - dy, sx - dx)) {
            sy -= dy;
            sx -= dx;
        }
        while(isValidCell(sy, sx)) {
            if (field[sy][sx] == val) {
                count++;
            }
            else if (count > 0 && count > maxCount) {
                maxCount = count;
                count = 0;
            }
            sy += dy;
            sx += dx;

        }
        return maxCount > count ? maxCount : count;
    }

    private void turnComp() {
        boolean hod = false;
        int compY;
        int compX;

        if (!hod) {
            do {
                compY = RANDOM.nextInt(size);
                compX = RANDOM.nextInt(size);

            } while (!isValidCell(compY, compX) || !isEmptyCell(compY, compX));
            field[compY][compX] = COMPUTER_CELL;
        }
    }

    private void step(int y, int x) {
        if (mode == PLAYER_VS_COMP) {
            field[y][x] = PLAYER_CELL;
            updateUI();
            if (!canContinue(y, x, PLAYER_CELL)) return;
            turnComp();
            updateUI();
            if (!canContinue(y, x, COMPUTER_CELL)) return;
        } else {
            if (!playerStep) {
                field[y][x] = PLAYER_CELL;
                updateUI();
                if (!canContinue(y, x, PLAYER_CELL)) return;
                playerStep = true;
            } else {
                field[y][x] = COMPUTER_CELL;
                updateUI();
                if (!canContinue(y, x, COMPUTER_CELL)) return;
                playerStep = false;

            }
        }

    }

    private boolean canContinue(int y, int x, int val) {
        if (isWin(y, x, val)) {
            JOptionPane.showMessageDialog(this, "Выигрыш", "Сообщенне", JOptionPane.WARNING_MESSAGE);
            finish = true;
            return false;
        }
        if(isFieldFull()) {
            JOptionPane.showMessageDialog(this, "Поле заполнено", "Сообщенне", JOptionPane.WARNING_MESSAGE);
            finish = true;
            return false;
        }
        return true;
    }

}
