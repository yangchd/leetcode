package medium

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	res := &ListNode{
		Val:  l1.Val + l2.Val,
		Next: nil,
	}
	if l1.Next != nil && l2.Next != nil {
		res.Next = addTwoNumbers(l1.Next, l2.Next)
	} else if l1.Next == nil {
		res.Next = l2.Next
	} else if l2.Next == nil {
		res.Next = l1.Next
	}
	checkNumbers(res)
	return res
}

func checkNumbers(l *ListNode) *ListNode {
	for l != nil && l.Val >= 10 {
		l.Val -= 10
		if l.Next != nil {
			l.Next.Val += 1
			checkNumbers(l.Next)
		} else {
			l.Next = &ListNode{
				Val:  1,
				Next: nil,
			}
		}
	}
	return l
}
