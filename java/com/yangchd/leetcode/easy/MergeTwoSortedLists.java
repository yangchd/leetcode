package com.yangchd.leetcode.easy;


/**
 * @author yangchd  2018/6/15.
 *
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode n1 = new ListNode(0);
            ListNode n2 = n1;
            while (null != l1 || null != l2) {
                if (null == l1) {
                    n1.next = l2;
                    break;
                }
                if (null == l2) {
                    n1.next = l1;
                    break;
                }
                if (l1.val < l2.val) {
                    n1.next = l1;
                    l1 = l1.next;
                } else {
                    n1.next = l2;
                    l2 = l2.next;
                }
                n1 = n1.next;
            }
            return n2.next;
        }
    }
}
