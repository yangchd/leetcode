package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/6/14.
 *
 * 19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 *
 */
public class RemoveNthNodeFromEndOfList {
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
         * 通过往链表前部加空白的方式，只遍历一次就可达到目的
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(null == head){
                return null;
            }
            ListNode f = new ListNode(0);
            ListNode c = f;
            int m = n;
            while (m > 0){
                c.next = new ListNode(0);
                c = c.next;
                m--;
            }
            c.next = head;

            ListNode copy = head;
            while (null != copy){
                copy = copy.next;
                f = f.next;
            }
            if(f.next == head){
                return f.next.next;
            }
            f.next = f.next.next;
            return head;
        }
    }
}
