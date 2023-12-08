package com.flexhamp.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = new int[]{30, 60, 90};
        System.out.println(Arrays.toString(dailyTemperatures2(temperatures)));
    }

    // Сложность по времени O(n^2)
    // Сложность по памяти O(n) | O(1)
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[0];

        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // Сложность по времени O(n)
    // Сложность по памяти O(n)
    public static int[] dailyTemperatures2(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[0];
        int[] res = new int[temperatures.length];
        Stack<Pair> pairs = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {

            //Удаляем все что холоднее из стека
            while (!pairs.isEmpty() && pairs.peek().value <= temperatures[i]) {
                pairs.pop();
            }


            if (!pairs.isEmpty()) {
                res[i] = pairs.peek().index - i;
            }

            pairs.push(new Pair(temperatures[i], i));
        }

        return res;
    }

    static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    //Best
    public static int[] dailyTemperatures3(int[] temperatures) {
        int hottest = 0, days;
        int[] answer = new int[temperatures.length];

        for (int currDay = temperatures.length - 1; currDay >= 0; currDay--) {
            int currentTemp = temperatures[currDay];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }

            days = 1;
            while (temperatures[currDay + days] <= currentTemp) {
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }

        return answer;
    }
}
