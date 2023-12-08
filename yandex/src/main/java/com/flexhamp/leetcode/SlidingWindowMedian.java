package com.flexhamp.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/*
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.

For examples, if arr = [2,3,4], the median is 3.
For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
Explanation:
Window position                Median
---------------                -----
[1  3  -1] -3  5  3  6  7        1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7        3
 1  3  -1  -3 [5  3  6] 7        5
 1  3  -1  -3  5 [3  6  7]       6
Example 2:

Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]


Constraints:

1 <= k <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
 */
public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        int k = 1;
        System.out.println(Arrays.toString(findMedian(arr, k)));
    }

    static class Pair implements Comparable<Pair> {
        private int value, index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void renew(int v, int i) {
            value = v;
            index = i;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", value, index);
        }

        @Override
        public int compareTo(Pair o) {
            if (index == o.index) {
                return 0;
            } else if (value == o.value) {
                return Integer.compare(index, o.index);
            } else {
                return Integer.compare(value, o.value);
            }
        }
    }

    static double getMedian(TreeSet<Pair> minSet, TreeSet<Pair> maxSet, int window) {
        if (window % 2 == 0) {
            return ((long) minSet.last().getValue() + maxSet.first().getValue()) / 2.0;
        } else {
            return (minSet.size() > maxSet.size() ? minSet.last().getValue() : maxSet.first().getValue());
        }
    }

    static double[] findMedian(int[] arr, int k) {
        if (arr.length == 1)
            return new double[]{arr[0]};
        if (k == 1) {
            return Arrays.stream(arr).asDoubleStream().toArray();
        }

        TreeSet<Pair> minSet = new TreeSet<>();
        TreeSet<Pair> maxSet = new TreeSet<>();
        Pair[] windowPairs = new Pair[k];

        int j = 0;
        double[] res = new double[arr.length - k + 1];

        for (int i = 0; i < k; i++) {
            windowPairs[i] = new Pair(arr[i], i);
        }

        // Add k/2 items to maxSet
        for (int i = 0; i < k / 2; i++) {
            maxSet.add(windowPairs[i]);
        }

        for (int i = k / 2; i < k; i++) {
            if (arr[i] < maxSet.first().getValue()) {
                minSet.add(windowPairs[i]);
            } else {
                minSet.add(maxSet.pollFirst());
                maxSet.add(windowPairs[i]);
            }
        }

        res[j] = getMedian(minSet, maxSet, k);

        for (int i = k; i < arr.length; i++) {
            Pair temp = windowPairs[i % k];
            if (temp.getValue() <= minSet.last().getValue()) {
                minSet.remove(temp);
                temp.renew(arr[i], i);

                if (temp.getValue() < maxSet.first().getValue()) {
                    minSet.add(temp);
                } else {
                    minSet.add(maxSet.pollFirst());
                    maxSet.add(temp);
                }
            } else {
                maxSet.remove(temp);
                temp.renew(arr[i], i);
                if (temp.getValue() > minSet.last().getValue()) {
                    maxSet.add(temp);
                } else {
                    maxSet.add(minSet.pollLast());
                    minSet.add(temp);
                }
            }
            j++;
            res[j] = getMedian(minSet, maxSet, k);
        }
        return res;
    }
}
