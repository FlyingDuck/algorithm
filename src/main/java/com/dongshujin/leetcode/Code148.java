package com.dongshujin.leetcode;

public class Code148 {

    public ListNode sortList(ListNode head) {
        if (null == head)
            return null;
        if (null == head.next)
            return head;

        ListNode mid = findMid(head);

        ListNode newHead = mid.next;
        mid.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(newHead);
        ListNode finalHead = merge(first, second);
        return finalHead;
    }

    private ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = slow;

        while (null != fast && null != fast.next) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return preSlow;
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode l = new ListNode(0), p = l;

        while (first != null && second != null) {
            if (first.val < second.val) {
                p.next = first;
                first = first.next;
            } else {
                p.next = second;
                second = second.next;
            }
            p = p.next;
        }

        if (first != null)
            p.next = first;

        if (second != null)
            p.next = second;

        return l.next;
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
