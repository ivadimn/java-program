package ru.ivadimn.lesson25;

/**
 * Created by vadim on 15.11.16.
 */
public class Main {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];


    public static void main(String[] args) {
        System.out.println("Время обработки массива 1-м методом = " + calculate());
    }

    /**
     *
     * @return время обработки массива в милли секундах
     */

    public static long calculate() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis() - startTime;
    }

}
