package ru.ivadimn.lesson25;

/**
 * Created by vadim on 15.11.16.
 */
public class Main {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];


    public static void main(String[] args) {
        System.out.println("Время обработки массива 1-м методом = " + calculate1());
        //печатаем последний элемент для проверки правильности 2-го метода
        System.out.println(arr[size - 1]);
        System.out.println("Время обработки массива 2-м методом = " + calculate2());
        //печатаем последний элемент для проверки правильности 2-го метода
        System.out.println(arr[size - 1]);

    }
    /**
     * Обработка массива целиком в главном потоке
     * @return время обработки массива в милли секундах
     */

    public static long calculate1() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis() - startTime;
    }
    /**
     * обработка по половине массива в разных потоках
     * @return время обработки массива в милли секундах
     */
    public static long calculate2() {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(new CalcRunnable(a1, 0));
        Thread t2 = new Thread(new CalcRunnable(a2, h));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        return System.currentTimeMillis() - startTime;
    }
    //Класс для создания потока и обработки половины массива
    public static class CalcRunnable implements Runnable {

        private float[] ar;
        private int deltaIndex;     //для правильного индекса в формуле
        public CalcRunnable(float[] ar, int deltaIndex) {
            this.ar = ar;
            this.deltaIndex = deltaIndex;
        }
        @Override
        public void run() {
            for (int i = 0; i < ar.length; i++) {
                ar[i] = (float)(ar[i] * Math.sin(0.2f + (i + deltaIndex) / 5) * Math.cos(0.2f + (i + deltaIndex) / 5) *
                        Math.cos(0.4f + (i + deltaIndex) / 2));
            }
        }
    }

}
