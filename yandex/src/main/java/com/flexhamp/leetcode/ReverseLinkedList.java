package com.flexhamp.leetcode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode node) {
        if (node == null)
            return null;
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


    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode y=head;
        while(y.next!=null){
            y=y.next;
        }
        ListNode x=head.next;
        head.next = null;
        reverseList(x);

        x.next = head;
        return y;
    }

    public static ListNode reverseList3(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    public static ListNode reverseList4(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }

        return prev;
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
