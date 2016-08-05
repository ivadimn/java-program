package ru.ivadimn.dz1_01.model;

/**
 * Created by vadim on 05.08.16.
 */
public class Game {

    public static final int EMPTY_CELL = 0;


    public static boolean isFieldFull(int[][] f) {
        for (int i = 0; i < f.length; i++)
            for (int j = 0; j < f[i].length; j++)
                if (f[i][j] == EMPTY_CELL) return false;

        return true;
    }

    private static boolean isEmptyCell(int[][] f, int y, int x) {
        return f[y][x] == EMPTY_CELL;
    }



}
