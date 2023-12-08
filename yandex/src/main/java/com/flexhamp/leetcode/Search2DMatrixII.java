package com.flexhamp.leetcode;

import java.util.Arrays;

public class Search2DMatrixII {
    public static void main(String[] args) {
        final int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}
        };

        int target = 24;

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] ints : matrix) {
            int left = 0, right = matrix[0].length - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (ints[middle] == target) {
                    return true;
                }

                if (ints[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        return false;
    }


    // Best
    public static boolean searchMatrix2(int[][] mat, int t) {
        int r=0;
        int c=mat[0].length-1;

        while(c>=0 && r<mat.length){
            if(mat[r][c]==t)return true;

            if(mat[r][c]<t)r++;
            else c--;

        }
        return false;
    }
}
