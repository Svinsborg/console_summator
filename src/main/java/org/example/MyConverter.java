package org.example;

public class MyConverter {

    public static int convertArabian(char roman){
        if('I' == roman) return 1;
        else if('V' == roman) return 5;
        else if('X' == roman) return 10;
        else if('L' == roman) return 50;
        else if('C' == roman) return 100;
        else if('D' == roman) return 500;
        else if('M' == roman) return 1000;
        return 0;
    }

    public static String convertRoman(int arabian){
        if (1000 <= arabian) return "M";
        else if (900 <= arabian) return "CM";
        else if (500 <= arabian) return "D";
        else if (400 <= arabian) return "CD";
        else if (100 <= arabian) return "C";
        else if (90 <= arabian) return "XC";
        else if (50 <= arabian) return "L";
        else if (40 <= arabian) return "XL";
        else if (10 <= arabian) return "X";
        else if (9 <= arabian) return "IX";
        else if (5 <= arabian) return "V";
        else if (4 <= arabian) return "IV";
        else if (1 <= arabian) return "I";
        return "Err";
    }

    public static boolean checkRoman(String param){
        int num = convertArabian(param.charAt(0));
        if (num == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int toInt(String s){
        int end = s.length()-1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = convertArabian(arr[end]);
        for (int i = end-1; i >=0; i--) {
            arabian = convertArabian(arr[i]);

            if (arabian < convertArabian(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }

    public String ToRoman(int number) {
        String roman;
        String arabianNum;
        String result = "";
        do {
            roman = convertRoman(number);
            number =  number - toInt(roman);
            result = result + roman;
        } while (number != 0);
        return result;
    }
}
