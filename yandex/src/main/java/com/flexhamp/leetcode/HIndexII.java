package com.flexhamp.leetcode;

public class HIndexII {
    public static void main(String[] args) {
        int[] m = new int[]{1,2,100};
        System.out.println(hIndex(m));
    }

    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int left = 0, right = citations.length - 1, n = citations.length;
        int h = 0;
        int middle;

        while (left <= right) {
            middle = (left + right) / 2;
            if (citations[middle] == n - middle) {
                return citations[middle];
            } else if (citations[middle] > n - middle) {
                h = n - middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return h;
    }
}
