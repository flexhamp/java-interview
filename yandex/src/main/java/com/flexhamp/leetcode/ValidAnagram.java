package com.flexhamp.leetcode;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String p = "nagaram";

        System.out.println(isAnagram(s, p));
    }

    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



    Example 1:

    Input: s = "anagram", t = "nagaram"
    Output: true
    Example 2:

    Input: s = "rat", t = "car"
    Output: false


    Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.


    Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
    */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        final char[] charsS = s.toCharArray();
        final char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        return Arrays.equals(charsS, charsT);
    }
}
