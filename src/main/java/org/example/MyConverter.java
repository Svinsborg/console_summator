package org.example;

import java.util.HashMap;
import java.util.Map;

public class MyConverter {
    static Map<Character, Integer> romanMap = new HashMap<>();

    Map<Integer, String> arabianMap = new HashMap<>();

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

}
