package com.dongshujin.year2018.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }


    public ListNode detectCycle2(ListNode head) {
        if (null == head)
            return null;
        if (null == head.next)
            return null;

        List<Boolean> footprintChain = new ArrayList<Boolean>();

        int foot = 0;
        ListNode slowPointer = head;
        footprintChain.add(true);

        while (null != slowPointer) {
            Boolean footprint = null;
            if (++foot < footprintChain.size())
                footprint = footprintChain.get(foot);

            if (null == footprint) {
                slowPointer = slowPointer.next;
                footprintChain.add(true);
            } else {
                return slowPointer.next;
            }
        }
        return null;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static void main(String[] args) {

    }

}
