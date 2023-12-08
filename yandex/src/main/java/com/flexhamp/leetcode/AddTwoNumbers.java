package com.flexhamp.leetcode;

import java.math.BigInteger;


/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));

//        ListNode node1 = new ListNode(9);
//        ListNode node2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

        ListNode node1 = new ListNode(1,
                new ListNode(0,
                        new ListNode(0,
                                new ListNode(0,
                                        new ListNode(0,
                                                new ListNode(0,
                                                        new ListNode(0,
                                                                new ListNode(0,
                                                                        new ListNode(0,
                                                                                new ListNode(0,
                                                                                        new ListNode(0,
                                                                                                new ListNode(0,
                                                                                                        new ListNode(0,
                                                                                                                new ListNode(0,
                                                                                                                        new ListNode(0,
                                                                                                                                new ListNode(0,
                                                                                                                                        new ListNode(0,
                                                                                                                                                new ListNode(0,
                                                                                                                                                        new ListNode(0,
                                                                                                                                                                new ListNode(0,
                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                                                                                        new ListNode(1)))))))))))))))))))))))))))))));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        addTwoNumbers(node1, node2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode res = null;
        ListNode head = null;

        BigInteger l1Int = getInt(l1);
        BigInteger l2Int = getInt(l2);
        int[] arr = (l1Int.add(l2Int)).toString().chars().map(c -> c - '0').toArray();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (res == null) {
                head = new ListNode(arr[i]);
                res = head;
            } else {
                res.next = new ListNode(arr[i]);
                res = res.next;
            }
        }

        return head;
    }

    private static ListNode reverse(ListNode node) {
        if (node.next == null)
            return node;
        ListNode currentBox = node;
        ListNode previousBox = node.next;
        ListNode nextBox;
        while (currentBox != null) {
            nextBox = currentBox.next;

            currentBox.next = previousBox;

            previousBox = currentBox;

            currentBox = nextBox;
        }
        node.next = null;
        return previousBox;
    }

    private static BigInteger getInt(ListNode node) {
        BigInteger n = BigInteger.valueOf(0);
        while (node != null) {
            final int d = node.val;
            n = n.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(d));
            node = node.next;
        }
        return n;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
