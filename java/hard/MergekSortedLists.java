package com.yangchd.leetcode.hard;

/**
 * @author yangchd  2018/6/19.
 *
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergekSortedLists {
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
        /**
         * 利用归并排序提高效率
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return helper(lists, 0, lists.length - 1);
        }

        private ListNode helper(ListNode[] lists, int left, int right) {
            if (left > right) {
                return null;
            }
            if (left == right) {
                return lists[left];
            }
            int mid = left + (right - left) / 2;
            ListNode first = helper(lists, left, mid);
            ListNode last = helper(lists, mid + 1, right);
            return merge(first, last);
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            ListNode l = left;
            ListNode r = right;
            while (l != null && r != null) {
                if (l.val < r.val) {
                    cur.next = l;
                    l = l.next;
                } else {
                    cur.next = r;
                    r = r.next;
                }
                cur = cur.next;
            }
            if (l != null) {
                cur.next = l;
            }
            if (r != null) {
                cur.next = r;
            }
            return dummy.next;
        }
    }
}
