package com.dongshujin.leetcode;

public class Code160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode pointerA = headA;
        while (null != pointerA) {
            lenA++;
            pointerA = pointerA.next;
        }

        int lenB = 0;
        ListNode pointerB = headB;
        while (null != pointerB) {
            lenB++;
            pointerB = pointerB.next;
        }

        int daltLen = Math.abs(lenA- lenB);
        pointerA = headA;
        pointerB = headB;
        while (lenA > lenB) {
            pointerA = pointerA.next;
            lenA--;
        }
        while (lenA < lenB) {
            pointerB = pointerB.next;
            lenB--;
        }

        while (null != pointerA && null != pointerB) {
            if (pointerA == pointerB)
                return pointerA;
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return null;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

}
