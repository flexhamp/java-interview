package com.flexhamp.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {
    static List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
//        String s = "()())()";
//        String s = "(a)())()";
//        String s = "n";
//        String s = "(";
//        String s = "(";
//        String s = "x(";
        String s = "))(";
//        String s = "(()";
        removeInvalidParentheses(s);
    }

    public static List<String> removeInvalidParentheses(String s) {
        helper(s);

        if (strings.size() == 0)
            strings.add("");

        System.out.println(strings);
        return strings;
    }

    private static void helper(String s) {
        Stack<Integer> stack = new Stack<>();
        final char[] chars = s.toCharArray();

        int last = 0;
        boolean f = true;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                stack.push(i);
                continue;
            }

            if (chars[i] == ')') {
                if (!stack.isEmpty()) {
                    last = stack.pop();
                } else {
                    f = false;
                    helper(newStr(s, last));
                    helper(newStr(s, i));
                }
            }
        }

        if (f) {
            if (!stack.isEmpty()) {
                String str =  newStr(s, last);
                if (!str.isEmpty()) {
                    strings.add(str);
                }
            } else {
                strings.add(s);
            }
        }
    }

    private static String newStr(String s, int index) {
        return new StringBuilder(s).deleteCharAt(index).toString();
//        if (index == 0) {
//            return s.substring(index + 1);
//
//        } else {
//            return s.substring(0, index - 1).concat(s.substring(index));
//        }
    }

}
