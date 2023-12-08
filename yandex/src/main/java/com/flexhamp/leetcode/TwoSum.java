package com.flexhamp.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum3(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (j != 0) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
            if (nums[i] + nums[i + 1] == target) {
                return new int[]{i, i + 1};
            }
            if (i + 1 == j) {
                i = 0;
                j--;
            } else {
                i++;
            }
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        int j = 1;
        for (int i = 0; i < nums.length && (i + j) < nums.length; i++) {
            if (nums[i] + nums[i + j] == target) {
                return new int[]{i, i + j};
            } else if (i == nums.length - 1 - j) {
                j++;
                i = -1;
            }
        }
        return new int[]{};
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
