package org.ivadimn.dz1_02.task5;

import java.util.Scanner;

/**
 * Created by vadim on 13.07.16.
 */
public class Calc {

    public static void main(String[] args) {
        double operand1;
        double operand2;
        String oper;
        Scanner console = new Scanner(System.in);
        System.out.println("Простой калькулятор (данные вводятся через пробел)");
        do {
            System.out.println("Введите выражение для расчёта (например: 2 + 3) ");
            operand1 = console.nextDouble();
            oper = console.next();
            operand2 = console.nextDouble();
            System.out.println("Вы ввели: " + operand1 + " " + oper + " " + operand2);

            System.out.println("Продолжить? (y/n)");

        } while(!console.next().equals("n"));

    }

    private static double getResult(double op1, double op2, String op) {

        
    }
}
