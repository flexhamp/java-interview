package com.flexhamp.algorithms;

public class ArraySearch {
    private static long count = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6, 9, 10, 11, 12, 15, 30, 31, 83};
        int[][] nums2d = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int search = 15;

//        System.out.printf("Index search: %s, count %s%n", lineSearch(nums, search), count);
//        count = 0;
//        System.out.printf("Index search: %s, count %s%n", binarySearch(nums, search), count);
//        count = 0;

//        binarySearch2D(nums2d, 3);
    }

    // Сложность O(n)
    public static Integer lineSearch(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            count++;
            if (nums[i] == num) {
                return i;
            }
        }
        return null;
    }

    // Сложность O(log2n)
    public static Integer binarySearch(int[] nums, int num) {
        int start = 0;
        int end = nums.length;
        int middle = 0;
        boolean found = false;
        Integer position = null;

        while (!found && start <= end) {
            count++;
            middle = (start + end) / 2;
            if (nums[middle] == num) {
                found = true;
                position = middle;
            } else if (num < nums[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return position;
    }



}
