package org.ivadimn.dz1_02.task3;

/**
 * Created by vadim on 13.07.16.
 */
public class Multiply {

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Исходный массив: ");
        printArray(array);
        System.out.println("Инвертированный массив: ");
        printArray(multiply(array, 6, 2));

    }

    /**
     * Метод выполняет умножение каждого элемента массива а
     * на величину factor в случае если элемент массива меньше величины condition
     * @param a
     * @param condition
     * @param factor
     * @return int[]
     */
    private static int[] multiply(int[] a, int condition, int factor) {
        int[] array = new int[a.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = a[i] < 6 ? a[i] * 2 : a[i];
        }
        return array;
    }

    /**
     * Метод выводит элементы массива на консоль
     * @param a
     */
    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
