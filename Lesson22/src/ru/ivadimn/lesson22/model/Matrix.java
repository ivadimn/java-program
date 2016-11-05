package ru.ivadimn.lesson22.model;

/**
 * Created by vadim on 05.11.2016.
 */
public class Matrix  {

    public final int SIZE = 4;
    private String buffer;
    private String[][] matrix;

    private int[][] intMatrix = new int[SIZE][SIZE];
    
    
    public Matrix(String buffer) {
        this.buffer = buffer;
        createMatrix();
    }
    
    private void createMatrix() {
        String[] m = buffer.split("\n");
        if (m.length != SIZE) {
            System.out.println("Вне размерности");
        }
        matrix = new String[SIZE][];
        for (int i = 0; i < SIZE; i++) {
            matrix[i] = m[i].split(" ");
            if (matrix[i].length != 4) {
                System.out.println("Вне разменрности");
            }
        }
    }

    public int  getValue() throws NumberFormatException{
        int summa = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    intMatrix[i][j] = Integer.valueOf(matrix[i][j]);
                    summa += intMatrix[i][j];
                }
                catch(NumberFormatException e) {
                    throw e;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
