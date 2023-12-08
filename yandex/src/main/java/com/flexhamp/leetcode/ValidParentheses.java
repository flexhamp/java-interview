package com.flexhamp.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        int oldCapacity = 10;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity);
//        String s = "[";
//        System.out.println(isValid(s));
    }

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


    Example 1:

    Input: s = "()"
    Output: true
    Example 2:

    Input: s = "()[]{}"
    Output: true
    Example 3:

    Input: s = "(]"
    Output: false


    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        final char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '{' || chars[i] == '(' || chars[i] == '[') {
                stack.push(chars[i]);
            }

            if (chars[i] == '}' || chars[i] == ')' || chars[i] == ']') {
                if (stack.size() == 0 || stack.pop() != invert(chars[i])) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private static char invert(char c) {
        if (c == ')') {
            return '(';
        }
        if (c == ']') {
            return '[';
        }

        if (c == '}') {
            return '{';
        }

        return ' ';
    }
}
