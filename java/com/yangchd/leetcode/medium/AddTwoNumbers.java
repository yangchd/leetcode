package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/3/21.
 *
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
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
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 主要就是一位一位加，然后进位。
     * 我这里采用的是递归的方法，网上还有一种，是单独设置一个进位标志的方法。
     * 运行效率，这个方法也能跑到50ms多点，算比较快的了，所以不改了。
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode thisNode = new ListNode(l1.val + l2.val);
            if(null != l1.next && null != l2.next){
                thisNode.next = addTwoNumbers(l1.next,l2.next);
            }else if(null == l1.next){
                thisNode.next = l2.next;
            }else {
                thisNode.next = l1.next;
            }
            checkNumbers(thisNode);
            return thisNode;
        }
        private void checkNumbers(ListNode node){
            int num = 10;
            while(null != node && node.val >= num){
                node.val -= num;
                if(null != node.next){
                    node.next.val += 1;
                    checkNumbers(node.next);
                }else {
                    node.next = new ListNode(1);
                }
            }
        }
    }

}
