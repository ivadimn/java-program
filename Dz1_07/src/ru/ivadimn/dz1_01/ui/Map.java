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
    public static final Random RANDOM = new Random();

    public static final int NO_WIN = 0;
    public static final int COMP_IS_WIN = 1;
    public static final int PLAYER1_IS_WIN = 2;
    public static final int PLAYER2_IS_WIN = 3;

    private static final String NO_WIN_MSG = "Ничья!";
    private static final String PLAYER1_IS_WIN_MSG = "Выиграл игрок!";
    private static final String PLAYER2_IS_WIN_MSG = "Выиграл второй игрок!";
    private static final String COMP_IS_WIN_MSG = "Выиграл компьютер!";

    private int gameState;
    private int sizeX;
    private int sizeY;
    private int winLen;
    private int mode;
    private int[][] field;

    private boolean playerStep;
    private boolean finish;
    private boolean initialized;

    private int widthCell;
    private int heightCell;
    private final Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, 0, 0);
    private final Font font = new Font("Times new roman", Font.BOLD, 24);

    public Map() {
        super();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        if (!initialized || finish) return;
        int y = e.getY() / heightCell;
        int x = e.getX() / widthCell;
        if (!isValidCell(y, x) || !isEmptyCell(y, x)) return;
        step(y, x);
        repaint();
    }

    public void startNewGame(int sizeY, int sizeX, int sizeWin, int mode) {
        this.mode = mode;
        playerStep = true;
        initialized = true;
        this.finish = false;
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        this.winLen = sizeWin;
        field = new int[sizeY][sizeX];
        repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        render((Graphics2D) g);
  }

    private void render(Graphics2D g2) {
        if(!initialized) return;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        widthCell = panelWidth / sizeX;
        heightCell = panelHeight / sizeY;

        g2.setColor(Color.BLACK);
        Rectangle bounds = getBounds();

        int cl = heightCell;
        for (int i = 0; i < sizeY - 1; i++) {
            g2.drawLine(0, cl, panelWidth, cl);
            cl += heightCell;
        }
        cl = widthCell;
        for (int i = 0; i < sizeX - 1; i++) {
            g2.drawLine(cl, 0, cl, panelHeight);
            cl += heightCell;
        }

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
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
        if (finish) showGameState(g2);
    }


    private void step(int y, int x) {

        if (mode == PLAYER_VS_COMP) {
            field[y][x] = PLAYER_CELL;
            repaint();
            if (isWin(PLAYER_CELL)) {
                finish = true;
                gameState = PLAYER1_IS_WIN;
                return;
            }
            if (isFieldFull()) {
                finish = true;
                gameState = NO_WIN;
                return;
            }
            turnComp();
            repaint();
            if (isWin(COMPUTER_CELL)) {
                finish = true;
                gameState = COMP_IS_WIN;
                return;
            }
            if (isFieldFull()) {
                finish = true;
                gameState = NO_WIN;
                return;
            }

        } else {
            if (playerStep) {
                field[y][x] = PLAYER_CELL;
                repaint();
                if (isWin(PLAYER_CELL)) {
                    finish = true;
                    gameState = PLAYER1_IS_WIN;
                    return;
                }
                if (isFieldFull()) {
                    finish = true;
                    gameState = NO_WIN;
                    return;
                }
                playerStep = false;
            } else {
                field[y][x] = COMPUTER_CELL;
                repaint();
                if (isWin(COMPUTER_CELL)) {
                    finish = true;
                    gameState = PLAYER2_IS_WIN;
                    return;
                }
                if (isFieldFull()) {
                    finish = true;
                    gameState = NO_WIN;
                    return;
                }
                playerStep = true;

            }
        }

    }

    private void showGameState(Graphics2D g) {

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(font);
        switch (gameState){
            case NO_WIN:
                g.drawString(NO_WIN_MSG, 180, getHeight() / 2);
                break;
            case COMP_IS_WIN:
                g.drawString(COMP_IS_WIN_MSG, 50, getHeight() / 2);
                break;
            case PLAYER1_IS_WIN:
                g.drawString(PLAYER1_IS_WIN_MSG, 20, getHeight() / 2);
                break;
            case PLAYER2_IS_WIN:
                g.drawString(PLAYER2_IS_WIN_MSG, 20, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Неизвестный game_over_state = " + gameState);
        }
    }

    private boolean isWin(int val) {
        for(int i=0; i < sizeY; i++){
            for (int j = 0; j < sizeX; j++) {
                if(checkLine(i, j, 1, 0, winLen, val)) return true;
                if(checkLine(i, j, 1, 1, winLen, val)) return true;
                if(checkLine(i, j, 0, 1, winLen, val)) return true;
                if(checkLine(i, j, 1, -1, winLen, val)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(int y, int x, int vx, int vy, int len, int dot) {
        final int farX = x + (len - 1) * vx;
        final int farY = y + (len - 1) * vy;
        if (!isValidCell(farY, farX)) return false;
        for (int i = 0; i < len; i++) {
            if (field[y + i * vy][x + i * vx] != dot) return false;
        }
        return true;
    }




    private void turnComp() {

        if (detectCompWinCell()) return;
        if (detectPlayerWinCell()) return;
        int compY;
        int compX;
        do {
            compY = RANDOM.nextInt(sizeY);
            compX = RANDOM.nextInt(sizeX);
        } while (!isValidCell(compY, compX) || !isEmptyCell(compY, compX));
        field[compY][compX] = COMPUTER_CELL;

    }

    private boolean detectCompWinCell(){
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if(isEmptyCell(i, j)) {
                    field[i][j] = COMPUTER_CELL;
                    if (isWin(COMPUTER_CELL)) return true;
                    field[i][j] = EMPTY_CELL;
                }
            }
        }
        return false;
    }

    private boolean detectPlayerWinCell() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (isEmptyCell(i, j)) {
                    field[i][j] = PLAYER_CELL;
                    if (isWin(PLAYER_CELL)) {
                        field[i][j] = COMPUTER_CELL;
                        return true;
                    }
                    field[i][j] = EMPTY_CELL;
                }
            }
        }
        return false;
    }

    private boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_CELL;
    }

    private boolean isValidCell(int y, int x) {
        return y >= 0 && y < sizeY && x >= 0 && x < sizeX;
    }

    private boolean isFieldFull() {
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[i].length; j++)
                if (field[i][j] == EMPTY_CELL) return false;

        return true;
    }

}
