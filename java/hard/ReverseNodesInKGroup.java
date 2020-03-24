package com.yangchd.leetcode.hard;

/**
 * @author yangchd  2018/6/22.
 *
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first, begin, next, end;
            first = dummy;
            while (hasNext(first, k)) {
                begin = first.next;
                next = begin.next;
                end = first;
                int mEnd = k;
                while (mEnd > 0) {
                    end = end.next;
                    mEnd--;
                }
                first.next = end;
                int num = k - 1;
                while (num > 0) {
                    begin.next = end.next;
                    end.next = begin;
                    begin = next;
                    next = next.next;
                    num--;
                }
                mEnd = k;
                while (mEnd > 0) {
                    first = first.next;
                    mEnd--;
                }
            }
            return dummy.next;
        }

        private boolean hasNext(ListNode node, int k) {
            ListNode copy = node.next;
            while (k > 0 && null != copy) {
                copy = copy.next;
                k--;
            }
            return k == 0;
        }
    }
}
