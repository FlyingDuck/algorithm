package com.dongshujin.leetcode;

import com.dongshujin.leetcode.structure.ListNode;

public class Code21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1)
            return l2;
        if (null == l2)
            return l1;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        if (p1.val < p2.val) {
            head = l1;
            p1 = p1.next;
        } else {
            head = l2;
            p2 = p2.next;
        }
        ListNode tail = head;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        if (p1 != null) {
            tail.next = p1;
        }
        if (p2 != null) {
            tail.next = p2;
        }
        return head;
    }
}
