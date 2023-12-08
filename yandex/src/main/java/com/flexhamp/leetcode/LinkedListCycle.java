package com.flexhamp.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node1;

        ListNode head = node1;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        boolean res = false;
        while (true) {
            if (head != null) {
                if (head.next == null) {
                    break;
                } else if (nodeSet.contains(head)) {
                    res = true;
                    break;
                } else {
                    nodeSet.add(head);
                    head = head.next;
                }
            } else {
                break;
            }
        }
        return res;
//        final int min = -2147483647;
//        boolean res = false;
//        while (true) {
//            if (head != null) {
//                if (head.next == null) {
//                    break;
//                } else if (head.val == min) {
//                    res = true;
//                    break;
//                } else {
//                    head.val = min;
//                    head = head.next;
//                }
//            } else {
//                break;
//            }
//        }
//        return res;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


