package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Input:");
        String input = scn.nextLine();
        String inputEdit = (input.replaceAll("\\s+", "")).toUpperCase();

        int a = 0, b = 0;

        String[] operators = {"+", "-", "/", "*"};
        String[] separator = {"\\+", "-", "/", "\\*"};
        int operatorsIndex = -1;
        for (int i = 0; i < operators.length; i++) {
            if (inputEdit.contains(operators[i])) {
                operatorsIndex = i;
                break;
            }
        }

        if (operatorsIndex == -1) {
            ErrOutput("строка не является математической операцией");
            return;
        }

        String[] data = inputEdit.split(separator[operatorsIndex]);
        if(data.length > 2){
            ErrOutput("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(0);
        }

        MyConverter converter = new MyConverter();

        boolean romanKey = false;

        if (MyConverter.checkRoman(data[0]) == MyConverter.checkRoman(data[1])) {

            romanKey = MyConverter.checkRoman(data[0]);

            if (romanKey) {
                a = converter.toInt(data[0]);
                b = converter.toInt(data[1]);
                if(!RangeCheck(a,b)) System.exit(0);
                System.out.println("Conxert to arabian: \n" + a + " " + b);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
                if(!RangeCheck(a,b)) System.exit(0);
            }

            int result;
            switch (operators[operatorsIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }

            System.out.println("Output: ");

            if (romanKey) {
                if (result < 1)  ErrOutput("в римской системе нет отрицательных чисел");
                System.out.println(converter.ToRoman(result));
            } else {
                System.out.println(result);
            }
        } else {
            ErrOutput("используются одновременно разные системы счисления");
        }
    }
    public static void ErrOutput(String message) {
        System.out.println("Err: " + message);
    }

    public static boolean RangeCheck(int a, int b) {
        if (0 > a || a > 10){
            ErrOutput("Числа должны быть в диапазоне от 0..10 или I..X");
            return false;
        }
        else if (0 > b || b > 10){
            ErrOutput("Числа должны быть в диапазоне от 0..10 или I..X");
            return false;
        }
        return true;
    }
}