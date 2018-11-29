package com.dongshujin.leetcode;

import com.dongshujin.leetcode.structure.ListNode;

public class Code234 {
    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next)
            return true;

        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = head;
        while (null != fast && null != fast.next) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = preSlow;
        ListNode head2 = null == fast ? slow : slow.next;

        reverse(head, head1);

        while (null != head1 && null != head2) {
            if (head1.val != head2.val)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    private void reverse(ListNode head, ListNode end) {
        if (end == head)
            return;
        if (end == head.next) {
            head.next = null;
            end.next = head;
            return;
        }


        ListNode left = head;
        ListNode mid = left.next;
        ListNode right = mid.next;

        left.next = null;
        while (end != left) {
            mid.next = left;

            left = mid;
            mid = right;
            right = right.next;
        }
    }

    public static void main(String[] args) {
        // [1,3,2,4,3,2,1]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        new Code234().isPalindrome(node1);
    }

}
