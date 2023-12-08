package com.flexhamp.leetcode;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] nums2d = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 13;

        System.out.println(binarySearch2D(nums2d, target));
    }


    /*
    You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.

    You must write a solution in O(log(m * n)) time complexity.



    Example 1:


    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    Output: true
    Example 2:


    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
    Output: false


    Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104
    */
    public static boolean binarySearch2D(int[][] matrix, int target) {
        boolean found = false;

        for (int[] num : matrix) {
            if (target <= num[num.length - 1]) {
                if (target == num[num.length - 1]) {
                    found = true;
                    break;
                }

                int start = 0;
                int end = num.length;
                int middle;
                while (!found && start <= end) {
                    middle = (start + end) / 2;
                    if (num[middle] == target) {
                        found = true;
                        break;
                    } else if (target < num[middle]) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                }
            }
        }
        return found;
    }

}
