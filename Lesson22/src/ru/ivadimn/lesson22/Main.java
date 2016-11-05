package ru.ivadimn.lesson22;

import ru.ivadimn.lesson22.model.Matrix;

/**
 * Created by vadim on 05.11.2016.
 */
public class Main  {
    public static void main(String[] args) {
        String test = "1 3 1 2\n2 3 2 5\n3 2 1 5\n3 5 1 2";
        Matrix matrix = new Matrix(test);
        System.out.println(matrix.toString());
    }
}
