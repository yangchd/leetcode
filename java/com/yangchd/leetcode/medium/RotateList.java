package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/10/16.
 *
 * 61.Rotate List
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 */
public class RotateList {
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    /**
     * 链表这种，可以考虑组成环再移动
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            int size = 1;
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
                size++;
            }
            k = k % size;
            if (k == 0) {
                return head;
            }

            // 构建环
            curr.next = head;
            curr = head;
            for (int i = 0; i < size - k - 1; i++) {
                curr = curr.next;
            }
            // 断开环
            head = curr.next;
            curr.next = null;
            return head;
        }
    }
}
