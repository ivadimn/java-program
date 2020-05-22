package org.ivadimn.dz1_02.task1;

/**
 * Created by vadim on 13.07.16.
 */
public class Inversion {


    public static void main(String[] args) {
        int [] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Исходный массив: ");
        printArray(array);
        System.out.println("Инвертированный массив: ");
        printArray(inversion(array));
    }

    /**
     * Метод выполняет инвертирование элементов массива
     * @param a
     * @return int[]
     */
    private static int [] inversion(int[] a) {
        int inv[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            inv[i] = ~a[i] & 1;
        }
        return inv;
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
