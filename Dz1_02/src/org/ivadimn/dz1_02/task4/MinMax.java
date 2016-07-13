package org.ivadimn.dz1_02.task4;

/**
 * Created by vadim on 13.07.16.
 */
public class MinMax {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1, 0, -7, 269, -78, 23, 299};

        System.out.print("Массив: ");
        printArray(array);
        System.out.println("Минимальный  элемент массива: " + getMin(array));
        System.out.println("Максимальный элемент массива: " + getMax(array));
    }


    /**
     * Метод находит минимальный элемент массива
     * @param a
     * @return min
     */
    private static int getMin(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];
        }
        return min;
    }

    /**
     * Метод находит максимальный элемент массива
     * @param a
     * @return max
     */
    private static int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
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

