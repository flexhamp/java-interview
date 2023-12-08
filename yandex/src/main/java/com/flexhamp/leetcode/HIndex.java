package com.flexhamp.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/h-index/submissions/972049204/
public class HIndex {
    public static void main(String[] args) {
        int[] m = new int[]{3, 0, 6, 1, 5};
        System.out.println(hIndex3(m));
    }

    //https://www.youtube.com/watch?v=z2Y0S9SfzEs
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] tmp = new int[n + 1];

        for (int citation : citations) {
            if (citation >= n) {
                tmp[n]++;
            } else {
                tmp[citation]++;
            }
        }

        int pos = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < tmp[i]; j++) {
                citations[pos] = i;
                pos++;
            }
        }

        int h = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] < h) {
                return h - 1;
            }
            h++;
        }

        return n;
    }

    public static int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);

        int h = 1;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] < h) {
                return h - 1;
            }
            h++;
        }

        return citations.length;
    }

    public static int hIndex3(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);

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
