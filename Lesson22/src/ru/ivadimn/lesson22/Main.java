package ru.ivadimn.lesson22;

import ru.ivadimn.lesson22.model.Matrix;

/**
 * Created by vadim on 05.11.2016.
 */
public class Main  {

    public static  String test1 = "1 3 1 2\n2 3 2 5\n3 2 1 5\n3 5 1 2";
    public static  String test2 = "1 3 1 2\n2 3 2 5\n3 2 1 5";
    public static  String test3 = "1 3 1 2\n2 3 5\n3 2 1 5\n3 5 1 2";
    public static  String test4 = "1 3 1 2\n2 3 2 5\n3 2 y 5\n3 5 1 2";

    public static void main(String[] args) {

        Matrix matrix = new Matrix(test1);
        System.out.println("Сумма элементов матрицы / 2 = " + matrix.getValue());

        System.out.println(matrix.toString());
    }
}
