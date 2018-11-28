package com.dongshujin.year2018.leetcode;

import com.dongshujin.year2018.leetcode.structure.ListNode;

public class Code86 {

    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0);
        small.next = head;
        ListNode pre = small;
        ListNode p = head;

        while (null != p) {
            if (p.val < x) {
                if (small == pre) {
                    small = small.next;
                } else {
                    pre.next = p.next;
                    p.next = small.next;
                    small.next = p;
                }
            }
            pre = p;
            p = p.next;
        }
        return head;
    }

}
