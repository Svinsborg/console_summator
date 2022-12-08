package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Input:");
        String input = scn.nextLine();
        String inputEdit = input.replaceAll("\\s+","");

        int a,b;

        String[] operators = {"+", "-", "/", "*"};
        String[] separator = {"\\+", "-", "/", "\\*"};
        int operatorsIndex =  -1 ;
        for (int i = 0; i < operators.length; i++) {
            if(inputEdit.contains(operators[i])){
                operatorsIndex = i;
                break;
            }
        }
        if(operatorsIndex == -1){
            System.out.println("Некорректное выражение");
            return;
        }

        String[] data = inputEdit.split(separator[operatorsIndex]);

        MyConverter converter = new MyConverter();

        if(converter.checkRoman(data[0]) == MyConverter.checkRoman(data[1])){

            boolean romanKey =  converter.checkRoman(data[0]);
            if(romanKey = true){
                a = converter.toInt(data[0]);
                b = converter.toInt(data[1]);
                System.out.println("Output: \n" + a + " " + b);
            }
        }




/*        a = Integer.parseInt(data[0]);
        b = Integer.parseInt(data[1]);

        int result;
        switch (operators[operatorsIndex]){
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            default:
                result = a/b;
                break;
        }

        System.out.println("Output: \n" + result);*/
    }
}