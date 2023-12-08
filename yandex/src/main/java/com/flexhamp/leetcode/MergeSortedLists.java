package com.flexhamp.leetcode;

import java.util.Arrays;
import java.util.Objects;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 */
public class MergeSortedLists {

    public static void main(String[] args) {
//        ListNode[] lists = new ListNode[]{
//                new ListNode(1, new ListNode(4, new ListNode(5))),
//                new ListNode(1, new ListNode(3, new ListNode(4))),
//                new ListNode(2, new ListNode(6))
//        };
        ListNode[] lists = new ListNode[]{null};
//        ListNode[] lists = new ListNode[]{ new ListNode(0, new ListNode(2, new ListNode(5)))};
//        ListNode[] lists = new ListNode[]{
//                new ListNode(1, new ListNode(2, new ListNode(3))),
//                new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))),
////                new ListNode(2, new ListNode(6))
//        };
        mergeKLists(lists);
    }

    static class ListNodeHead {
        private ListNode head;

        public ListNode getHead() {
            return head;
        }

        public void setHead(ListNode head) {
            this.head = head;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNodeHead res = new ListNodeHead();

        int q = (int) Arrays.stream(lists).filter(Objects::nonNull).count();
        while (q > 0) {
            q = aggregator(lists, res, q);
        }

        return res.getHead();
    }

    public static int aggregator(ListNode[] lists, ListNodeHead node, int length) {
        int r = 0;
        int[] tmp = new int[length];
        int k = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                tmp[k] = lists[i].val;

                if (lists[i].next != null) {
                    lists[i] = lists[i].next;
                    r++;
                } else {
                    lists[i] = null;
                }
                k++;
            }
        }

        Arrays.sort(tmp);
        for (int j : tmp) {
            if (node.getHead() == null) {
                node.setHead(new ListNode(j));
            } else {
                node.setHead(g(node, j));
            }
        }

        return r;
    }

    static ListNode g(ListNodeHead node, int i) {
        ListNode newListNode = new ListNode(i);
        ListNode head = node.getHead();
        ListNode prev = null;
        ListNode curr = node.getHead();

        while (true) {
            if (i <= curr.val) {
                if (prev == null) {
                    prev = newListNode;
                    if (head == null) {
                        head = newListNode;
                    } else {
                        head = prev;
                        prev.next = curr;
                    }
                } else {
                    newListNode.next = curr;
                    prev.next = newListNode;
                }
                break;
            } else {
                if (curr.next == null) {
                    curr.next = new ListNode(i);
                    break;
                }

                curr = curr.next;
                if (prev == null) {
                    prev = head;
                } else {
                    prev = prev.next;
                }
            }
        }

        return head;
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
