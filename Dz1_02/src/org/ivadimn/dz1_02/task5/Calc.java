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
            System.out.println("Введите выражение для расчёта (например: 2 + 3 ) ");
            operand1 = console.nextDouble();
            oper = console.next();
            operand2 = console.nextDouble();
            System.out.println("Значение выражения: " + operand1 + " " + oper + " " + operand2 + " = "
                    + getResult(operand1, operand2, oper) );

            System.out.println("Продолжить? (y/n)");

        } while(!console.next().equalsIgnoreCase("n"));

    }

    /**
     * Метод вычисляет значение выражения (операции : " + "; " - "; " * "; " / ")
     * @param op1
     * @param op2
     * @param op
     * @return double;
     */
    private static double getResult(double op1, double op2, String op) {
        double result;
        switch(op) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*" :
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
            default:
                result = Double.NaN;
        }
        return result;
    }
}
