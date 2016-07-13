package org.ivadimn.dz1_02.task2;

/**
 * Created by vadim on 13.07.16.
 */
public class Sequence {

    public static void main(String[] args) {

        printArray(createSequence(8, 3));

    }
    /**
     * Метод создаёт последовательность целых чисел длинной length,
     * где каждое следующее число больше предыдущего на величину delta
     * @param lenth
     * @param delta
     * @return
     */
    private static int[] createSequence(int lenth, int delta) {
        int[] array = new int[lenth];
        array[0] = 1;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + delta;

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
