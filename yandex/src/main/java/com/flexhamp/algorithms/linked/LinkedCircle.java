package com.flexhamp.algorithms.linked;

public class LinkedCircle {
    public static void main(String[] args) {
        final ListNode node6 = new ListNode(6);
        final ListNode node2 = new ListNode(2, new ListNode(3, new ListNode(5, new ListNode(9, node6))));
        node6.next = node2;
        final ListNode node = new ListNode(1, new ListNode(4, node2));

        final ListNode headCircleNodes = findHeadCircleNodes(node);
        System.out.println(headCircleNodes != null ? headCircleNodes.val : null);
    }

    /*
    Найти вершину цикла в ондносвязном списке или вернуть null.
    https://www.youtube.com/watch?v=4KCQpH4zQPE

                3
              /   \
    1 - 4 - 2      5
             \    /
                6
    */
    public static ListNode findHeadCircleNodes(ListNode node) {
        ListNode slow = node, fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        while (node.val != slow.val) {
            node = node.next;
            slow = slow.next;
        }

        return node;
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
