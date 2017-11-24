package com.example.solution;

import java.util.ArrayList;

/**
 * Created by Admin on 11/24/2017.
 */

public class Solution {

    public static int solution(String data) {

        if (data.isEmpty()) {
            return 1;
        }

        if (data.length() >= 1000000) {
            return 0;
        }

        ArrayList<Character> listSymbol = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {

            char singleChar = (data.charAt(i));

            if (!isSymbol(singleChar)) {
                return 0;
            }

            if (isFrontSymbol(singleChar)) {
                listSymbol.add(singleChar);
            } else {
                // Is back symbol
                if (listSymbol.isEmpty()) {
                    return 0;
                } else {
                    char lastChar = listSymbol.get(listSymbol.size() - 1);
                    if (isPairSymbol(lastChar , singleChar)) {
                        listSymbol.remove(listSymbol.size() - 1);
                    } else {
                        return 0;
                    }
                }
            }
        }

        if (listSymbol.isEmpty()) {
            return 1;
        } else {
            return 0;
        }

    }

    public static boolean isFrontSymbol(char data) {
        return data == '[' || data == '(' || data == '<' || data == '{';
    }

    public static boolean isBackSymbol(char data) {
        return data == ']' || data == ')' || data == '>' || data == '}';
    }

    public static boolean isSymbol(char data) {
        return data == ']' || data == ')' || data == '>' || data == '}' ||
                data == '[' || data == '(' || data == '<' || data == '{';
    }

    private static boolean isPairSymbol(char first, char second) {

        if (first == '[' && second == ']') {
            return true;
        }

        if (first == '{' && second == '}') {
            return true;
        }

        if (first == '<' && second == '>') {
            return true;
        }

        if (first == '(' && second == ')') {
            return true;
        }

        return false;
    }
}
