package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/6/21.
 *
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode copy = dummy;
            while (null != copy.next && null != copy.next.next) {
                ListNode temp = copy.next;
                copy.next = copy.next.next;
                temp.next = copy.next.next;
                copy.next.next = temp;
                copy = copy.next.next;
            }
            return dummy.next;
        }
    }
}
