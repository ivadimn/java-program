package ru.ivadimn.lesson22.model;

/**
 * Created by vadim on 05.11.2016.
 */
public class Matrix  {

    public final int SIZE = 4;

    private  String[][] matrix = new String[SIZE][SIZE];
    private int[][] intMatrix = new int[SIZE][SIZE];

    public Matrix(String buffer) throws RuntimeException {
        createMatrix(buffer);
    }
    
    private void createMatrix(String buffer) throws RuntimeException {
        String[] ms = buffer.split("\n");
        if (ms.length != SIZE) {
            throw new RuntimeException("Количество строк матрицы = " + ms.length + " (а должно быть 4)");
        }

        for (int i = 0; i < SIZE; i++) {
            String[] mc = ms[i].split(" ");
            if (mc.length != SIZE) {
                throw new RuntimeException("В " + i + " строке матрицы " + mc.length + " элементов (а должно быть 4)");
            }
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = mc[j];
            }
        }
    }

    public int  getValue() throws RuntimeException {
        int summa = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    intMatrix[i][j] = Integer.valueOf(matrix[i][j]);
                    summa += intMatrix[i][j];
                }
                catch(NumberFormatException e) {
                    throw new RuntimeException("В " + i + " строке и " + j +
                            " столбце вместо числа - '" + matrix[i][j] + "'");
                }
            }
        }
        return summa / 2;
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
