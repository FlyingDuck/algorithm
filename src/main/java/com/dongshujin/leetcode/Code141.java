package com.dongshujin.leetcode;

/**
 * Linked List Cycle
 */
public class Code141 {

    public boolean hasCycle(ListNode head) {
        if (null == head)
            return false;
        if (null == head.next)
            return false;

        ListNode slowPointer = head;
        ListNode fastPointer = head.next;

        while (slowPointer != fastPointer) {
            // slow 1 step
            slowPointer = slowPointer.next;
            if (null == slowPointer)
                return false;
            // fast 2 steps
            fastPointer = fastPointer.next;
            if (null == fastPointer)
                return false;
            fastPointer = fastPointer.next;
            if (null == fastPointer)
                return false;
        }

        return true;
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
