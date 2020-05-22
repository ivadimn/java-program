import java.util.Scanner;

/**
 * Created by vadim on 13.07.16.
 */
public class Ks {

    private static int maxR = 0;
    private static int minR = 0;

    private static int[][] obhod = {
            {0, 4 ,8},
            {2, 4, 6},
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8}
    };
    private static int[] field = new int[9];

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int row;
        int col;
        int val;
        do {
            System.out.println("Введите значение в виде СТРОКА СТОЛБЕЦ ЗНАЧЕНИЕ:");
            row = console.nextInt();
            col = console.nextInt();
            val = console.nextInt();
            setValue(row, col, val);
            printArray(field, 3);
            if(!isFill()) {
                System.out.println("-----------------------------");
                decide();
                printArray(field, 3);
            }

        } while(!isFill());
        System.out.println("FINISH!!!!");
     }

    private static void decide() {
        int minPos = 0;
        int maxPos = 0;
        if (field[4] == 0) {
            setValue(1, 1, -1);
            return;
        }

        minPos = findMinR();
        maxPos = findMaxR();
        if (maxR > minR) {
            setOnPos(maxPos, -1);
        }
        else {
            setOnPos(minPos, -1);
        }
    }

    private static int findMinR() {
        int raiting = 0;
        int pos = 0;
        minR = Short.MAX_VALUE;
        for (int i = 0; i < obhod.length; i++) {
            raiting = summa(obhod[i]);
            if (raiting < minR) {
                minR = raiting;
                pos = i;
            }
        }
        return pos;
    }

    private static int findMaxR() {
        int raiting = 0;
        int pos = 0;
        maxR = Short.MIN_VALUE;
        for (int i = 0; i < obhod.length; i++) {
            raiting = summa(obhod[i]);
            if (raiting > maxR) {
                maxR = raiting;
                pos = i;
            }
        }
        return pos;
    }

    private static int summa(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += field[a[i]];
        }
        return sum;
    }

    private static void printArray(int a[], int slength) {
        String sp = " ";
        //заголовок
        System.out.print("_ _|");
        for (int i = 0; i < slength; i++) {
            System.out.print("_" + i + "_|");
        }
        System.out.println();
        int row = 0;
        for (int i = 0; i < a.length; i += 3) {
            System.out.print("_" + row + "_|");
            ++row;
            for (int j = i; j < i + 3; j++) {
                switch(a[j])  {
                    case 1:
                        sp = "x";
                        break;
                    case -1:
                        sp = "0";
                        break;
                    default :
                        sp = " ";
                }
                System.out.print("_" + sp + "_|");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void setOnPos(int pos, int val) {
        int[] a = obhod[pos];
        if (field[a[0]] == 0)
            field[a[0]] = val;
        else if (field[a[2]] == 0)
            field[a[2]] = val;
        else
            field[a[1]] = val;
    }

    private static void setValue(int s, int c, int value) {
        field[s * 3 + c] = value;
    }

    private static boolean isFill() {

        for (int i = 0; i < field.length; i++) {
            if (field[i] == 0)
                return false;
        }
        return true;
    }
}
