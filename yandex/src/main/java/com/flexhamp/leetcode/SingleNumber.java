package com.flexhamp.leetcode;

import java.util.HashMap;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 2, 5, 4, 1, 5};
//        int[] nums = new int[]{4,1,2,1,2};
        System.out.println("Res: " + singleNumber4(nums));
    }

    public static int singleNumber(int[] nums) {
        int min = Integer.MIN_VALUE + 1;
        for (int i = 0; i < nums.length; i++) {
            boolean repeat = false;
            final int s = nums[i];
            if (s != min) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (s == nums[j]) {
                        nums[i] = nums[j] = min;
                        repeat = true;
                    } else {
                        if (j == nums.length - 1 && !repeat) {
                            return s;
                        }
                    }
                }
            }

            if (i == nums.length - 1 && !repeat) {
                return s;
            }
        }

        return 0;
    }

    public static int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    public static int singleNumber3(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        return n;
    }

//    Интересной особенностью операции XOR является отсутствие потерь данных при ее работе. Что это значит? Смотрите, какую бы маску мы не взяли, дважды примененная маска дает исходное число.
    public static int singleNumber4(int[] nums) {
        int ans = 0;
        for(int e : nums){
            ans ^= e;
        }
        System.gc();
        return ans;
    }
}
